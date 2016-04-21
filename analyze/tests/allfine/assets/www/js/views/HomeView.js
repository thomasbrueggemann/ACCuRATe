define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"ratchet",
	"notify",
	"moment",
	"text!templates/home.html",
	"i18n!js/locales/nls/home.js"
], function($, _, backbone, Jr, ratchet, notify, moment, homeTpl, loc) {

	var HomeView = Jr.View.extend({
		recordingActive: false,

		events: {
			"click [data-navigate]": "goto",
			"click #btn_toggle_recording": "toggleRecording"
		},

		// RENDER
		render: function() {
			// we have a sense id
			if (window.senseId) {
				if (typeof(analytics) !== 'undefined') analytics.trackView('Home View');

				this.recordingActive = localStorage.getItem("recordingActive") || false;
				if (typeof(this.recordingActive) === 'string' || this.recordingActive instanceof String) {
					this.recordingActive = this.recordingActive == "true";
				}

				collectionInterval = localStorage.getItem("gps-cycle") || (5 * 60);
				sendInterval = localStorage.getItem("data-transmission-cycle") || (5 * 60);

				// init the background plugin
				if (typeof(backgroundplugin) !== 'undefined' && window.configured == false) {

					backgroundplugin.configure(null, null, {
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


				// show broadcast button if broadcast mode is active
				var broadcastMode = localStorage.getItem("broadcastMode") || false;
				if (typeof(broadcastMode) === 'string' || broadcastMode instanceof String) {
					broadcastMode = (broadcastMode == "true");
				}

				var t = _.template(homeTpl)({
					"loc": loc,
					"broadcastMode": broadcastMode
				});

				this.$el.html(t);

				if (this.recordingActive == true) {
					var that = this;
					setTimeout(function() {
						that.stopRecording();
						that.recordingActive = false;
						console.log(window.lastPosition);
						that.toggleRecording();
						if (window.lastPosition) {
							that.updatePosition({
								"location": window.lastPosition
							});
						}
					}, 500);
				}
			}

			return this;
		},

		// GOTO
		goto: function(e) {
			var $e = $(e.target);
			if (!$e.data("navigate")) $e = $e.parent();

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
			this.undelegateEvents();
		},

		// TOGGLE RECORDING
		toggleRecording: function() {

			var $button = $("#btn_toggle_recording");
			var $span_stop_recording = $("#span_stop_recording");
			var $span_start_recording = $("#span_start_recording");

			if (!this.recordingActive) {
				// start recording
				this.startRecording();

				this.recordingActive = true;
				localStorage.setItem("recordingActive", true);

				// show / hide correct text and color
				$button.removeClass("btn-positive");
				$button.addClass("btn-negative");
				$span_stop_recording.show();
				$span_start_recording.hide();
			} else {
				// stop recording
				this.stopRecording();

				// show / hide correct text and color
				$button.removeClass("btn-negative");
				$button.addClass("btn-positive");
				$span_stop_recording.hide();
				$span_start_recording.show();

				this.recordingActive = false;
				localStorage.setItem("recordingActive", false);
			}
		},

		// START RECORDING
		startRecording: function() {
			var that = this;
			if (typeof(backgroundplugin) !== 'undefined') {
				navigator.geolocation.getCurrentPosition(function(data) {},
					function(error) {
						if (error && error.code) {
							if (error.code == 2 || error.code == 1) {
								notify.alert({
									title: loc.errorTitle,
									message: loc.gpsPermissionDenied
								});
							}
						}
					}
				);

				backgroundplugin.start(function(data) {
						if (typeof(analytics) !== 'undefined') analytics.trackEvent('Recording', 'started');

						if (typeof data == "string") {
							try {
								data = JSON.parse(data);
							} catch (ex) {
								console.error(ex);
							}
						}
						that.updatePosition(data);
					},
					function(e) {
						if (typeof(analytics) !== 'undefined') analytics.trackEvent('Recording', 'start failed');
						console.error('not started: ' + e.code + " / " + e.message);
					});
			}
		},

		// STOP RECORDING
		stopRecording: function() {
			var that = this;
			if (typeof(backgroundplugin) !== 'undefined') {

				backgroundplugin.stop(function() {
						if (typeof(analytics) !== 'undefined') analytics.trackEvent('Recording', 'stopped');

						that.updatePosition({
							"gpsstatus": "-",
							"networkstatus": "-"
						});
					},
					function(e) {
						if (typeof(analytics) !== 'undefined') analytics.trackEvent('Recording', 'stop failed');
						if (e) {
							console.error('not stopped: ' + e.code + " / " + e.message);
						} else {
							console.error('not stopped');
						}
					});
			}
		},

		// UPDATE POSITION
		updatePosition: function(info) {

			// a new location update is available
			if (info.location) {
				window.lastPosition = info.location;
			}

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
		}
	});

	return HomeView;
});