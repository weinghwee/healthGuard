package um.healthguard.healthguard_nov;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class AlarmNotificationReceiver extends BroadcastReceiver {
    Reminders reminder = new Reminders();
    String x = reminder.getRemindContent();

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.drawable.hglogo_blue);
        notification.setTicker("tester yann");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Reminder");
        notification.setContentText(x);
        notification.setVibrate(new long[]{500, 500});

        NotificationManager nm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        nm.notify(0, notification.build());
    }
}
