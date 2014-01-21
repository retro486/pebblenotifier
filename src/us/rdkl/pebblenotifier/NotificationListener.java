package us.rdkl.pebblenotifier;

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
		NotificationSetting nst = new NotificationSetting(sbn.getPackageName(), true);
		StorageHelper storage = new StorageHelper(getApplicationContext());
		
		boolean enabled;
		try {
			enabled = storage.getAppEnabled(nst.getPackageName());
		} catch(StorageHelper.AppNotFoundException ex) {
			storage.setAppEnabled(nst.getPackageName(), true);
			enabled = true;
		}
		
		if(enabled) {
			// Trim messages to 42 characters since the available space isn't long enough to show more.
			// If only capital "M"s are used, only 21 characters plus "..." will fit.
			String msg = sbn.getNotification().tickerText.toString();
			if(msg.length() > 42) {
				msg = msg.substring(0,42) + "...";
			}
			sendMessage(msg);
		}
	}

	@Override
	public void onNotificationRemoved(StatusBarNotification sbn) {
		// do nothing - we only care about new notifications
	}
}
