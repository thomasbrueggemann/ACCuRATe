define([
    "jquery",
    "underscore-min",
    "backbone-min",
    "junior",
    "notify",
    "text!templates/landing.html",
    "i18n!js/locales/nls/landing.js"
], function ($, _, backbone, Jr, notify, landingTpl, loc) {

	var LandingView = Jr.View.extend({

        events: {
            "click #inviteCode": "inviteCode",
            "click #buyWatch": "buyWatch"
        },

		// RENDER
		render: function() {

            if (typeof(analytics) !== "undefined") analytics.trackView("Startscreen View");

			var t = _.template(landingTpl)({
                "loc": loc
            });

            this.$el.html(t);

            return this;
		},

        // UNLOAD
        unload: function() {
            this.undelegateEvents();
        },

        // INVITE CODE
        inviteCode: function() {

            var that = this;

            // prompt user for code
            navigator.notification.prompt(
                loc.pleaseInviteCode,       // message
                function(results) {
                    
                    var code = results.input1;

                    if(results.buttonIndex == 2 && code.length > 0) {

                        var uuid = device.uuid;
                        var platform = device.platform;
                        var model = device.model;
                        var version = device.version;

                        $.post(window.host + "/devices/invite/accept", { 
                            "uuid": uuid, 
                            "platform": platform, 
                            "model": model, 
                            "version": version, 
                            "code": code 
                        }, 
                        function(data) {
                            if (typeof(data) === 'string' || data instanceof String) data = JSON.parse(data);

                            // check if response data is valid
                            if (data && data.success == true && data.device && data.device.length > 0) {
                                localStorage.setItem("senseId", data.device);
                                window.senseId = data.device;

                                //that.render();
                                Jr.Navigator.navigate("compass", {
                                    trigger: true
                                });
                            }
                            else {
                                notify.alert({
                                    title: loc.errorTitle,
                                    message: loc.inviteError
                                });
                            }
                        }).fail(function(xhr, errorType, error){
                            var json = $.parseJSON(xhr.responseText);
                            if (json && json.error) {
                                notify.alert({
                                    title: loc.errorTitle,
                                    message: json.error
                                });   
                            }
                            else {
                                notify.alert({
                                    title: loc.errorTitle,
                                    message: loc.inviteError
                                });   
                            }
                        });
                    }
                },
                loc.invitation,            // title
                [loc.cancel, loc.accept],  // buttonLabels
                ""                          // default
            );
        },

        // BUY WATCH
        buyWatch: function() {

            var url = null;

            if(device.platform == "Android") {
                url = "https://play.google.com/store/apps/details?id=com.frjsh.companion.watch2";
            }
            else if(device.platform == "iOS") {
                url = "https://itunes.apple.com/app/id933118632";
            }
            else if(device.platform.toLowerCase() == "amazon-fireos") {
                url = "http://www.amazon.de/FRJSH-Companion-for-Boats-WATCH/dp/B00OWAE9P6";
            }

            window.open(url, "_blank", "location=yes");
        }
	});

	return LandingView;
});