package um.healthguard.healthguard_nov;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Reminders extends AppCompatActivity {

//    NotificationCompat.Builder notification;

//    AlarmManager manager;
    private EditText drink_interval;
    private Button set_drink_button;
    private Button cancel_drink_button;
    private EditText reminderContent;
    private String interval;
    private String mins;
    private EditText minsInterval;
    public static String remindContent;

    public String getRemindContent() {
        return remindContent;
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_notification_receiver);

        android.support.v7.widget.Toolbar notificationToolbar = findViewById(R.id.notificationToolbar);
        setSupportActionBar(notificationToolbar);
        getSupportActionBar().setTitle("Notification Reminder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drink_interval = findViewById(R.id.drink_interval);
        set_drink_button = findViewById(R.id.drink_buton);
        cancel_drink_button = findViewById(R.id.drink_cancel);
        reminderContent = findViewById(R.id.reminder_content);
        minsInterval = findViewById(R.id.minsInterval);

        set_drink_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                interval = drink_interval.getText().toString();
                mins= minsInterval.getText().toString();
                remindContent = reminderContent.getText().toString();
                if(!TextUtils.isEmpty(interval)&&!TextUtils.isEmpty(remindContent)&&!TextUtils.isEmpty(mins)){

                    setInterval(Integer.parseInt(interval),Integer.parseInt(mins));

                }else{
                    Toast.makeText(Reminders.this,"All fields cannot be empty",Toast.LENGTH_LONG).show();
                }

            }
        });

        cancel_drink_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelNotice();
            }
        });

    }

    public void setInterval(int hourinterval , int minsinterval) {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(Reminders.this, AlarmNotificationReceiver.class);
        PendingIntent pendingintent = PendingIntent.getBroadcast(this, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000,
                1000 * 60 * minsinterval + 1000 * 60 * 60 * hourinterval ,pendingintent);
    }

    public void cancelNotice(){
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(Reminders.this, AlarmNotificationReceiver.class);
        PendingIntent pendingintent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        manager.cancel(pendingintent);
    }



//    public void notificationButtonClicked (View view){
//        Calendar calendar = Calendar.getInstance();
//
//        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(Reminders.this, AlarmNotificationReceiver.class);
//        PendingIntent pendingintent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
////        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),5*1000,pendingintent);
//        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000,AlarmManager.INTERVAL_FIFTEEN_MINUTES,pendingintent);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }


//    public void cancelNotification (View view){
//        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(Reminders.this, AlarmNotificationReceiver.class);
//        PendingIntent pendingintent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//        manager.cancel(pendingintent);
//
//    }
}