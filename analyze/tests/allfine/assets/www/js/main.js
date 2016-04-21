var lang = localStorage.getItem("lang") || "de";
console.log(localStorage.getItem("lang"));

Storage.prototype.setObject = function(key, value) {
	this.setItem(key, JSON.stringify(value));
};

Storage.prototype.getObject = function(key) {
	var value = this.getItem(key);
	if (value && value != undefined && value != "undefined") return JSON.parse(value);
	return null;
};

// Specify global module dependencies
require.config({
	baseUrl: "js/libs",
	i18n: {
		locale: lang
	},
	waitSeconds: 0,
	paths: {
		"app": "../app",
		"router": "../router",
		"views": "../views",
		"collections": "../collections",
		"models": "../models",
		"notify": "../notify",
		"text": "../text",
		"templates": "../../templates",
		"i18n": "../i18n",
		"locales": "../locales"
	},
	shim: {
		"modernizr.custom.15848": {
			exports: "Modernizr"
		},
		"jquery": {
			exports: "$"
		},
		"underscore-min": {
			deps: ["jquery"],
			exports: "_"
		},
		"backbone-min": {
			deps: ["jquery"],
			exports: "Backbone",
			init: function(_, $) {
				Backbone.$ = $;
				return Backbone;
			}
		},
		"junior": {
			deps: ["jquery", "backbone-min", "underscore-min", "modernizr.custom.15848"],
			exports: "Jr"
		},
		"jquery.nouislider.full.min": {
			deps: ["jquery"]
		},
		"loggly.tracker": {
			deps: ["jquery"]
		},
		"sha512": {
			deps: ["jquery"]
		},
		"leaflet": {
			exports: "L"
		},
		"leaflet.label": {
			deps: ["leaflet"]
		},
		"leaflet.vector-markers": {
			deps: ["leaflet"]
		},
		"oms": {
			deps: ["leaflet"]
		}
	}
});

require([
	"app"
], function(App) {

	App.initialize();
});
