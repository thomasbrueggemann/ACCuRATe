cordova.define("com.frjsh.companion.sense.backgroundplugin.backgroundplugin", function(require, exports, module) { 
module.exports = {
    world: function(str, callback) {
        cordova.exec(callback, function(err) {
            callback('Nothing to hello.');
        }, "BackgroundPlugin", "hello", [str]);
    },
    configure: function(success, failure, config) {

        var params              = JSON.stringify(config.params || {}),
            url                 = config.url        || 'BackgroundPlugin_url',
            unitId              = config.unitId || "",
            stationaryRadius    = (config.stationaryRadius >= 0) ? config.stationaryRadius : 50,    // meters
            distanceFilter      = (config.distanceFilter >= 0) ? config.distanceFilter : 500,       // meters
            locationTimeout     = (config.locationTimeout >= 0) ? config.locationTimeout : 60,      // seconds
            desiredAccuracy     = (config.desiredAccuracy >= 0) ? config.desiredAccuracy : 100,     // meters
            desiredPowerRequirement = (config.desiredPowerRequirement >= 0) ? config.desiredPowerRequirement : 3,     // 1 = LOW, 2 = MED, 3 = HIGH
            debug               = config.debug || false,
            recordingInterval   = config.recordingInterval || 5,      // seconds
            sendingInterval     = config.sendingInterval || 5;      // seconds
            activityType        = config.activityType || "";      // seconds

        cordova.exec(success || function() {},
             failure || function() {},
             'BackgroundPlugin',
             'configure',
             [params, url, unitId, stationaryRadius, distanceFilter, locationTimeout, desiredAccuracy, desiredPowerRequirement, debug, recordingInterval, sendingInterval, activityType]);
    },
    start: function(success, failure, config) {
        cordova.exec(success || function() {},
             failure || function() {},
             'BackgroundPlugin',
             'start',
             []);
    },
    stop: function(success, failure) {
        cordova.exec(success || function() {},
            failure || function() {},
            'BackgroundPlugin',
            'stop',
            []);
    },
    startAnchorWatch: function(success, failure, config) {
        var lat         = config.lat || 0.0,
            lng         = config.lng || 0.0,
            accuracy    = config.accuracy || 0.0,
            radius      = config.radius || 25.0;

        cordova.exec(success || function() { alert("a"); },
            failure || function() {},
            'BackgroundPlugin',
            'startAnchorWatch',
            [lat, lng, accuracy, radius]);
    },
    stopAnchorWatch: function(success, failure) {
        cordova.exec(success || function() {},
            failure || function() {},
            'BackgroundPlugin',
            'stopAnchorWatch',
            []);
    },
    getAnchorWatchStatus: function(success, failure) {
        cordova.exec(success || function() {},
            failure || function() {},
            'BackgroundPlugin',
            'getAnchorWatchStatus',
            []);
    },
    startAnchorAlarm: function(success, failure) {
        cordova.exec(success || function() {},
            failure || function() {},
            'BackgroundPlugin',
            'startAnchorAlarm',
            []);
    },
    stopAnchorAlarm: function(success, failure) {
        cordova.exec(success || function() {},
            failure || function() {},
            'BackgroundPlugin',
            'stopAnchorAlarm',
            []);
    },
    forceRecordAndSend: function(success, failure) {
        cordova.exec(success || function() {},
            failure || function() {},
            'BackgroundPlugin',
            'forceRecordAndSend',
            []);
    },
    addLogbookEntry: function(success, failure, logbookentry, forceSendNow) {
        cordova.exec(success || function() {},
            failure || function() {},
            'BackgroundPlugin',
            'addLogbookEntry',
            [logbookentry, (forceSendNow != undefined && forceSendNow != null ? forceSendNow : false)]);
    },
    addNMEAEntry: function(success, failure, nmeaentry) {
        cordova.exec(success || function() {},
            failure || function() {},
            'BackgroundPlugin',
            'addNMEAEntry',
            [nmeaentry]);
    },
    finish: function(success, failure) {
        cordova.exec(success || function() {},
            failure || function() {},
            'BackgroundPlugin',
            'finish',
            []);  
    }
};

});
