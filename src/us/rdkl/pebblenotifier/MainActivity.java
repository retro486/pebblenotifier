package us.rdkl.pebblenotifier;

import java.util.UUID;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	protected NotificationListener nl;
	protected final static UUID PEBBLE_APP_UUID = UUID.fromString("843e198c-486e-4064-bde0-7d94f96d86a4");
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nl = new NotificationListener();
        
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View v) {
    	PebbleDictionary data = new PebbleDictionary();
    	data.addUint8(0, (byte) 42);
    	data.addString(1, "Test Notification");
    	PebbleKit.sendDataToPebble(getApplicationContext(), PEBBLE_APP_UUID, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
