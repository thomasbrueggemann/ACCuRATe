define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"notify",
	"moment",
	"ratchet",
	"views/BaseMapView",
	"text!templates/map.html",
	"text!templates/groupSelectItem.html",
	"i18n!js/locales/nls/map.js"
], function($, _, backbone, Jr, notify, moment, ratchet, BaseMapView, mapTpl, groupSelectItemTpl, loc) {

	var MapView = BaseMapView.extend({

		socket: null,
		lastGroup: null,

		events: {
			"touchend .group-select": "selectGroup",
			"touchend [data-navigate]": "goto"
		},

		// CONNECT SOCKET
		// connects to socket.io server and adds all relevant event handlers for 
		// using the realtime information
		connectSocket: function() {

			var that = this;

			// connect to socketio
			if (typeof(io) !== "undefined") {

				this.socket = io.connect(window.host, {
					"forceNew": true
				});

				// join socket io channel
				this.socket.on("handshake", function(msg) {
					console.log(msg);
				});

				// got new position update
				this.socket.on("position", function(position) {

					console.log("REALTIME: position");

					var l = L.latLng(position.lat, position.lon);

					// find boatpath
					if (position.device in that.path &&
						position.device in that.labels) {
						that.path[position.device].addLatLng(l);
						that.labels[position.device].setLatLng(l);
					} else {

						// boat not on map, reload the data
						if (that.lastGroup) {
							that.loadData(that.lastGroup);
						}
					}
				});

				// got new upload update
				this.socket.on("upload", function(upload) {

					var color = that.colors[upload.device._id];
					that.addUploadMarker(upload.upload, upload.lon.toFixed(5) + "," + upload.lat.toFixed(5), color);
				});

				// got new logbook entry
				this.socket.on("logbook", function(logbook) {
					console.log("REALTIME: logbook");
					var color = that.colors[logbook.device];
					that.addLogbookMarker(logbook.device, logbook.id, logbook.lon.toFixed(5) + "," + logbook.lat.toFixed(5), color)
				});
			}
		},

		// RESUME
		resume: function() {
			console.log("socket connected " + this.socket.connected);

			// reconnect to socket.io server
			//if (this.socket.connected === false && typeof(io) !== "undefined") {
			this.connectSocket();
			//window.location.reload();
			//}
		},

		// INITIALIZE
		initialize: function() {
			MapView.__super__.initialize.call(this);

			var that = this;

			this.connectSocket();

			document.addEventListener("resume", function() {
				//that.resume();
				window.location.reload();
			}, false);

			document.addEventListener("online", function() {
				//that.resume();
				window.location.reload();
			}, false);

			// send position
			if (window.sendPosition == true) {

				this.sendPosition();
				window.sendPosition = false;
			}
		},

		// RENDER
		render: function() {

			var that = this;
			if (typeof(analytics) !== "undefined") analytics.trackView("Map View");

			var t = _.template(mapTpl)({
				"loc": loc
			});

			this.$el.html(t);

			window.setTimeout(function() {

				// tile layer
				var streetLayer = L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
					"attribution": 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors'
				});

				// init map
				that.map = L.map("map", {
					attributionControl: false,
					zoomControl: false,
					detectRetina: true
				}).setView([50.957245, 6.9673224], 8);

				// keep track of map bounds at every change of mapview
				that.map.on("dragend moveend zoomend", function() {
					var bb = that.map.getBounds();
					localStorage.setItem("mapBounds", bb.toBBoxString());
				});

				var bb = localStorage.getItem("mapBounds");

				if (bb) {
					var bounds = bb.split(",");
					console.log(JSON.stringify(bounds));
					that.map.fitBounds([
						[bounds[1], bounds[0]],
						[bounds[3], bounds[2]]
					]);
				}

				L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
					maxZoom: 18
				}).addTo(that.map);

				// init the OMS plugin for leaflet
				that.initSpiderLegs();

				// load groups
				that.loadGroups();

				// set view title to currentgroup
				var currGroup = localStorage.getObject("currentGroup");
				if (currGroup) {
					$("#viewTitle").html(currGroup.name + "<span class=\"icon icon-caret\"></span>");

					// load some data for this group
					that.loadData(currGroup._id);
				}

			}, 300);

			return this;
		},

		// UNLOAD
		unload: function() {
			this.undelegateEvents();
		},

		// LOAD GROUPS
		loadGroups: function() {

			// load all groups of user
			$.get(window.host + "/groups/device/" + window.senseId + "?members=false", function(groups) {

				$("#group-selection").find(".group-select").remove();

				var t = _.template(groupSelectItemTpl)({
					"groups": groups
				});

				$("#group-selection").find(".table-view").prepend(t);

				window.setTimeout(function() {

					var currGroup = localStorage.getObject("currentGroup");
					if (!currGroup) {

						// select first list item
						$(".group-select").first().trigger("touchend");
					}

				}, 500);

			}).fail(function(xhr, textStatus, errorThrown) {

				// bad gateway
				if (xhr.status == 502) {
					notify.badGateway();
					return;
				}

				var data = JSON.parse(xhr.responseText);

				if (data.error) {
					notify.error(data.error);
				}
			});
		},

		// SELECT GROUP
		selectGroup: function(e) {

			if (!$("#group-selection").hasClass("visible")) return;

			var $e = $(e.target);
			if (!$e.data("groupid")) $e = $e.parent("[data-groupid]");

			// store the new group
			localStorage.setObject("currentGroup", {
				"_id": $e.data("groupid"),
				"name": $e.text()
			});

			// set the new view title
			$("#viewTitle").html($e.text() + "<span class=\"icon icon-caret\"></span>");

			var onPopoverHidden = function() {
				popover.style.display = "none";
				popover.removeEventListener("webkitTransitionEnd", onPopoverHidden);
			};

			// remove popover
			var popover = $("#group-selection")[0];
			popover.addEventListener("webkitTransitionEnd", onPopoverHidden);
			popover.classList.remove("visible");

			$(".backdrop").remove();

			// new group was selected, load the data
			this.loadData($e.data("groupid"));
		},

		// LOAD DATA
		loadData: function(groupId) {

			var that = this;

			// clear existing paths
			that.clearPaths();

			$("#loading-overlay").show();

			// if there is a previous group, leave that socket
			if (this.lastGroup) {
				this.socket.emit("leave", {
					"group": this.lastGroup
				});
			}

			// join the group
			this.socket.emit("join", {
				"group": groupId
			});
			this.lastGroup = groupId;

			var mapmatch = localStorage.getItem("map-match") || "false";

			// load positions of last 24 hours
			$.get(window.host + "/positions/" + groupId + "/hours/24?mapmatch=" + mapmatch, function(data) {

				$("#loading-overlay").hide();

				if (data && data.length > 0) {

					// add all new paths
					for (var i = 0; i < data.length; i++) {
						that.addPath(data[i]);
					};

					// resize map to fit
					var bb = localStorage.getItem("mapBounds");
					if (!bb) {
						that.fitPaths();
					}
				}

			}).fail(function(xhr, textStatus, errorThrown) {

				// bad gateway
				if (xhr.status == 502) {
					notify.badGateway();
					return;
				}

				$("#loading-overlay").hide();

				var data = JSON.parse(xhr.responseText);

				if (data.error) {
					notify.error(loc.loginError);
				}
			});
		},

		// GOTO
		goto: function(e) {

			var $e = $(e.target);
			if (!$e.data("navigate")) $e = $e.parent();

			if ($e.data("navigate").length <= 0) return;

			Jr.Navigator.navigate($e.data("navigate"), {
				trigger: true,
				animation: {
					type: Jr.Navigator.animations.SLIDE_STACK,
					direction: Jr.Navigator.directions.LEFT
				}
			});
		},

		// SEND POSITION
		sendPosition: function() {

			var collectionInterval = localStorage.getItem("gps-cycle") || (5 * 60);
			var sendInterval = localStorage.getItem("data-transmission-cycle") || (5 * 60);

			// configure the background plugin with necessary items
			var cfg = {
				url: window.host + "/positions/addjson",
				unitId: window.senseId,
				stationaryRadius: 10, // meters
				distanceFilter: 10, // meters
				locationTimeout: 30, //180, // 3 minutes
				desiredAccuracy: 20, // meters
				desiredPowerRequirement: 3, // 1 - 3 / low - high
				debug: false,
				recordingInterval: collectionInterval,
				sendingInterval: sendInterval,
				activityType: "otherNavigation"
			};

			// configure background plugin
			backgroundplugin.configure(function() {

				if (window.recordingActive) {

					// restart recording
					window.stopRecording();
					setTimeout(function() {
						window.startRecording();
					}, 500);
				}

			}, null, cfg);

			// fetch current positoin
			navigator.geolocation.getCurrentPosition(function(position) {

				var d = [{
					"sid": window.senseId, // Sense-ID
					"lat": parseFloat(position.coords.latitude), // Latitude
					"lng": parseFloat(position.coords.longitude), // Longitude
					"acc": parseInt(position.coords.accuracy), // Accuracy
					"utc": parseInt(moment.utc().format("X")), // UTC Unix Timestamp
					"spd": parseFloat(position.coords.speed) || 0, // Speed
					"crs": parseFloat(position.coords.heading) || 0, // Course
					"bat": 0, // Battery Level
					"chr": 0, // Charging
					"gsm": 0, // GSM Quality
					"shk": 0, // Maximum Acceleration
					"scr": 0, // Screen Brightness
					"alr": 0, // Anchor-Watch-Alarm active
				}];

				// post position
				$.post(window.host + "/positions/addjson", {
					"data": JSON.stringify(d)
				}, function(data) {});
			}, function(err) {});
		}
	});

	return MapView;
});