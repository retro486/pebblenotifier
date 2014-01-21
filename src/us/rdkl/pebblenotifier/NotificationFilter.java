package us.rdkl.pebblenotifier;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class NotificationFilter extends Activity {
	//	protected static ArrayList<NotificationSourceTracker> notification_history = new ArrayList<NotificationSourceTracker>();
	protected StorageHelper storage_helper;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        storage_helper = new StorageHelper(getApplicationContext());
        
        LinearLayout ll = new LinearLayout(getApplicationContext());
        ll.setLayoutParams(new LinearLayout.LayoutParams(
        		LinearLayout.LayoutParams.MATCH_PARENT,
        		LinearLayout.LayoutParams.MATCH_PARENT));
        ll.setOrientation(LinearLayout.VERTICAL);
        
        ScrollView sv = new ScrollView(getApplicationContext());
        sv.setLayoutParams(new ScrollView.LayoutParams(
        		ScrollView.LayoutParams.MATCH_PARENT,
        		ScrollView.LayoutParams.MATCH_PARENT));
        
        PackageManager pm = this.getPackageManager();
        
        for(NotificationSetting ns : storage_helper.getAllStates()) {
        	ApplicationInfo ai;
        	try {
        		 ai = pm.getApplicationInfo(ns.getPackageName(), PackageManager.GET_META_DATA);
        	}
        	catch(PackageManager.NameNotFoundException ex) {
        		// app may be uninstalled -- should remove it
        		storage_helper.deleteAppSetting(ns.getPackageName());
        		continue;
        	}
        	
        	CheckBox cb = new CheckBox(getApplicationContext());
        	cb.setChecked(ns.isVisible());
        	cb.setText(pm.getApplicationLabel(ai));
        	CheckChangedListener listener = new CheckChangedListener(getApplicationContext(), ns.getPackageName());
        	cb.setOnCheckedChangeListener(listener);
        	cb.setTextColor(Color.BLACK);
        	cb.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float)16.0);
        	ll.addView(cb);
        }
        
        sv.addView(ll);
        setContentView(sv);
    }
}
