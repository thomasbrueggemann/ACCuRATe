define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"ratchet",
	"text!templates/info.html",
	"i18n!js/locales/nls/info.js"
], function($, _, backbone, Jr, ratchet, infoTpl, loc) {

	var InfoView = Jr.View.extend({

		events: {
			"click a[data-return]": "returnTo",
		},

		// RENDER
		render: function() {
			if (typeof(analytics) !== 'undefined') analytics.trackView('Info View');

			var that = this;

			var t = _.template(infoTpl)({
				"loc": loc
			});

			that.$el.html(t);

			return this;
		},

		// UNLOAD
		unload: function() {
			this.undelegateEvents();
		},

		// RETURN TO
		returnTo: function(e) {
			e.preventDefault();

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
		},
	});

	return InfoView;

});