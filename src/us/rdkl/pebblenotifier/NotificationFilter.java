package us.rdkl.pebblenotifier;

import java.util.ArrayList;
import java.util.Iterator;

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
	protected static ArrayList<NotificationSourceTracker> notification_history = new ArrayList<NotificationSourceTracker>();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
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
        
        for(Iterator<NotificationSourceTracker> i = notification_history.iterator(); i.hasNext();) {
        	NotificationSourceTracker nst = i.next();
        	CheckBox cb = new CheckBox(getApplicationContext());
        	cb.setChecked(nst.isVisible());
        	try {
        		ApplicationInfo ai = pm.getApplicationInfo(nst.getPackageName(), PackageManager.GET_META_DATA);
        		cb.setText(pm.getApplicationLabel(ai));
        	}
        	catch(PackageManager.NameNotFoundException ex) {
        		// app may be uninstalled -- should remove it
        		notification_history.remove(nst);
        	}
        	CheckChangedListener listener = new CheckChangedListener(notification_history.indexOf(nst));
        	cb.setOnCheckedChangeListener(listener);
        	cb.setTextColor(Color.BLACK);
        	cb.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float)16.0);
        	ll.addView(cb);
        }
        
        sv.addView(ll);
        setContentView(sv);
    }
}
