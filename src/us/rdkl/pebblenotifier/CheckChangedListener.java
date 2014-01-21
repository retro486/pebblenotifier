package us.rdkl.pebblenotifier;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CheckChangedListener implements OnCheckedChangeListener {
	private String package_name;
	private StorageHelper storage;

	public CheckChangedListener(Context c, String package_name) {
		this.package_name = package_name;
		storage = new StorageHelper(c);
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		storage.setAppEnabled(package_name, arg1);
	}
	
}
