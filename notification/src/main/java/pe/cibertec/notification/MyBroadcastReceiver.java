package pe.cibertec.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
       /* if ("pe.cibertec.broadcast.ACTION".equalsIgnoreCase(action)) {
           Toast.makeText(context, "Acción ocurrió", Toast.LENGTH_SHORT).show();
           Intent newIntent=new Intent(context,NotificationActivity.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(context,1,newIntent,0);
            NotificationCompat.Builder notification=new NotificationCompat.Builder(context,"Canal")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notificacion")
                    .setContentText("Esta es una nueva notificación")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManagerCompat managerCompat=NotificationManagerCompat.from(context);
            managerCompat.notify(0,notification.build());

        }*/
        if (action.equalsIgnoreCase("android.intent.action.AIRPLANE_MODE")){
            Toast.makeText(context, "Acción ocurrió", Toast.LENGTH_SHORT).show();
            //CREAR NOTIFICACION
            Intent newIntent=new Intent(context,NotificationActivity.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(context,1,newIntent,0);
            NotificationCompat.Builder notification=new NotificationCompat.Builder(context,"Canal")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notificacion Modo avión")
                    .setContentText("Modo avión")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            //FIN CREAR NOTIFICACION


            //Mostrar la notificacion
            NotificationManagerCompat managerCompat=NotificationManagerCompat.from(context);
            managerCompat.notify(0,notification.build());
        }
    }

}
