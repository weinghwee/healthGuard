package um.healthguard.healthguard_nov;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class BMIActivity extends AppCompatActivity {

    private EditText heightText;
    private EditText weightText;
    private TextView BMIvalue;
    private Button BMIbutton;
    private String user_id;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    private android.support.v7.widget.Toolbar mainToolbar;
    private TextView bmiText;
    private TextView bmiStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        heightText =  findViewById(R.id.heightText);
        weightText =  findViewById(R.id.weightText);
//        BMIvalue = findViewById(R.id.BMIvalue);
        BMIbutton = findViewById(R.id.BMIbutton);
        bmiText = findViewById(R.id.bmiText);
        bmiStatus = findViewById(R.id.bmiStatus);

        mainToolbar = findViewById(R.id.bmi_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("BMI Calculator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        firebaseAuth = FirebaseAuth.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){

                    if(task.getResult().exists()){

                        String weight = task.getResult().getString("weight");
                        String height = task.getResult().getString("height");

                        heightText.setText(height);
                        weightText.setText(weight);

                    }else{
                        Toast.makeText(BMIActivity.this,"No data exists" ,Toast.LENGTH_LONG).show();
                    }

                }else{
                    String error  = task.getException().getMessage();
                    Toast.makeText(BMIActivity.this,"Firestore Retrieval Error : " +error,Toast.LENGTH_LONG).show();

                }
                bmiText.setText(calculateBMI());
                bmiStatus.setText(displayBMI(Float.valueOf(calculateBMI())));

            }
        });

        BMIbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmiText.setText(calculateBMI());
                bmiStatus.setText(displayBMI(Float.valueOf(calculateBMI())));
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    public String calculateBMI() {
        String heightStr = heightText.getText().toString();
        String weightStr = weightText.getText().toString();
        float bmi=0;
        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            bmi = weightValue / (heightValue * heightValue);


        }
        return Float.toString(bmi);
    }

    private String displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = "very_severely_underweight";
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = "severely_underweight";
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "underweight";
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = "normal";
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "overweight";
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = "Moderately obese";
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = "Severely obese";
        } else {
            bmiLabel = "Very severely obese";
        }

        return bmiLabel;
    }
}
