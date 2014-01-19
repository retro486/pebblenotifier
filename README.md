PebbleNotifier
==============

![](https://raw.github.com/retro486/pebblenotifier/master/res/drawable-hdpi/notification_face_ss.png)

Android application that makes use of the new notification access in Android 4.3+ to push ALL notifications to the Pebble watch as a Watchface instead of a Watchapp.

I wanted a Watchface, not a Watchapp, because I wanted to be able to have the face be usable as a home screen and I didn't need any user interaction. I also wanted to play with the new Andoird 4.3+ general notification access. This is a very simple Watchface.

Download APK
============

The precompiled APK is [available](https://dl.dropboxusercontent.com/u/4373155/Pebble/PebbleNotifier-v1.0.apk).

![](http://zxing.org/w/chart?cht=qr&chs=230x230&chld=L&choe=UTF-8&chl=https%3A%2F%2Fdl.dropboxusercontent.com%2Fu%2F4373155%2FPebble%2FPebbleNotifier-v1.0.apk)

Known Issues
============

* This app and Watchface are only tested on beta 2.0 firmware and Pebble app versions. I'm not sure if they'll work in 1.x firmware/Pebble app but I'm pretty sure it doesn't use any 2.0-specific features (such as the AccelerometerService).

* This app is untested in Android KitKat 4.4 but it should work without issue.

* When I say ALL notifications, I mean it. If it shows up in the Android notification bar, it'll buzz on your wrist. This includes "Wifi found" and software update messages, but this was the point of this app. The trade-off is that you don't need to specify which apps you want to listen to though I may add it in the future.

* Any notifications that you enable in the native Pebble notifications on your watch will override the Pebble Notifier Watchface. For example, if a phone call is triggered and you have "Incoming Calls" enabled in your Pebble app, the watch face will not update. For best results, disable all the notification options in the Pebble app.

* Because this app intercepts all notifications, none of the notifications will appear in the Pebble's "Notifications" menu item.

* Cycling though watchfaces will clear the notification area. Not so much an issue as I think it's a good way to clear it out quickly to switch to another face then back.
