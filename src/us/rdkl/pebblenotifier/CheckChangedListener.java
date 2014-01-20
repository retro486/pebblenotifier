package us.rdkl.pebblenotifier;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CheckChangedListener implements OnCheckedChangeListener {
	private int index;

	public CheckChangedListener(int index) {
		this.index = index;
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		NotificationFilter.notification_history.get(this.index).setVisible(arg1);
	}
	
}
