cordova.define("hu.dpal.phonegap.plugins.SpinnerDialog.SpinnerDialog", function(require, exports, module) { var exec = require('cordova/exec');

module.exports = {

	show : function(title, message) {
        cordova.exec(null, null, 'SpinnerDialog', 'show', [ title, message ]);
    },


    hide : function() {
        cordova.exec(null, null, 'SpinnerDialog', 'hide', [ "","" ]);
    }

};
});
