define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"notify",
	"jquery.nouislider.full.min",
	"text!templates/settingsOverview.html",
	"text!templates/settingsNameId.html",
	"text!templates/settingsGPS.html",
	"text!templates/settingsMapView.html",
	"i18n!js/locales/nls/settings.js"
], function($, _, backbone, Jr, notify, nouislider, settingsOverviewTpl,
	settingsNameIdTpl, settingsGPSTpl, settingsMapViewTpl, loc) {

	var SettingsView = Jr.View.extend({

		collectionInterval: 5 * 60 * 1000,
		sendInterval: 5 * 60 * 1000,
		show: null,

		events: {
			"click [data-return]": "returnTo",
			"click [data-navigate]": "goto",
			"slide .interval-slider": "slide",
			"set #interval-slider-data-transmission-cycle": "setData",
			"set #interval-slider-gps-cycle": "setGPS",
			"click #inviteCode": "inviteCode",
			//"click #btn_toggle_recording": "toggleRecording",
			"click #downloadWatch": "buyWatch",
			"click [data-action='logout']": "logout"
		},

		// INITIALIZE
		initialize: function(args) {
			this.show = args.show;
		},

		// RENDER
		render: function() {

			if (typeof(analytics) !== "undefined") analytics.trackView("Settings View (" + this.show + ")");

			// show settings selection
			switch (this.show) {
				case "nameid":
					this.renderNameId();
					break;

				case "gps":
					this.renderGPS();
					break;

				case "mapview":
					this.renderMapView();
					break;

				default:
					this.renderOverview();
					break;
			}

			return this;
		},

		// RENDER OVERVIEW
		renderOverview: function() {
			var that = this;
			var t = _.template(settingsOverviewTpl)({
				"loc": loc,
				"senseId": window.senseId,
				"platform": device.platform.toLowerCase()
			});

			this.$el.html(t);

			window.setTimeout(function() {
				that.initToggleButton();

				var $button = $("#btn_toggle_recording");
				$button.unbind("click");
				$button.bind("click", function() {
					that.toggleRecording();
				});
			}, 100);
		},

		// RENDER NAMEID
		renderNameId: function() {

			var t = _.template(settingsNameIdTpl)({
				"loc": loc,
				"senseId": window.senseId
			});

			this.$el.html(t);

			// load name
			$("#device_name").val(localStorage.getItem("device_name") || "");

			$.get(window.host + "/devices/getname/" + window.senseId, function(data) {
				if (data) {
					if (typeof(data) === "string" || data instanceof String) data = JSON.parse(data);
					if (data.name) {
						localStorage.setItem("device_name", data.name);
						$("#device_name").val(data.name);
					}
				}
			}).fail(function(xhr, errorType, error) {
				var json = $.parseJSON(xhr.responseText);
				if (json && json.error) {
					notify.alert({
						title: loc.errorTitle,
						message: json.error
					});
				} else {
					notify.alert({
						title: loc.errorTitle,
						message: loc.defaultError
					});
				}
			});
		},

		// RENDER MAP VIEW
		renderMapView: function() {
			var t = _.template(settingsMapViewTpl)({
				"loc": loc,
				"senseId": window.senseId
			});

			this.$el.html(t);

			window.setTimeout(function() {

				var mapmatch = localStorage.getItem("map-match") || "false";
				if (mapmatch === "true") {
					mapmatch = true;
					$("#mapmatch").addClass("active");
				} else {
					mapmatch = false;
					$("#mapmatch").removeClass("active");
				}

			}, 150);
		},

		// RENDER GPS
		renderGPS: function() {

			var that = this;
			this.collectionInterval = localStorage.getItem("gps-cycle") ? parseInt(localStorage.getItem("gps-cycle")) : 10;
			this.sendInterval = localStorage.getItem("data-transmission-cycle") ? parseInt(localStorage.getItem("data-transmission-cycle")) : 60;

			var t = _.template(settingsGPSTpl)({
				"loc": loc,
				"senseId": window.senseId,
				"showGpsSettings": device && device.platform == "Android",
				"showNetworkSettings": device && device.platform == "Android",
			});

			this.$el.html(t);

			// init slider
			window.setTimeout(function() {
				that.initSlider();
			}, 100);
		},

		// GOTO
		goto: function(e) {
			var $e = $(e.target);
			if (!$e.data("navigate")) $e = $e.parent();

			console.log($e.data("navigate"));

			Jr.Navigator.navigate($e.data("navigate"), {
				trigger: true,
				animation: {
					type: Jr.Navigator.animations.SLIDE_STACK,
					direction: Jr.Navigator.directions.LEFT
				}
			});
		},

		// UNLOAD
		unload: function() {
			$(document).off("newPosition");
			this.undelegateEvents();
			$("#btn_toggle_recording").unbind("click");
		},

		// INIT SLIDER
		initSlider: function() {

			var that = this;

			$(".interval-slider").noUiSlider({
				start: [5 * 60], // 5min
				range: {
					'min': [4, 10], // minimum: every 10s settps in 10s
					'15%': [1 * 60, 30], // beginning at 15% (1min): setpping 30s
					'40%': [10 * 60, 120], // beginning at 35% (10min): setpping 2min
					'60%': [1 * 60 * 60, 30 * 60], // 60% of the slider are <= 1h, setpping 30min
					'80%': [3 * 60 * 60, 60 * 60], // 80% of the slider are <= 3h, setpping 1h
					'max': [24 * 60 * 60] // maxmimum: every 24h
				}
			});

			var $gps = $("#interval-slider-gps-cycle");
			var $data = $("#interval-slider-data-transmission-cycle");

			$gps.val(this.collectionInterval);
			$gps.prev().html(this.secondsToFormattedTime($gps.val()));
			$data.val(this.sendInterval);
			$data.prev().html(this.secondsToFormattedTime($data.val()));
		},

		initToggleButton: function() {
			var $button = $("#btn_toggle_recording");
			var $span_stop_recording = $("#span_stop_recording");
			var $span_start_recording = $("#span_start_recording");

			if (window.recordingActive) {
				// show / hide correct text and color
				if ($button && $span_stop_recording && $span_start_recording) {
					$button.removeClass("btn-positive");
					$button.addClass("btn-negative");
					$span_stop_recording.show();
					$span_start_recording.hide();
				}
			} else {
				// show / hide correct text and color
				if ($button && $span_stop_recording && $span_start_recording) {
					console.log("buttons found");
					$button.removeClass("btn-negative");
					$button.addClass("btn-positive");
					$span_stop_recording.hide();
					$span_start_recording.show();
				}
			}
		},

		// SLIDE
		slide: function(e) {
			var $e = $(e.target);
			var value = $e.val();
			value = this.secondsToFormattedTime(value);
			$e.prev().html(value);
		},

		// TOGGLE RECORDING
		toggleRecording: function() {
			window.toggleRecording();
			this.initToggleButton();
		},

		// SET GPS
		setGPS: function(e) {

			console.log("setGPS");
			var $e = $("#interval-slider-gps-cycle");
			var value = parseInt($e.val());

			localStorage.setItem("gps-cycle", value);
		},

		// SET DATA
		setData: function(e) {

			var $e = $("#interval-slider-data-transmission-cycle");
			var value = parseInt($e.val());

			localStorage.setItem("data-transmission-cycle", value);
		},

		// RETURN TO
		returnTo: function(e) {
			e.preventDefault();

			try {
				var uri = window.location.hash;

				// save name id settings
				if (uri.indexOf("nameid") >= 0) {

					// save device name
					if (localStorage.getItem("device_name") != $("#device_name").val()) {
						localStorage.setItem("device_name", $("#device_name").val());

						if (window.senseId) {

							// post device name to server
							$.post(window.host + "/devices/setname", {
								"did": window.senseId,
								"name": $("#device_name").val()
							}, function(data) {
								console.log(data);
							}).fail(function(xhr, errorType, error) {
								var json = $.parseJSON(xhr.responseText);
								if (json && json.error) {
									notify.alert({
										title: loc.errorTitle,
										message: json.error
									});
								} else {
									notify.alert({
										title: loc.errorTitle,
										message: loc.defaultError
									});
								}
							});
						}
					}
				}

				// save mapview settings
				else if (uri.indexOf("mapview") >= 0) {

					localStorage.setItem("map-match", $("#mapmatch").hasClass("active"));
				}

				// save gps transmission settings
				else if (uri.indexOf("gps") >= 0) {
					var collectionInterval = localStorage.getItem("gps-cycle") || 10;
					var sendInterval = localStorage.getItem("data-transmission-cycle") || 60;

					backgroundplugin.configure(function() {
						if (window.recordingActive) {
							window.stopRecording();
							setTimeout(function() {
								window.startRecording();
							}, 1000);
						}
					}, null, {
						url: window.host + "/positions/addjson",
						unitId: window.senseId,
						stationaryRadius: 10, // meters
						distanceFilter: 10, // meters
						locationTimeout: 30, //180, // 3 minutes
						desiredAccuracy: 20, // meters
						desiredPowerRequirement: 3, // 1 - 3 / low - high
						debug: true,
						recordingInterval: collectionInterval,
						sendingInterval: sendInterval,
						activityType: "otherNavigation"
					});
				}
			} catch (e) {
				console.log(e);
			}

			var $e = $(e.target);
			if (!$e.data("return")) $e = $e.parents("[data-return]");

			var r = $e.data("return");
			if (r.indexOf("settings") === -1) {
				r = window.router.tabbar.getActive();
			}

			// return to last screen
			Jr.Navigator.navigate(r, {
				trigger: true,
				animation: {
					type: Jr.Navigator.animations.SLIDE_STACK,
					direction: Jr.Navigator.directions.RIGHT
				}
			});
		},

		// SECONDS TO FORMATTED TIME
		secondsToFormattedTime: function(sec_num) {
			var hours = Math.floor(sec_num / 3600);
			var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
			var seconds = sec_num - (hours * 3600) - (minutes * 60);

			if (hours < 10) {
				hours = "0" + hours;
			}
			if (minutes < 10) {
				minutes = "0" + minutes;
			}
			if (seconds < 10) {
				seconds = "0" + seconds;
			}

			return hours + ':' + minutes + ':' + seconds;
		},

		// INVITE CODE
		inviteCode: function() {

			var that = this;

			// prompt user for code
			navigator.notification.prompt(
				loc.pleaseInviteCode,
				function(results) {

					var code = results.input1;

					if (results.buttonIndex == 2 && code.length > 0) {

						var uuid = device.uuid;
						var platform = device.platform;
						var model = device.model;
						var version = device.version;

						$.post(window.host + "/devices/invite/accept", {
								"uuid": uuid,
								"platform": platform,
								"model": model,
								"version": version,
								"code": code
							},
							function(data) {
								if (typeof(data) === "string" || data instanceof String) data = JSON.parse(data);

								// check if response data is valid
								if (data && data.success == true) {

									Jr.Navigator.navigate("groups", {
										trigger: true
									});
								} else {
									notify.alert({
										title: loc.errorTitle,
										message: loc.inviteError
									});
								}

							}).fail(function(xhr, errorType, error) {

							var json = $.parseJSON(xhr.responseText);

							if (json && json.error) {
								notify.alert({
									title: loc.errorTitle,
									message: json.error
								});
							} else {
								notify.alert({
									title: loc.errorTitle,
									message: loc.inviteError
								});
							}
						});
					}
				},
				loc.invitation, // title
				[loc.cancel, loc.accept], // buttonLabels
				"" // default
			);
		},

		// UPDATE POSITION
		updatePosition: function(info) {

			if (info.dbLocationsCount) {
				$("#label_locations_count").text(info.dbLocationsCount);
			}

			// there is a new network status
			if (info.networkstatus) {
				if (info.networkstatus == "-") {
					$("#label_network_status").text(loc.inactive);
				} else {
					$("#label_network_status").text(loc.active);
				}
			}

			// there is a new gps status
			if (info.gpsstatus) {
				if (info.gpsstatus == "-") {
					$("#label_gps_status").text(loc.inactive);
				} else {
					$("#label_gps_status").text(loc.active);
				}
			}

			if (info.acceleration != undefined && info.acceleration != null) {
				if (info.acceleration == "-") {
					$('#label_acceleration').text("-");
				} else {
					$('#label_acceleration').text(info.acceleration.toFixed(1) + "m/s²");
				}
			}
			if (info.battery) {
				if (info.battery.level != undefined && info.battery.charging != undefined) {
					$('#label_battery').text(info.battery.level + "%" + (info.battery.charging == true || info.battery.charging == "true" ? " (Lädt)" : ""));
				} else {
					$('#label_battery').text("-");
				}
			}
			if (info.brightness != undefined && info.brightness != null) {
				if (info.brightness == "-") {
					$('#label_brightness').text("-");
				} else {
					$('#label_brightness').text(info.brightness + "%");
				}
			}

			var location = info.location;
			if (!location) return;

			//alert(location.lat + " " + location.lng + " " + location.acc); 

			if (location.lat)
				$('#label_lat').text(window.decToCoord(location.lat, "lat"));
			else
				$('#label_lat').text('-');

			if (location.lng)
				$('#label_lng').text(window.decToCoord(location.lng, "lon"));
			else
				$('#label_lng').text('-');

			if (location.spd && parseFloat(location.spd) >= 0)
				$('#label_spd').text((parseFloat(location.spd) * 1.94) + " ktn");
			else
				$('#label_spd').text('-');

			if (location.crs && parseFloat(location.crs) >= 0)
				$('#label_crs').text(location.crs + "°");
			else
				$('#label_crs').text('-');

			if (location.acc)
				$('#label_acc').text(location.acc.toFixed(0) + "m");
			else
				$('#label_acc').text('-');

			if (location.date) {
				if (!(location.date instanceof Date))
					location.date = new Date(location.date);
				if (location.date instanceof Date)
					$('#label_date').text(moment(location.date).format("lll")); //location.date.getDate() + "." + location.date.getMonth() + "." + location.date.getFullYear() + " " + location.date.getHours() + ":" + location.date.getMinutes() + ":" + location.date.getSeconds());
			} else
				$('#label_date').text('-');
		},

		// BUY WATCH
		buyWatch: function() {

			var url = null;

			if (device.platform == "Android") {
				url = "https://play.google.com/store/apps/details?id=com.frjsh.companion.watch2";
			} else if (device.platform == "iOS") {
				url = "https://itunes.apple.com/app/id933118632";
			} else if (device.platform == "Amazon") {
				url = "http://www.amazon.de/FRJSH-Companion-for-Boats-WATCH/dp/B00OWAE9P6";
			}

			window.open(url, "_blank", "location=yes");
		},

		// LOGOUT
		logout: function() {
			window.senseId = null;
			localStorage.clear();
			Jr.Navigator.navigate("login", {
				"trigger": true
			});
		}
	});

	return SettingsView;

});