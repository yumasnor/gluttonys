package com.example.gluttony.Notification;

import android.content.Context;
import android.os.Build;

public class Notification_Channel {
    Context context;
    public final static String Channel_1 = "Channel1";

    public Notification_Channel(Context context) {
        this.context = context;
    }

    public void notificationChannel(){
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.0)
    }
}

