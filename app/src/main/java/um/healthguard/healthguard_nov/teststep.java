package um.healthguard.healthguard_nov;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class teststep extends AppCompatActivity implements SensorEventListener {

    TextView steps;
    TextView todaydate;
    TextView previoussteps;
    TextView nowtime;
    Button Reset;
    SensorManager sensorManager;
    Sensor mySensor;
    boolean running = false;
    int currentsteps ;
    int lastdaysteps ;
    int accumulatesteps ;
    int stepcounter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teststep);
        steps=findViewById(R.id.steps);
        todaydate=findViewById(R.id.date);
        previoussteps=findViewById(R.id.previoussteps);
        nowtime=findViewById(R.id.time);
        Reset =findViewById(R.id.reset);
        sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);

        currentsteps = 0;

        Thread t = new Thread() {
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                                todaydate.setText("Date:"+date);
                                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
                                nowtime.setText("Time:"+time);

                                StringTokenizer st = new StringTokenizer(time,":");
                                String hour = st.nextToken();
                                String minute = st.nextToken();
                                String second = st.nextToken();

                                if(hour.equals("00") && minute.equals("00") && second.equals("00")) {
                                    lastdaysteps = currentsteps;
                                    accumulatesteps += lastdaysteps;
                                    currentsteps = 0;
                                }

                                steps.setText(currentsteps+" ");
                                previoussteps.setText(lastdaysteps+" ");
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

    @Override
    protected void onResume() {

        super.onResume();

        running = true;

        lastdaysteps = LoadInt("yesterday");
        currentsteps = LoadInt("today");
        accumulatesteps = LoadInt("accumulate");
        stepcounter = LoadInt("counter");

        mySensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(mySensor != null){
            sensorManager.registerListener(this, mySensor,sensorManager.SENSOR_DELAY_UI);
        }
        else{
            Toast.makeText(this,"Sensor not found!", Toast.LENGTH_SHORT).show();
        }
    }


    protected void onPause() {
        super.onPause();
        running = true;
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if(running){
            stepcounter++;
            currentsteps = stepcounter - accumulatesteps;

            SaveInt("yesterday",lastdaysteps);
            SaveInt("today",currentsteps);
            SaveInt("accumulate",accumulatesteps);
            SaveInt("counter",stepcounter);
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public void SaveInt(String key, int integer){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key ,integer);
        editor.commit();
    }


    public int LoadInt(String key){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int savedValue = sharedPreferences.getInt(key, 0);
        return savedValue;
    }


    public void resetall(View view) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("You will lose all your steps data.")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                currentsteps=0;
                                lastdaysteps=0;
                                accumulatesteps=0;
                                stepcounter=0;
                                steps.setText("Today steps: " + currentsteps);
                                previoussteps.setText("Yesterday steps: " + lastdaysteps);
                            }
                        }
                )
                .setNegativeButton("Cancel", null)
                .setTitle("Warning")
                .create();
        myAlert.show();
    }
}
