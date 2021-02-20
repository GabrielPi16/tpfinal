package com.tpfinal.osuti.ui.afiliaciones;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.tpfinal.osuti.R;

public class Notificacion extends BroadcastReceiver {

    private final static String CHANNEL_ID = "NOTIFICATION";

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"NOTIFICACION");

        builder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.logo_app)
                .setTicker("Hearty365")
                .setPriority(Notification.PRIORITY_MAX) // this is deprecated in API 26 but you can still use for below 26. check below update for 26 API
                .setContentTitle("Usted es nuevo afiliado")
                .setContentText("Felicitaciones se le enviara un email con su numero de socio")
                .setContentInfo("Info");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES. O ) { //esto era lo importantes
            int importance = NotificationManager.IMPORTANCE_HIGH ;
            NotificationChannel notificationChannel = new NotificationChannel( CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance) ;
            notificationManager.createNotificationChannel(notificationChannel) ;
        }

        notificationManager.notify(1, builder.build());
    }

}
