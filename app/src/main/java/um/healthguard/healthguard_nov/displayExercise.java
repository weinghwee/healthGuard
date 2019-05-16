package um.healthguard.healthguard_nov;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class displayExercise extends AppCompatActivity {
    ArrayList<exercise> exerciseList;
    RecyclerView myrv;
    ListView listView;
    Button playButton;
    ArrayList<String> videoPaths;
    private android.support.v7.widget.Toolbar mainToolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_exercise);

        mainToolbar = findViewById(R.id.workoutdisplay_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        listView = (ListView) findViewById(R.id.exercise_list);
        Intent intent = getIntent();
        exerciseList = (ArrayList<exercise>)getIntent().getSerializableExtra("key");
        videoPaths=intent.getStringArrayListExtra("videoPaths");

        playButton=(Button)findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(displayExercise.this, displayTimer.class);
                intent.putStringArrayListExtra("videoPaths",videoPaths);
                startActivity(intent);


            }
        });

        ListAdapter listAdapter=new ListAdapter(this, exerciseList);

        listView.setAdapter(listAdapter);
//        myrv=(RecyclerView)findViewById(R.id.exerciseList);
//        RecyclerViewAdapter myAdapter= new RecyclerViewAdapter(this,exerciseList);
//        LinearLayoutManager topRatedLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
//        myrv.setLayoutManager(topRatedLayoutManager);
//        myrv.setAdapter(myAdapter);
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
