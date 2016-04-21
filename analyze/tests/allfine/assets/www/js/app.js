define([
	"router",
	"notify",
	"moment",
	"loggly.tracker",
	"i18n!js/locales/nls/app.js",
	"views/NaviBarView"
], function(Router, notify, moment, loggly, loc, NaviBarView) {

	// ADDING COMMERCIAL BANNER
	var addBanner = function() {

		var ad_units = {
			ios: {
				banner: "ca-app-pub-9479234363241078/1656479343",
			},
			android: {
				banner: "ca-app-pub-9479234363241078/9179746148",
			}
		};

		// select the right Ad Id according to platform
		var admobid = (device.platform.toLowerCase() != "ios") ? ad_units.android : ad_units.ios;
		if (AdMob) {
			AdMob.createBanner({
				adId: admobid.banner,
				adSize: (device.platform.toLowerCase() != "amazon-fireos") ? "SMART_BANNER" : "BANNER",
				position: AdMob.AD_POSITION.BOTTOM_CENTER,
				autoShow: true,
				offsetTopBar: true
			});
		}
	};

	var initialize = function() {

		window.host = "https://allfine.frjsh.com";

		var logger = new LogglyTracker()
		logger.push({
			"logglyKey": "9fc9a2ea-957e-46d5-843e-678fb1ff459d"
		});

		// padding a number
		window.pad = function(n, width, z) {
			z = z || '0';
			n = n + '';
			return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
		};

		// catch errors in console
		window.onerror = function(errorMsg, url, lineNumber) {
			logger.push({
				"errMsg": errorMsg,
				"url": url,
				"line": lineNumber,
				"app": "sense",
				"product": "allfine",
				"senseId": window.senseId
			});
		};

		// phonegap is ready
		document.addEventListener("deviceready", function() {

			// device is online
			document.addEventListener("online", function() {
				window.offline = false;

				if ($("#offline").length) {
					location.reload();
				}
			}, false);

			// app is offline
			if (navigator.connection.type == Connection.NONE) {
				$("#offline").show();
				return;
			}

			window.configured = false;
			window.lastPosition = null;

			// do status bar magic
			if (typeof(StatusBar) !== 'undefined') {
				StatusBar.styleDefault();
				StatusBar.backgroundColorByHexString("#F6F6F6");
				StatusBar.show();
			}

			// device is offline
			document.addEventListener("offline", function() {
				if (!window.offline) {
					notify.alert({
						title: loc.noInternetTitle,
						message: loc.noInternetMessage
					});
				}

				window.offline = true;
			}, false);

			// gather sense id
			window.senseId = localStorage.getItem("senseId");

			// get broadcast mode
			var broadcastMode = localStorage.getItem("broadcastMode") || false;
			if (typeof(broadcastMode) === "string" || broadcastMode instanceof String) {
				window.broadcastMode = (broadcastMode == "true");
			}

			// try to read the device language
			navigator.globalization.getLocaleName(
				function(language) {

					// language found, wohoo!
					var lang = language.value.split("-")[0]
					moment.locale(lang);
					window.lang = lang;
					localStorage.setItem("lang", lang);
				},
				function() {

					// fallback
					moment.locale("de");
					window.lang = "de";
				}
			);

			// apply matching themes
			if (device.platform == "Android" || device.platform == "iOS") {
				$('link[href="css/ratchet-theme-ios.min.css"]').attr("href", "css/ratchet-theme-" + device.platform.toLowerCase() + ".css");
			}

			if (typeof(analytics) !== "undefined") {
				var trackingId = (device.platform == "iOS") ? "UA-54471229-11" : "UA-54471229-10";
				analytics.startTrackerWithId(trackingId);
				if (window.senseId) {
					analytics.setUserId(window.senseId);
				}
			}

			// Pass in our Router module and call it"s initialize function
			Router.initialize();

			// initialize Background Plugin and start it
			window.recordingActive = localStorage.getItem("recordingActive") || true;
			if (typeof(window.recordingActive) === 'string' || window.recordingActive instanceof String) {
				window.recordingActive = window.recordingActive == "true";
			}

			collectionInterval = localStorage.getItem("gps-cycle") || 10;
			sendInterval = localStorage.getItem("data-transmission-cycle") || 60;

			// TOGGLE RECORDING
			window.toggleRecording = function() {
				if (!window.recordingActive) {
					// start recording
					window.startRecording();
					window.recordingActive = true;
					localStorage.setItem("recordingActive", true);
				} else {
					// stop recording
					window.stopRecording();
					window.recordingActive = false;
					localStorage.setItem("recordingActive", false);
				}
			};

			// START RECORDING
			window.startRecording = function() {
				//var that = this;
				if (typeof(backgroundplugin) !== 'undefined') {
					navigator.geolocation.getCurrentPosition(function(data) {},
						function(error) {
							if (error && error.code) {
								if (error.code == 2 || error.code == 1) {
									notify.alert({
										title: loc.noGPSTitle,
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

						// a new location update is available
						if (data.location) {
							window.lastPosition = data.location;
						}

						$(document).trigger("newPosition", data);
					}, function(e) {
						console.log(JSON.stringify(e));
						if (typeof(analytics) !== 'undefined') analytics.trackEvent('Recording', 'start failed');
						console.error('not started: ' + e.code + " / " + e.message);
					});
				}
			};

			// STOP RECORDING
			window.stopRecording = function() {
				if (typeof(backgroundplugin) !== 'undefined') {
					backgroundplugin.stop(function() {
							if (typeof(analytics) !== 'undefined') analytics.trackEvent('Recording', 'stopped');
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
			};

			// TAKE A PICTURE event handler
			$(document).on("click", "#takePhoto", function() {
				var nb = new NaviBarView();
				nb.picture();
			});

			// SHARE BROADCAST LINK event handler
			$(document).on("click", "#shareBroadcast", function() {
				var nb = new NaviBarView();
				nb.shareBroadcastLink();
			});

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
					debug: false,
					recordingInterval: collectionInterval,
					sendingInterval: sendInterval,
					activityType: "otherNavigation"
				});

				if (window.recordingActive == true) {
					setTimeout(function() {
						window.startRecording();
					}, 750);
				}
			}

			// ADDING COMMERCIAL BANNER
			addBanner();

		}, false);
	};

	return {
		"initialize": initialize
	};
});