package com.sapien.devinl.intent_service_practice;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String LOG_TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The filter's action is BROADCAST_ACTION
        IntentFilter statusIntentFilter = new IntentFilter(Constants.BROADCAST_ACTION);

        // Instantiates a new DownloadStateReceiver
        ResponseReceiver receiver = new ResponseReceiver();

        // Registers the DownloadStateReceiver and its intent filters
        LocalBroadcastManager.getInstance(this).registerReceiver(
                receiver,
                statusIntentFilter);

        Intent intentService = new Intent(this, ServerIntent.class);
        intentService.setData(Uri.parse("This is merely a test yo."));

        startService(intentService);
    }

    private class ResponseReceiver extends BroadcastReceiver {
        // Prevents instantiation by other packages
        public ResponseReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(LOG_TAG, "onReceive()");
        }
    }
}
