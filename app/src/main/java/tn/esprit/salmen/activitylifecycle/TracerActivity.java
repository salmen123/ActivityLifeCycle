package tn.esprit.salmen.activitylifecycle;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Salmen on 24/03/2018.
 */

public class TracerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notify("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        notify("onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        notify("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notify("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        notify("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notify("onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        notify("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        notify("onSaveInstanceState");
    }

    // Méthode de Notification
    private void notify(String methodName) {
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti;
        if(strings[strings.length - 1].equals("MainActivity"))
        {
            if (methodName.equals("onCreate") || methodName.equals("onStart")|| methodName.equals("onResume"))
                noti = new Notification.Builder(this)
                        .setContentTitle(methodName + " " + strings[strings.length - 1])
                        .setAutoCancel(true).setSmallIcon(R.drawable.vert1)
                        .setContentText(name).build();
            else if (methodName.equals("onSaveInstanceState") || methodName.equals("onRestoreInstanceState"))
                noti = new Notification.Builder(this)
                        .setContentTitle(methodName + " " + strings[strings.length - 1])
                        .setAutoCancel(true).setSmallIcon(R.drawable.blue1)
                        .setContentText(name).build();
            else if (methodName.equals("onPause"))
                noti = new Notification.Builder(this)
                        .setContentTitle(methodName + " " + strings[strings.length - 1])
                        .setAutoCancel(true).setSmallIcon(R.drawable.yellow1)
                        .setContentText(name).build();
            else
                noti = new Notification.Builder(this)
                        .setContentTitle(methodName + " " + strings[strings.length - 1])
                        .setAutoCancel(true).setSmallIcon(R.drawable.red1)
                        .setContentText(name).build();
        }
        else {
            if (methodName.equals("onCreate") || methodName.equals("onStart")|| methodName.equals("onResume"))
                noti = new Notification.Builder(this)
                        .setContentTitle(methodName + " " + strings[strings.length - 1])
                        .setAutoCancel(true).setSmallIcon(R.drawable.vert2)
                        .setContentText(name).build();
            else if (methodName.equals("onSaveInstanceState") || methodName.equals("onRestoreInstanceState"))
                noti = new Notification.Builder(this)
                        .setContentTitle(methodName + " " + strings[strings.length - 1])
                        .setAutoCancel(true).setSmallIcon(R.drawable.blue2)
                        .setContentText(name).build();
            else if (methodName.equals("onPause"))
                noti = new Notification.Builder(this)
                        .setContentTitle(methodName + " " + strings[strings.length - 1])
                        .setAutoCancel(true).setSmallIcon(R.drawable.yellow2)
                        .setContentText(name).build();
            else
                noti = new Notification.Builder(this)
                        .setContentTitle(methodName + " " + strings[strings.length - 1])
                        .setAutoCancel(true).setSmallIcon(R.drawable.red2)
                        .setContentText(name).build();
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), noti);
    }

}
