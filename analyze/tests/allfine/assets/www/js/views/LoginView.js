define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"moment",
	"notify",
	"sha512",
	"text!templates/login.html",
	"i18n!js/locales/nls/login.js"
], function($, _, backbone, Jr, moment, notify, sha512, loginTpl, loc) {

	var LoginView = Jr.View.extend({

		events: {
			"click #loginButton": "submit",
			"click #registerButton": "register"
		},

		// RENDER
		render: function() {

			if (typeof(analytics) !== "undefined") analytics.trackView("Login View");

			var username = localStorage.getItem("username");
			var password = localStorage.getItem("password");

			// if we have a username / password stored, use it for http-basic-auth
			if (this.validate(username) && this.validate(password)) {

				this.submit(null, {
					"username": username,
					"password": password
				});

			} else {

				var t = _.template(loginTpl)({
					"loc": loc
				});

				this.$el.html(t);
			}

			return this;
		},

		// UNLOAD
		unload: function() {
			this.undelegateEvents();
		},

		// VALIDATE
		validate: function(input) {
			if (input) {
				if (input.length > 1) {
					if (input.indexOf("undefined") == -1) {
						return input;
					}
				}
			}

			return null;
		},

		// SUBMIT
		submit: function(e, override) {

			var that = this;
			if (e) e.preventDefault();

			if (!override) override = {};

			var formData = $.extend({
				"username": $("#username").val(),
				"password": CryptoJS.SHA512($("#password").val()) + ""
			}, override);

			// VALIDATE
			if (formData.username.indexOf("@") == -1 ||
				formData.username.indexOf(".") == -1) {
				notify.alert({
					"title": loc.error,
					"message": loc.validation.username
				});
				return;
			}

			formData["uuid"] = device.uuid;
			formData["platform"] = device.platform;
			formData["model"] = device.model;
			formData["version"] = device.version;

			if (!window.senseId) {
				formData["nodevice"] = true;
			}

			// do the login request
			$.post(window.host + "/users/login", formData, function(data) {

				if (data) {

					// if we have a user, save the credentials locally
					if (data.user) {

						localStorage.setItem("userid", data.user._id);
						localStorage.setItem("name", data.user.name);
						localStorage.setItem("username", formData.username);
						localStorage.setItem("password", formData.password);
					}

					if (data.device) {

						// store the senseid
						window.senseId = data.device._id;
						localStorage.setItem("senseId", window.senseId);
					}

					window.sendPosition = true;

					// ready, go to map
					Jr.Navigator.navigate("map", {
						"trigger": true
					});
				}

			}).fail(function(xhr, textStatus, errorThrown) {

				// bad gateway
				if (xhr.status == 502) {
					notify.badGateway();
					return;
				}

				var data = JSON.parse(xhr.responseText);

				localStorage.removeItem("userid");
				localStorage.removeItem("name");
				localStorage.removeItem("username");
				localStorage.removeItem("password");

				if (data.error) {
					notify.error(loc.loginError);
				}
			});

			return false;
		},

		// REGISTER
		register: function(e) {

			var that = this;

			e.preventDefault();

			// VALIDATE
			if ($("#reg_username").val().indexOf("@") == -1 ||
				$("#reg_username").val().indexOf(".") == -1) {
				notify.alert({
					"title": loc.error,
					"message": loc.validation.username
				});
				return;
			}

			if ($("#reg_password").val() != $("#reg_password2").val() || $("#reg_password").val().length <= 0) {
				notify.alert({
					"title": loc.error,
					"message": loc.validation.password
				});
				return;
			}

			var u = {
				"name": $("#reg_name").val(),
				"username": $("#reg_username").val(),
				"password": CryptoJS.SHA512($("#reg_password").val()) + "",
				"uuid": device.uuid,
				"platform": device.platform,
				"model": device.model,
				"version": device.version,
				"group": "Family" //loc.defaultGroup
			}

			// do the register post
			$.post(window.host + "/users/register/sense", u, function(r) {

				// registering was successfull
				if (r.success == true) {

					// store the senseid
					window.senseId = r.device._id;
					localStorage.setItem("senseId", window.senseId);

					var collectionInterval = localStorage.getItem("gps-cycle") || (5 * 60);
					var sendInterval = localStorage.getItem("data-transmission-cycle") || (5 * 60);

					window.sendPosition = true;

					// store the new default group
					localStorage.setObject("currentGroup", r.group);

					// if we have a user, save the credentials locally
					if (r.user) {
						localStorage.setItem("userid", r.user._id);
						localStorage.setItem("name", u.name);
						localStorage.setItem("username", u.username);
						localStorage.setItem("password", u.password);
					}

					// ready, go to map
					Jr.Navigator.navigate("map", {
						"trigger": true
					});
				}

			}).fail(function(xhr, textStatus, errorThrown) {

				// bad gateway
				if (xhr.status == 502) {
					notify.badGateway();
					return;
				}

				var data = JSON.parse(xhr.responseText);
				if (data.error) {
					notify.error(loc.registerError);
				}
			});
		}
	});

	return LoginView;
});