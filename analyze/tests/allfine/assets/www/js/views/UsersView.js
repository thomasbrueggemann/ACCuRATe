define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"ratchet",
	"text!templates/users.html",
	"i18n!js/locales/nls/users.js"
], function($, _, backbone, Jr, ratchet, usersTpl, loc) {

	var UsersView = Jr.View.extend({

		events: {
			"click a[data-return]": "returnTo"
		},

		// RENDER
		render: function() {
			if (typeof(analytics) !== 'undefined') analytics.trackView('Watch Users View');

			console.log("render users view");

			var that = this;

			var t = _.template(usersTpl)({
				"loc": loc,
				"users": []
			});

			that.$el.html(t);

			$.get(window.host + "/devices/" + window.senseId + "/users", function(data) {

				if (data) {
					if (typeof(data) === 'string' || data instanceof String) data = JSON.parse(data);
					var t = _.template(usersTpl)({
						"loc": loc,
						"users": data
					});

					that.$el.html(t);
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

			return this;
		},

		// UNLOAD
		unload: function() {
			this.undelegateEvents();
		},

		// RETURN TO
		returnTo: function(e) {
			e.preventDefault();

			if (window.senseId) {

				var users = "";
				$("[data-uid]").each(function() {
					if ($(this).hasClass("active")) {
						users += $(this).data("uid") + ";";
					}
				});

				if (users.indexOf(";") >= 0) {
					users = users.slice(0, -1);
				}

				// post device name to server
				$.post(window.host + "/devices/visible", {
					"did": window.senseId,
					"users": users
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

			var $e = $(e.target);
			if (!$e.data("return")) $e = $e.parent();

			// return to home
			Jr.Navigator.navigate($e.data("return"), {
				trigger: true,
				animation: {
					type: Jr.Navigator.animations.SLIDE_STACK,
					direction: Jr.Navigator.directions.RIGHT
				}
			});
		}
	});

	return UsersView;

});