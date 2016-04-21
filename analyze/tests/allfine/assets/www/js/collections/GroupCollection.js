define([
    "jquery",
    "underscore-min",
    "backbone-min",
    "backbone-localStorage",
    "models/GroupModel"
], function ($, _, backbone, ls, GroupModel) {

	var GroupCollection = Backbone.Collection.extend({

	    model: GroupModel,
	    localStorage: new Backbone.LocalStorage("GroupCollection"),

	    // INITIALIZE
	    initialize: function () {
	        this.bind("remove", this.onModelRemoved, this);
	    },

	    // ON MODEL REMOVED
	    onModelRemoved: function(model, collection, options) {
	    	console.log("remove model");
	    	model.destroy();
	    }

	});

	return GroupCollection;
});