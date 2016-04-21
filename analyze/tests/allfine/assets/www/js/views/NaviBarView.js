define([
    "jquery",
    "underscore-min",
    "backbone-min",
    "junior",
    "moment",
    "notify",
    "i18n!js/locales/nls/navibar.js",
], function ($, _, backbone, Jr, moment, notify, loc) {

    var NaviBarView = Jr.View.extend({

        // PICTURE
        picture: function() {

            var that = this;
            if(window.lastPosition) {

                // take a picture
                navigator.camera.getPicture(function(imageURI) {    
                
                    var options = new FileUploadOptions();
                    options.fileKey  = "file";
                    options.fileName = imageURI.substr(imageURI.lastIndexOf('/') + 1);
                    options.mimeType = "image/jpeg";
         
                    var params = new Object();
                    console.log(JSON.stringify(window.lastPosition));
                    params.time = window.lastPosition.date;
                    params.lat = window.lastPosition.lat;
                    params.lon = window.lastPosition.lng;
                    params.crs = window.lastPosition.crs;
                    params.spd = window.lastPosition.lat;
                    params.acc = window.lastPosition.acc;
                    params.did = window.senseId;
         
                    options.params = params;
                    options.chunkedMode = true;
         
                    var ft = new FileTransfer();
                    ft.upload(imageURI, window.host + "/devices/upload", 

                    // success
                    function(r) {
                        notify.alert({
                            title: loc.photoTitle,
                            message: loc.photoMessage
                        });
                    },

                    // error
                    function() {
                        notify.alert({
                            title: loc.errorTitle,
                            message: loc.noPhotoMessage
                        });
                    }, 
                    options);

                }, 

                // error
                function onFail(e) {}, 
                
                // options
                { 
                    quality: 40,
                    destinationType: Camera.DestinationType.FILE_URL,
                    sourceType : Camera.PictureSourceType.CAMERA,
                    encodingType: Camera.EncodingType.JPEG,
                    targetWidth: 1024,
                    targetHeight: 768
                });
            }
            else {
                notify.alert({
                    title: loc.noGPSTitle,
                    message: loc.noGPSMessage
                });
            }
        },

        // SHARE BROADCAST LIST
        shareBroadcastLink: function() {
            window.plugins.socialsharing.share(null, null, null, window.host + "/broadcast/" + window.senseId);
        }

    });

    return NaviBarView;

});
