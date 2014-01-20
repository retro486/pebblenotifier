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
		NotificationSourceTracker nst = new NotificationSourceTracker(sbn.getPackageName());
		int i = NotificationFilter.notification_history.indexOf(nst);
		if(i == -1) {
			NotificationFilter.notification_history.add(nst);
		}
		else {
			if(NotificationFilter.notification_history.get(i).isVisible()) {
				sendMessage(sbn.getNotification().tickerText.toString());
			}
		}
	}

	@Override
	public void onNotificationRemoved(StatusBarNotification sbn) {
		// do nothing - we only care about new notifications
	}
}
