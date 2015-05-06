Pebble Notify
==============

*NOTE:* This app is effectively abandoned as I no longer own a Pebble watch. Support will not be offered and the app on the appstore has been made free of charge.

![](https://raw.github.com/retro486/pebblenotifier/master/res/drawable-hdpi/notification_face_ss.png)

Android application that makes use of the new notification access in Android 4.3+ to push ALL notifications to the Pebble watch as a Watchface instead of a Watchapp.

I wanted a Watchface, not a Watchapp, because I wanted to be able to have the face be usable as a home screen and I didn't need any user interaction. I also wanted to play with the new Andoird 4.3+ general notification access. This is a very simple Watchface.

You can disable apps that have sent notifications in the Manage Notifications menu item. Checked items will push notifications; unchecked will not. Note that at least one notification needs to have come through before the app will appear in this list.

Download APK
============

The precompiled v1.3 APK is [available](https://dl.dropboxusercontent.com/u/4373155/Pebble/PebbleNotify-v1.3.apk)

![](http://zxing.org/w/chart?cht=qr&chs=230x230&chld=L&choe=UTF-8&chl=https%3A%2F%2Fdl.dropboxusercontent.com%2Fu%2F4373155%2FPebble%2FPebbleNotify-v1.3.apk)

Watchface Code
==============

The watchface code can be found on the [Notification Face](https://github.com/retro486/notification_face) Github.

The Android app has the ability to install the watchface to your watch without you having to download anything more.

Known Issues
============

* Any notifications that you enable in the native Pebble notifications on your watch will override the Pebble Notifier Watchface. For example, if a phone call is triggered and you have "Incoming Calls" enabled in your Pebble app, the watch face will not update. For best results, disable all the notification options in the Pebble app. (This may have been fixed in the latest Pebble app; it deosn't seem to be an issue anymore.)

* Because this app intercepts all notifications, none of the notifications will appear in the Pebble's "Notifications" menu item. (See above note.)

* Cycling though watchfaces will clear the notification area. Not so much an issue as I think it's a good way to clear it out quickly to switch to another face then back.
