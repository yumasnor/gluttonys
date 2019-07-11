package com.example.gluttony.Notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class Notification_Channel {
    Context context;
    public final static String Channel_1 = "Channel1";

    public Notification_Channel(Context context) {
        this.context = context;
    }

    public void notificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    Channel_1, "Channel_1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("This is channel1");

        NotificationManager manager = context.getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);
    }
    }
}

