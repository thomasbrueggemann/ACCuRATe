define([
    "jquery",
    "underscore-min",
    "backbone-min",
    "moment"
], function ($, _, backbone, moment) {

	var GroupModel = Backbone.Model.extend({
		defaults: {
			id: null,
			name: null,
			members: [{
				id: null,
				name: null
			}],
			tickets: [{
				id: null
			}]
		}
	});

	return GroupModel;
});