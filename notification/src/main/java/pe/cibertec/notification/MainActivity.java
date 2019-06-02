package pe.cibertec.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register();
        createNotificationChannel();
    }

    private void register() {
        MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        // intentFilter.addAction("pe.cibertec.broadcast.ACTION");
        // intentFilter.addAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        //intentFilter.addAction( Intent.ACTION_CAMERA_BUTTON);
        //intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
       // intentFilter.addAction(" android.intent.action.ACTION_CALL");
        //intentFilter.addAction(BluetoothAdapter.ACTION_REQUEST_ENABLE);

        this.registerReceiver(myBroadcastReceiver, intentFilter);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "pe.edu.notification.CHANNEL";
            String description = "Descripción";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Canal", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
