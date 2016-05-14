package com.sapien.devinl.intent_service_practice;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by DevinL on 5/10/2016.
 */
public class ServerIntent extends IntentService {
    private final String LOG_TAG = "SERVER_INTENT";

    /**
     * Default constructor to make Android happy. I don't ever use it. (not intentionally.. o.o)
     */
    public ServerIntent() {
        super("ServerIntent");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ServerIntent(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(LOG_TAG, "onHandleIntent");
        Log.d(LOG_TAG, intent.getDataString());

        Intent localIntent = new Intent(Constants.BROADCAST_ACTION);


        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }
}