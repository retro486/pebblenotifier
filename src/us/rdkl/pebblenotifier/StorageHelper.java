package us.rdkl.pebblenotifier;

import java.util.ArrayList;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;

public class StorageHelper {
	public static final String PREFS_NAME = "NotificationPrefsFile";
	
	private Context context;
	private SharedPreferences settings;
	SharedPreferences.Editor edit;
	
	public class AppNotFoundException extends Exception {
		private static final long serialVersionUID = 1L;
		
		public AppNotFoundException(String message) {
			super(message);
		}
	}
	
	public StorageHelper(Context c) {
		context = c;
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		edit = settings.edit();
	}
	
	public void setAppEnabled(String package_name, boolean state) {
		edit.putBoolean(package_name, state);
		edit.commit();
	}
	
	public void deleteAppSetting(String package_name) {
		edit.remove(package_name);
		edit.commit();
	}
	
	public boolean getAppEnabled(String package_name) throws AppNotFoundException {
		if(!settings.contains(package_name)) {
			throw new AppNotFoundException(package_name + " was not found in the settings.");
		}
		
		return settings.getBoolean(package_name, false);
	}
	
	public ArrayList<NotificationSetting> getAllStates() {
		ArrayList<NotificationSetting> t = new ArrayList<NotificationSetting>();
		Map<String, ?> all_settings = settings.getAll();
		
		for(String package_name : all_settings.keySet()) {
			boolean state = (Boolean) all_settings.get(package_name);
			t.add(new NotificationSetting(package_name, state));
		}
		
		return t;
	}
}
