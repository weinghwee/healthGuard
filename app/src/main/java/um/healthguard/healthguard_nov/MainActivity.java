package um.healthguard.healthguard_nov;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import junit.framework.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity{


    private android.support.v7.widget.Toolbar mainToolbar;
    private FirebaseAuth mAuth;
    private Button bmiCal;
    private Button reminders;
    private Button articles;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mToggle;
    private Button workoutBut;



    private Button stepButton;
    private Button webBut;
//    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webBut = findViewById(R.id.umexercise);
        webBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://umxercise.netlify.com/#/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });

        stepButton = findViewById(R.id.stepTrackBut);
        stepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stepIntent = new Intent(MainActivity.this,StepCount.class);
                startActivity(stepIntent);
            }
        });
//        todaydate = findViewById(R.id.step_date);
//        nowtime = findViewById(R.id.step_time);
//        steps = findViewById(R.id.todayStep);
//        previoussteps = findViewById(R.id.yesterdayStep);
//        totalStep = findViewById(R.id.totalStep);
//        sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);

//        currentsteps = 0;
//        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
//        todaydate.setText("Date:"+date);
//        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
//        nowtime.setText("Time:"+time);



        mainToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        mDrawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.navigation_acount_logout:
                        logOut();
                        return true;
                    case R.id.navigation_account_setting:
                        goToAccount();
                        return true;
                    case R.id.user_feedback:
                        sendToEmail();
                        return true;
                    case R.id.navigation_profile:
                        goToProfile();
                        return true;

                    default:
                        return false;
                }//close switch
            }
        });
        mToggle = new ActionBarDrawerToggle(this, mDrawer, R.string.open, R.string.close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setTitle("HealthGuard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mAuth = FirebaseAuth.getInstance();



        articles = findViewById(R.id.articles_main);
        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent articlesIntent = new Intent(MainActivity.this, mainArticles.class);
                startActivity(articlesIntent);
            }
        });

        bmiCal = (Button) findViewById(R.id.bmi_calculator);
        bmiCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bmiIntent = new Intent(MainActivity.this, BMIActivity.class);
                startActivity(bmiIntent);
            }
        }); //close listener for bmiCal

        reminders = (Button) findViewById(R.id.reminders);
        reminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reminderIntent = new Intent(MainActivity.this, Reminders.class);
                startActivity(reminderIntent);
            }
        });
        workoutBut = findViewById(R.id.workout_but);
        workoutBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent workoutIntent = new Intent(MainActivity.this,workout_main.class);
                startActivity(workoutIntent);
            }
        });



//        Thread t = new Thread() {
//            public void run() {
//                try {
//                    while (!isInterrupted()) {
//                        Thread.sleep(1000);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
//                                todaydate.setText("Date:"+date);
//                                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
//                                nowtime.setText("Time:"+time);
//
//                                StringTokenizer st = new StringTokenizer(time,":");
//                                String hour = st.nextToken();
//                                String minute = st.nextToken();
//                                String second = st.nextToken();
//
//                                if(hour.equals("00") && minute.equals("00") && second.equals("00")) {
//                                    lastdaysteps = currentsteps;
//                                    accumulatesteps += lastdaysteps;
//                                    currentsteps = 0;
//                                }
//
//                                steps.setText(currentsteps);
//                                previoussteps.setText( lastdaysteps);
//                                totalStep.setText(accumulatesteps);
//                            }
//                        });
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        t.start();


    }

    private void sendToEmail() {
        Intent feedback = new Intent(this,Feedback.class);
        startActivity(feedback);

    }

    private void goToProfile() {
        Intent profileIntent = new Intent(MainActivity.this, UserProfile.class);
        startActivity(profileIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            sendToLogin();
        }

    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("HealthGuard");
        builder.setMessage("Do you want to exit ? ");
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();

//        if (webView.canGoBack()) {
//            webView.goBack();
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void goToAccount() {
        Intent accIntent = new Intent(MainActivity.this, AccountActivity.class);
        startActivity(accIntent);

    }

    private void logOut() {
        mAuth.signOut();
        sendToLogin();
    }

    private void sendToLogin() {
        //intent to login
        Intent loginIntent = new Intent(MainActivity.this, Login.class);
        startActivity(loginIntent);
        finish();
    }

//    @Override
//    protected void onResume() {
//
//        super.onResume();
//
//        running = true;
//
//        lastdaysteps = LoadInt("yesterday");
//        currentsteps = LoadInt("today");
//        accumulatesteps = LoadInt("accumulate");
//        stepcounter = LoadInt("counter");
//
//        mySensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
//        if(mySensor != null){
//            sensorManager.registerListener(this, mySensor,sensorManager.SENSOR_DELAY_UI);
//        }
//        else{
//            Toast.makeText(this,"Sensor not found!", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    protected void onPause() {
//        super.onPause();
//        running = true;
//    }
//
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        if(running){
//            stepcounter++;
//            currentsteps = stepcounter - accumulatesteps;
//
//            SaveInt("yesterday",lastdaysteps);
//            SaveInt("today",currentsteps);
//            SaveInt("accumulate",accumulatesteps);
//            SaveInt("counter",stepcounter);
//        }
//    }
//
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }
//
//
//    public void SaveInt(String key, int integer){
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(key ,integer);
//        editor.commit();
//    }
//
//
//    public int LoadInt(String key){
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        int savedValue = sharedPreferences.getInt(key, 0);
//        return savedValue;
//    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(event.getAction()==KeyEvent.ACTION_DOWN){
//            switch (keyCode){
//                case KeyEvent.KEYCODE_BACK:
//                    if(webView.canGoBack()){
//                        webView.goBack();
//                    }
//                    else {
//                        finish();
////                        Intent main = new Intent(this,MainActivity.class);
////                        startActivity(main);
//                    }
//                    return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
