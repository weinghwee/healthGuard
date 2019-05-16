package um.healthguard.healthguard_nov;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Locale;

public class displayTimer extends AppCompatActivity {
    private static long START_TIME_IN_MILLIS = 60000;
    private CountDownTimer mCountDownTimer;
    private TextView countsDown;
    private Button start;
    private Button pause;
    private Button resume;
    private Button next;
    private EditText timeValue;
    private Button set;
    VideoView mVideoView;
    private boolean running;
    private long timeLeft = START_TIME_IN_MILLIS;
    ArrayList<String> videoPaths;
    String uriPath;
    Uri uri;

    static int i=0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_timer);
        countsDown=findViewById(R.id.tv);
        start=findViewById(R.id.btn_start);
        pause=findViewById(R.id.btn_pause);
        resume=findViewById(R.id.btn_resume);
        next=findViewById(R.id.btn_next);
        set=findViewById(R.id.btn_set);
        timeValue = findViewById(R.id.timeValue);
        timeValue.setText("60");



        Intent intent = getIntent();
        videoPaths=intent.getStringArrayListExtra("videoPaths");


        getWindow().setFormat(PixelFormat.UNKNOWN);


        mVideoView = (VideoView)findViewById(R.id.videoview);

        uriPath = videoPaths.get(i);
        uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.start(); //need to make transition seamless.
            }
        });

        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(!running){
                    startTimer();
                }
            }
        });
        set.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setTime();
            }
        });
        pause.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(running){
                    pauseTimer();
                }
            }
        });
        resume.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(!running){
                    startTimer();
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if(timeLeft!=START_TIME_IN_MILLIS){

                    Toast.makeText(displayTimer.this, "Please finish your current exercise! ",
                            Toast.LENGTH_LONG).show();
                }else{
                    i++;
                    uriPath = videoPaths.get(i);
                    uri = Uri.parse(uriPath);
                    mVideoView.setVideoURI(uri);
                    mVideoView.requestFocus();
                    mVideoView.start();
                    mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mp.start(); //need to make transition seamless.
                        }
                    });




                }

            }
        });
        updateCountDownText();

    }

    private void startTimer(){
        mCountDownTimer=new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long l) {
                timeLeft=l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                if(i<videoPaths.size()-1){
                    final MediaPlayer mp = MediaPlayer.create(displayTimer.this, R.raw.alarm);
                    mp.start();
                    Toast.makeText(displayTimer.this, "You have completed the exercise! Click start to start again or Next to start another exercise! ",
                            Toast.LENGTH_LONG).show();
                    timeLeft=START_TIME_IN_MILLIS;
                    updateCountDownText();
                    running=false;}
                else{
                    Toast.makeText(displayTimer.this, "You have complete all exercises! Press next to exit",
                            Toast.LENGTH_LONG).show();
                    timeLeft=START_TIME_IN_MILLIS;
                    updateCountDownText();}

            }
        }.start();
        running=true;
    }

    private void updateCountDownText(){
        int minutes = (int) timeLeft/1000/60;
        int seconds = (int) timeLeft/1000%60;
        String timeLeftFormat = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        countsDown.setText(timeLeftFormat);
    }
    private void pauseTimer(){
        mCountDownTimer.cancel();
        running=false;

    }

    private void setTime(){

        if(timeLeft!=START_TIME_IN_MILLIS){
            Toast.makeText(displayTimer.this, "Please finish your current exercise! ",
                    Toast.LENGTH_LONG).show();
        }
        else{
            String time = timeValue.getText().toString();
            String timeInMs = time +"000";
            START_TIME_IN_MILLIS = Long.parseLong(timeInMs);
            timeLeft = START_TIME_IN_MILLIS;
            updateCountDownText();
        }
    }

}
