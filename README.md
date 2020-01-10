---
title: Ionic Custom Notification 
description: One can change the dialog color and button color as per their requirement
---

# cordova-plugin-raqmiyat-custom-notification


## Installation
   ionic cordova plugin add cordova-plugin-raqmiyat-custom-notification (or)
   ionic cordova plugin add https://github.com/GMuthuraja/IonicPluginCustomNotification.git


## Supported Platforms
- Android

### How to Use
```
//paste it below the import section
declare var CustomNotification: any;

//button onclick
showNotification() { 
let options = {
      "title": "Info",
      "message":  "This is inform you that, you have created custom alert notification using Android Native",
      "headerColor": "#1E3652",
      "btnColor": "#8c7d54"
    };

    CustomNotification.display(options, (res) => {
      console.log(res);
    });
  }
```
