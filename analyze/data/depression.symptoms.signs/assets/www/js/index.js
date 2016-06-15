/**
 * Created by Leonid on 4/21/14.
 */
var app = {
	//b_Payment = false,
    purchased : false,                                          
    // Application Constructor
    initialize: function() {
        this.bindEvents();
        /*var ua = navigator.userAgent.toLowerCase();
        var isAndroid = ua.indexOf("android") > -1; //&& ua.indexOf("mobile");
        if(isAndroid) {
            setTimeout(function(){
                app.init();
            },1000);
        }
        else{
            app.init();
        }*/
    },
    // Bind Event Listeners
    //
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
        document.addEventListener("backbutton", this.onBackKeyDown, false);
        document.addEventListener("pause", this.OnPaused, false);
    	document.addEventListener("resume", this.OnResumed, false);
    },
    // deviceready Event Handler
    //
    // The scope of 'this' is the event. In order to call the 'receivedEvent'
    // function, we must explicity call 'app.receivedEvent(...);'
    onDeviceReady: function() {
        app.receivedEvent('deviceready');
    },
    //back key down event listener
    OnPaused: function() {
    	//alert('App paused');
    	//alert("pause");
	},

	OnResumed: function() {
		if (device.platform == "iOS")
		{
			if(localStorage.getItem("RateMeStatus") == "0")///Ready to start////
			{
				if( localStorage.getItem("b_Pass") == "false")
					setTimeout("ShowRateMeDialog()",20000);
			}
			else if(localStorage.getItem("RateMeStatus") == "1")///Timer is set////
				return;
			else
			{
				localStorage.getItem("RateMeStatus", "0");
			}
			window.localStorage.setItem("b_Pass", "false");
		}
    },    
	
	ShowRateMeDialog: function()
			{					
								
				if(localStorage.getItem("RateMeStatus") == "0")///Timer Ready?
				{
					window.localStorage.setItem("RateMeStatus", "1");///Timer is finished////
                    //HERE                    
                    navigator.notification.confirm(
                        'Help us grow and get more health tips by giving us 5 stars in the app store. It takes less then a minute!',
                        function(button) {
                            // yes = 1, no = 2, later = 3
                            if (button == '1') {    // Rate Now                            
                                if (device.platform == "iOS") {
                                    window.open('itms-apps://itunes.apple.com/app/id'); // get App ID from Apple Developer Account
                                } else if (device.platform == "Android") {
                                    window.open('market://details?id=depression.symptoms.signs'); // replace id with package name
                                } else{
                                    window.open('zune:reviewapp?appid='); // get App ID from Windows Developer Account
                                }
                    
                            } else if (button == '2') { // Later
                               window.localStorage.setItem("RateMeStatus", "0");
                            } else if (button == '3') { // No
                            }
                        },
                        'Love your Depression App?', 'Love It!,Later,Needs Work'); // update this line with the App Name
                        //HERE
				 }	
			},
			
    onBackKeyDown: function() {    	
    	var aa=document.getElementById('cStatus').value;
    	if(aa=='0')
    		{    			 
    			navigator.app.exitApp();
    			//navigator.app.backhistory()
    			//navigator.systemNotification.onBackground();
    		}
    	else   		
    		{   		

    			document.getElementById('cStatus').value='0';    			
    			window.location="#./index.html";    			
    		}
        
    },
    // Update DOM on a Received Event
    receivedEvent: function(id) {
    //	alert("receivedEvent");
        var ios = navigator.userAgent.match(/(iPad|iPhone|iPod)/g) ? true : false;
        if(ios){
            setTimeout(navigator.splashscreen.hide, 1000);
        }
        console.log('Received Event: ' + id);

        var ua = navigator.userAgent.toLowerCase();
        var isAndroid = ua.indexOf("android") > -1; //&& ua.indexOf("mobile");
        if(isAndroid) {
            setTimeout(function(){
                app.init();
            },1000);
        }
        else{
            app.init();
        }
    },

    hideAdWhenPurchased: function () {
        var ad = document.querySelectorAll('.menu-ad')[0];
        
        if (typeof ad == 'undefined') 
            return;

        ad.parentNode.removeChild(ad);
    },    
    showAdWhenNotPurchased: function(){
        var purchased = window.localStorage.getItem("AppPurchased");

        if (typeof purchased != "undefined" &&  purchased != null && purchased == "1")
            return;

        $('.main-menu').each(function(i, el) {
            var $el = $(el);

            if ($el.find('.menu-ad').length > 0)
                return;

            var $menuFavorite = $el.find('.menu-item.favorite').first();

            var $ad = $('<div class="menu-ad" data-bind="click:TapDailyFlirting"></div>');
            $menuFavorite.before($ad);
            kendo.bind($ad, FirstMenuViewModel);
        });
    },
    
    init: function(){
        window.lifehacksapp = new kendo.mobile.Application($(document.body), {
            platform: {
                device: "ipad", // Mobile device, can be "ipad", "iphone", "android", "fire", "blackberry", "wp", "meego"
                name: "ios", // Mobile OS, can be "ios", "android", "blackberry", "wp", "meego"
                ios: true, // Mobile OS name as a flag
                majorVersion: 7, // Major OS version
                minorVersion: "0.0", // Minor OS versions
                flatVersion: "500", // Flat OS version for easier comparison
                appMode: true, // Whether running in browser or in AppMode/PhoneGap/Icenium.
                tablet: "ipad" // If a tablet - tablet name or false for a phone.
            }
        });
		
        if(device.platform == "iOS"){
            window.storekit.init({

                debug: true, /* Because we like to see logs on the console */

                purchase: function (transactionId, productId) {
                                 
                    window.plugins.spinnerDialog.hide();
                                 
                    console.log('purchased: ' + productId);
					window.localStorage.setItem("AppPurchased", "1");
                    
                    // remove the add if it exists 
                    app.hideAdWhenPurchased();
                    
                    $(".menu-item.locked").attr("class","menu-item");
                                                                  $(".restore-button").attr("style","display: none");
                                 
                },
                restore: function (transactionId, productId) {
                                 
                    window.plugins.spinnerDialog.hide();
                                 
                    console.log('restored: ' + productId);
                                 
                    if(productId === 'subscribe.depression.tips'){
                                 
                        $(".menu-item.locked").attr("class","menu-item");
						window.localStorage.setItem("AppPurchased", "1");
                                 $(".restore-button").attr("style","display: none");
                    }
                },
                restoreCompleted: function () {
                                 
                    window.plugins.spinnerDialog.hide();
                                 
                    console.log('all restore complete');
					if (window.localStorage.getItem("AppPurchased") != "1")
					{
						window.localStorage.setItem("AppPurchased", "0");
					}
                },
                restoreFailed: function (errCode) {
                                 
                    window.plugins.spinnerDialog.hide();
                                 
                    console.log('restore failed: ' + errCode);
                },
                error: function (errno, errtext) {
                                 
                    window.plugins.spinnerDialog.hide();
                                 
                    console.log('Failed: ' + errtext);
                },
                ready: function () {
                    var productIds = [
                        "subscribe.depression.tips"
                    ];
                    window.storekit.load(productIds, function(validProducts, invalidProductIds) {
                        $.each(validProducts, function (i, val) {
                            console.log("id: " + val.id + " title: " + val.title + " val: " + val.description + " price: " + val.price);
                        });
                        if(invalidProductIds.length) {
                            console.log("Invalid Product IDs: " + JSON.stringify(invalidProductIds));
                        }
                    });
                }
            });
        }
        else if(device.platform=="Android"){
            inappbilling.init(            
                function(result){//success callback
                
                    console.log(result);
               
                },
                function(error){//failure callback
                    //alert("error while init - "+error);
                },
                {showLog:true},
                'subscribe.depression.tips'
            );
        }
        else{
			// We believe that there's only winphone 8 version other than iOS & Android
			$(".menu-item.locked").attr("class","menu-item");
            window.localStorage.setItem("AppPurchased", "1");
                    
                    // remove the add if it exists 
                    app.hideAdWhenPurchased();
                    
        }
    }
};
