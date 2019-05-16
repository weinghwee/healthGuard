package um.healthguard.healthguard_nov;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.storage.FirebaseStorage;

import java.text.DecimalFormat;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfile extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private String user_id;
    private CircleImageView profileImage2;
    private Uri mainImageURI = null;
    private TextView userProfileName;
    private TextView userProfileHeight;
    private TextView userProfileWeight;
    private TextView userProfileBMI;
    private TextView userProfileBMIStatus;
    private Button userAccountButton;
    private TextView profilestep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore = FirebaseFirestore.getInstance();

        profileImage2 = findViewById(R.id.profile_image_2);
        userProfileName = findViewById(R.id.userProfile_name);
        userProfileHeight = findViewById(R.id.userProfileHeight);
        userProfileWeight = findViewById(R.id.userProfileWeight);
        userProfileBMI = findViewById(R.id.userProfileBMI);
        userProfileBMIStatus = findViewById(R.id.userProfileBMIStatus);
        userAccountButton = findViewById(R.id.userProfileAccountSetting);
        profilestep = findViewById(R.id.profilestep);
        profilestep.setText(StepCount.getCurrentsteps()+"");
        userAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingIntent = new Intent(UserProfile.this,AccountActivity.class);
                startActivity(settingIntent);
                finish();
            }
        });

        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {

                        String name = task.getResult().getString("name");
                        String image = task.getResult().getString("profile_img");
                        String weight = task.getResult().getString("weight");
                        String height = task.getResult().getString("height");
                        String bmi = task.getResult().getString("bmi");
                        String bmiStatus = task.getResult().getString("bmiStatus");
                        mainImageURI = Uri.parse(image);

                        RequestOptions placeHolderRequest = new RequestOptions();
                        placeHolderRequest.placeholder(R.drawable.default_image);
                        Glide.with(UserProfile.this).setDefaultRequestOptions(placeHolderRequest).load(image).into(profileImage2);
                        userProfileName.setText(name);
                        userProfileHeight.setText(height);
                        userProfileWeight.setText(weight);
//                        DecimalFormat numberFormat = new DecimalFormat("#.00");
                        userProfileBMI.setText(bmi);
                        userProfileBMIStatus.setText(bmiStatus);

                    } else {
                        Toast.makeText(UserProfile.this, "No data exists", Toast.LENGTH_LONG).show();
                    }

                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(UserProfile.this, "Firestore Retrieval Error : " + error, Toast.LENGTH_LONG).show();

                }

//                acc_progressBar.setVisibility(View.INVISIBLE);
//                acc_button.setEnabled(true);
            }
        });

    }
}
