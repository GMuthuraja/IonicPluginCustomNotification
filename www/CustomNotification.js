var exec = require('cordova/exec');

module.exports.display = function (arg0, success, error) {
    exec(success, error, 'CustomNotification', 'showAlert', [arg0]);
};