define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"text!templates/tabbar.html",
	"i18n!js/locales/nls/tabbar.js",
	"notify"
], function($, _, backbone, Jr, tabbarTpl, loc, notify) {

	var TabBarView = Jr.View.extend({

		lastPosition: null,
		rendered: false,

		// INTIALIZE
		initialize: function() {
			if (typeof(analytics) !== "undefined") analytics.trackView("Message View");
		},

		// RENDER
		render: function() {

			var that = this;
			var t = _.template(tabbarTpl)({
				"loc": loc
			});

			$("body").append(t);
			this.rendered = true;

			$(document).on("touchend", "#addMessage", function() {
				that.openSelect();
			});

			// message has been selected
			$(document).on("change", "#addMessageActions", function() {
				that.addEntry();
			});
		},

		// SHOW
		show: function(active) {
			$("#tabbar").show();
			if (this.rendered == false) {
				this.render();
			}

			if (active) {
				$("#tabbar > .tab-item").removeClass("active");
				$("#tabbar > [href='#" + active + "']").addClass("active");
			}
		},

		// HIDE
		hide: function() {
			$("#tabbar").hide();
		},

		// OPEN SELECT
		openSelect: function() {
			console.log("openselect");
			$("#addMessageActions").val("_§_cancel");

			if (device.platform.toLowerCase() == "ios") {
				// fix for ios: need to focus first, wait for it...
				$("#addMessageActions")[0].focus();
			} else {
				window.setTimeout(function() {
					var element = $("#addMessageActions")[0],
						worked = false;

					// open select box automativally
					var $box = $("#addMessageActions");
					var pp = $box.position();

					if (document.createEvent) { // all browsers
						var e = document.createEvent("MouseEvents");
						e.initMouseEvent("mousedown", true, false, window, pp.left + 10, pp.top + 5, pp.left + 10, pp.top + 5, 0, false, false, false, false, 0, null);
						worked = element.dispatchEvent(e);

					} else if (element.fireEvent) { // ie
						worked = element.fireEvent("onmousedown");
					}

					console.log(worked);

					if (!worked) { // unknown browser / error
						alert("It didn't worked with your operating system.");
					}
				}, 300);
			}
		},

		// ADD ENTRY
		addEntry: function() {

			var that = this;

			if (!localStorage.getObject("currentGroup")) {
				notify.alert({
					title: loc.noCurrentGroupTitle,
					message: loc.noCurrentGroup
				});
				return;
			}

			// user is offline
			if (navigator.connection.type == Connection.NONE) {
				notify.error(loc.offlineMessage);
				return;
			}

			// FINALIZE ENTRY
			var finalizeEntry = function(adtion, text) {

				// get current position
				navigator.geolocation.getCurrentPosition(function(position) {

					that.lastPosition = position;
					var currGroup = localStorage.getObject("currentGroup");

					if (!currGroup) return;

					var entry = {
						"id": moment.utc().unix(),
						"status": "created",
						"action": action,
						"grp": currGroup ? currGroup._id : null,
						"description": text,
						"timestamp": moment.utc().toDate(),
						"course": that.lastPosition.coords.heading,
						"speed": that.lastPosition.coords.speed,
						"coords": {
							"latitude": that.lastPosition.coords.latitude,
							"longitude": that.lastPosition.coords.longitude
						}
					};

					// save entry in background-plugin
					backgroundplugin.addLogbookEntry(null, null, JSON.stringify(entry), true);
				});
			};

			var action = $("#addMessageActions").val();
			if (action == "_§_cancel") {
				return;
			}

			var textInput;
			if (action == "freetext") {
				var that = this;

				// prompt user for logbookname
				navigator.notification.prompt(
					loc.enterMessage, // message
					function(results) {
						var text = results.input1;

						if (results.buttonIndex == 2 && text.length > 0) {
							finalizeEntry(null, text);
						}
					},
					loc.enterMessageTitel, // title
					[loc.cancel, loc.save], // buttonLabels
					"" // default
				);

				return;
			}

			finalizeEntry(action, null);
		},

		// GET ACTIVE
		getActive: function() {

			// if a tab is the active one, return the route
			if ($("#tabbar > .active").length) {
				return $("#tabbar > .active").attr("href").replace("#", "");
			}
			// if none is active, return to the map
			else {
				return "map";
			}
		}
	});

	return TabBarView;
});