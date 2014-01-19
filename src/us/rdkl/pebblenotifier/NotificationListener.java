package us.rdkl.pebblenotifier;

import java.util.ArrayList;
import java.util.Arrays;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import android.service.notification.*;

public class NotificationListener extends NotificationListenerService {
			
	public NotificationListener() {
	}
	
	private void sendMessage(String msg) {
		PebbleDictionary data = new PebbleDictionary();
    	data.addUint8(0, (byte) 42);
    	data.addString(1, msg);
    	PebbleKit.sendDataToPebble(getApplicationContext(), MainActivity.PEBBLE_APP_UUID, data);
	}

	@Override
	public void onNotificationPosted(StatusBarNotification sbn) {
		sendMessage(sbn.getNotification().tickerText.toString());
	}

	@Override
	public void onNotificationRemoved(StatusBarNotification sbn) {
		// do nothing - we only care about new notifications
	}
}
