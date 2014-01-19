package us.rdkl.pebblenotifier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	protected NotificationListener nl;
	protected final static UUID PEBBLE_APP_UUID = UUID.fromString("843e198c-486e-4064-bde0-7d94f96d86a4");
	private static final String WATCHAPP_FILENAME = "notification_face.pbw";
	private static final int ID_ACTIVITY_UPDATEWATCHAPP = 1;
	
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
    
    public void launchNotificationPreferences(View v) {
    	startActivity(new Intent(android.provider.Settings.ACTION_SECURITY_SETTINGS));
    }
    
    public void installWatchface(View v) {
    	try {
            InputStream input = getAssets().open(WATCHAPP_FILENAME);
            File file = new File(Environment.getExternalStorageDirectory(), WATCHAPP_FILENAME);
            file.setReadable(true, false);
            OutputStream output = new FileOutputStream(file);
            try {
                    byte[] buffer = new byte[1024];
                    int read;
                    while ((read = input.read(buffer)) != -1)
                            output.write(buffer, 0, read);
                    output.flush();
            } finally {
                    output.close();
            }
            input.close();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/octet-stream");
            startActivityForResult(intent, ID_ACTIVITY_UPDATEWATCHAPP);
	    } catch (Exception e) {
	            Toast.makeText(this, getResources().getString(R.string.watch_app_install_failed), Toast.LENGTH_LONG).show();
	    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
