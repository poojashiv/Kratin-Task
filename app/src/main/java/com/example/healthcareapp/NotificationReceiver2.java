package com.example.healthcareapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationHelper2 notificationHelper2 = new NotificationHelper2(context);
        notificationHelper2.createNotification2();

    }
}