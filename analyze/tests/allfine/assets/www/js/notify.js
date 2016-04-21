define([
    "i18n!js/locales/nls/notify.js"
], function (loc) {

	// ALERT
	var alert = function(o, callback) {
		navigator.notification.alert(o.message, callback, o.title, "Ok");
	};

	// CONFIRM
	// return true/false
	var confirm = function(o, callback) {
		navigator.notification.confirm(
		    o.message, 
		    function(buttonIndex) {
		    	return callback(buttonIndex == 2);
		    },
		    o.title,
		    [loc.no, loc.yes] 
		);
	};

	// ERROR
	var error = function(message) {

		this.alert({
			"title": loc.thereWasAnError,
			"message": message,
		}, function() {});
	};

	// DEL
	var del = function(message, callback) {

		this.confirm({
			"title": loc.areYouSure,
			"message": message
		}, callback);
	};

	// BAD GATEWAY
	var badGateway = function() {
		this.error(loc.badGateway);
	};

	return {
		"alert": alert,
		"confirm": confirm,
		"error": error,
		"del": del,
		"badGateway": badGateway
	};
});