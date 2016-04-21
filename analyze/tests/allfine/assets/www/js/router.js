define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"views/HomeView",
	"views/SettingsView",
	"views/UsersView",
	"views/InfoView",
	"views/TabBarView",
	"views/LandingView",
	"views/LoginView",
	"views/MapView",
	"views/GroupsView",
	"views/GroupDetailView",
	"views/GroupCreateView"
], function($, _, backbone, Jr, HomeView, SettingsView, UsersView, InfoView, TabBarView, LandingView,
	LoginView, MapView, GroupsView, GroupDetailView, GroupCreateView) {
	var AppRouter = Jr.Router.extend({
		routes: {
			"": "login",
			"login": "login",
			"register": "login",
			"map": "map",
			"home": "home",
			"settings": "settings",
			"settings/:show": "settings",
			"users": "users",
			"groups": "groups",
			"group/create/:action": "group_create",
			"group/:id": "group",
			"info": "info",
			"logbook/:id": "logbook"
		},

		tabbar: null,
		currentView: null,

		// RENDERING
		rendering: function(view) {
			if (this.currentView) {
				this.currentView.unload();
			}

			this.currentView = view;
			this.renderView(this.currentView);
		},

		// LANDING
		landing: function() {
			this.rendering(new LandingView());
		},

		// HOME
		home: function() {
			this.rendering(new HomeView());
		},

		// SETTINGS
		settings: function(show) {
			this.tabbar.hide();

			if (this.currentView) {
				this.currentView.unload();
			}

			this.currentView = new SettingsView({
				"show": show
			});
			this.renderView(this.currentView);
		},

		// USERS
		users: function() {
			if (this.currentView) {
				this.currentView.unload();
			}

			this.currentView = new UsersView();
			this.renderView(this.currentView);
		},

		// GROUPS
		groups: function() {
			if (this.currentView) {
				this.currentView.unload();
			}

			this.tabbar.show("groups");

			this.currentView = new GroupsView();
			this.renderView(this.currentView);
		},

		// GROUP / :ID
		group: function(id) {
			this.tabbar.show("groups");

			if (this.currentView) {
				this.currentView.unload();
			}

			this.currentView = new GroupDetailView({
				"id": id
			});
			this.renderView(this.currentView);
		},

		// GROUP CREATE
		group_create: function(action) {
			this.tabbar.show("groups");

			if (this.currentView) {
				this.currentView.unload();
			}

			this.currentView = new GroupCreateView({
				"action": action
			});
			this.renderView(this.currentView);
		},

		// INFO
		info: function() {
			if (this.currentView) {
				this.currentView.unload();
			}

			this.currentView = new InfoView();
			this.renderView(this.currentView);
		},

		// LOGIN
		login: function() {
			if (this.currentView) {
				this.currentView.unload();
			}


			this.tabbar.hide();

			this.currentView = new LoginView();
			this.renderView(this.currentView);
		},

		// MAP
		map: function() {
			if (this.currentView) {
				this.currentView.unload();
			}

			this.tabbar.show("map");

			this.currentView = new MapView();
			this.renderView(this.currentView);
		}
	});

	// starting the app
	var initialize = function() {

		window.router = new AppRouter;
		window.router.tabbar = new TabBarView();

		// setup the http-basic auth
		$.ajaxSetup({
			cache: false,
			beforeSend: function(xhr) {

				var validate = function(input) {
					if (input) {
						if (input.length > 1) {
							if (input.indexOf("undefined") == -1) {
								return input;
							}
						}
					}

					return null;
				};

				var username = localStorage.getItem("username");
				var password = localStorage.getItem("password");

				// if we have a username / password stored, use it for http-basic-auth
				if (validate(username) && validate(password)) {
					xhr.setRequestHeader("Authorization", "Basic " + btoa(username + ":" + password));
				} else {
					Jr.Navigator.navigate("login", {
						"trigger": true
					});
				}
			}
		});

		Backbone.history.start();
	};

	return {
		initialize: initialize
	};
});