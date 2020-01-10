var exec = require('cordova/exec');

module.exports.displayCustomNotification = function (arg0, success, error) {
    exec(success, error, 'CustomNotification', 'displayNotification', [arg0]);
};