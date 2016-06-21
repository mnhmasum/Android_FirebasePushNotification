package net.androidtime.fcm;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by masum on 20/06/2016.
 */
public class MyFcmListenerService extends FirebaseMessagingService {
    private static String TAG = "MyFcmListenerService";

    @Override
    public void onMessageReceived(RemoteMessage message) {
        Log.e(TAG, "Message" + message.getData());
        Log.e(TAG, "From: " + message.getFrom());
        Log.e(TAG, "App Name: " + message.getData().get("app_name"));
        Log.e(TAG, "Notification Message Body: " + message.getNotification().getBody());
        Intent intent = new Intent("update-message");
        intent.putExtra("message", message.getNotification().getBody());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }
}