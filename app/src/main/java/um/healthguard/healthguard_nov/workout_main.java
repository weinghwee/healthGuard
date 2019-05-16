package um.healthguard.healthguard_nov;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class workout_main extends AppCompatActivity {

    ArrayList<workout_plan> workList=new ArrayList<>();
    ArrayList<exercise> exercise1=new ArrayList<>();
    ArrayList<exercise> exercise2=new ArrayList<>();
    ArrayList<exercise> exercise3=new ArrayList<>();
    ListView listView;
    RecyclerView myrv;
    private android.support.v7.widget.Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_main);

        mainToolbar = findViewById(R.id.workout_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        exercise1.add(new exercise(R.drawable.crunches_1, "Crunch", "android.resource://" + getPackageName() +
                "/raw/" + "crunches"));
        exercise1.add(new exercise(R.drawable.leglifting_1, "Leg Lifting","android.resource://" + getPackageName() +
                "/raw/" + "leglifting"));
        exercise1.add(new exercise(R.drawable.dumbbellsidebend_1, "Side Bend (Dumbbell)","android.resource://" + getPackageName() +
                "/raw/" + "dumbbellsidebend"));
        exercise1.add(new exercise(R.drawable.hanginglegraise_1, "Leg Lifting (Hanging)","android.resource://" + getPackageName() +
                "/raw/" + "hanginglegraise"));
        exercise1.add(new exercise(R.drawable.inclinesitups_1, "Sit up (Incline)","android.resource://" + getPackageName() +
                "/raw/" + "inclinesitups"));
        exercise1.add(new exercise(R.drawable.vsitup, "V Sit-up","android.resource://" + getPackageName() +
                "/raw/" + "vsitup"));
        exercise2.add(new exercise(R.drawable.weightedpushups_2, "Push-up (Weighted)","android.resource://" + getPackageName() +
                "/raw/" + "weightedpushups"));
        exercise2.add(new exercise(R.drawable.declinepushup_2, "Push-up (Decline)","android.resource://" + getPackageName() +
                "/raw/" + "declinepushup"));
        exercise2.add(new exercise(R.drawable.divebomberpushup_2, "Push-up (Dive Bomber)","android.resource://" + getPackageName() +
                "/raw/" + "divebomberpushup"));
        exercise2.add(new exercise(R.drawable.dumbellpushup_2, "Push-up (Dumbbell)","android.resource://" + getPackageName() +
                "/raw/" + "dumbellpushup"));
        exercise2.add(new exercise(R.drawable.onearmpushups_2, "Push-up (One hand)","android.resource://" + getPackageName() +
                "/raw/" + "onearmpushups"));
        exercise2.add(new exercise(R.drawable.dumbbellchestpress_2, "Chest Press (Dumbbell)","android.resource://" + getPackageName() +
                "/raw/" + "dumbbellchestpress"));
        exercise3.add(new exercise(R.drawable.backsquat_3, "Back Squat","android.resource://" + getPackageName() +
                "/raw/" + "backsquat"));
        exercise3.add(new exercise(R.drawable.benchjumps_3, "Bench Jump","android.resource://" + getPackageName() +
                "/raw/" + "benchjumps"));
        exercise3.add(new exercise(R.drawable.bulgariansplitsquats_3, "Split Squat (Bulgarian)","android.resource://" + getPackageName() +
                "/raw/" + "bulgariansplitsquats"));
        exercise3.add(new exercise(R.drawable.dumbbelljump_3, "Dumbbell Jump","android.resource://" + getPackageName() +
                "/raw/" + "dumbbelljump"));
        exercise3.add(new exercise(R.drawable.dumbbelllunge_3, "Dumbbell Lunge","android.resource://" + getPackageName() +
                "/raw/" + "dumbbelllunge"));
        exercise3.add(new exercise(R.drawable.frontbarbellsquat_3, "Front Barbell Squat","android.resource://" + getPackageName() +
                "/raw/" + "frontbarbellsquat"));
        workList.add(new workout_plan(R.drawable.abs_man, "Abs", exercise1, passVideoPath(exercise1)));
        workList.add(new workout_plan(R.drawable.workout1_snip, "Chest", exercise2, passVideoPath(exercise2)));
        workList.add(new workout_plan(R.drawable.leg_1, "Leg", exercise3, passVideoPath(exercise3)));
        myrv = (RecyclerView) findViewById(R.id.exerciseList);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, workList);
        LinearLayoutManager topRatedLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        myrv.setLayoutManager(topRatedLayoutManager);
        myrv.setAdapter(myAdapter);
    }

    public ArrayList<String> passVideoPath(ArrayList<exercise> exercises){
        ArrayList<String> videoPaths=new ArrayList<>();
        for(int i=0;i<exercises.size();i++){
            videoPaths.add(exercises.get(i).videoPath);
        }
        return videoPaths;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
