package um.healthguard.healthguard_nov;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


public class AccountActivity extends AppCompatActivity {

    private CircleImageView profileImage;
    private Uri mainImageURI = null;
    private String defaultImgURI = "https://firebasestorage.googleapis.com/v0/b/healthguard-35859.appspot.com/o/profile_images%2Fdefault_image.png?alt=media&token=33538924-c670-47a7-8b63-a6e5e37cbc04";
    private EditText acc_name;
    private Button acc_button;

    private StorageReference storageReference;
    private FirebaseAuth firebaseAuth;

    private ProgressBar acc_progressBar;

    private FirebaseFirestore firebaseFirestore;
    private String user_id;

    private EditText acc_weight;
    private EditText acc_height;

    private boolean isChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        android.support.v7.widget.Toolbar accountToolbar = findViewById(R.id.remindertoolbar);
        setSupportActionBar(accountToolbar);
        getSupportActionBar().setTitle("Account Setting");

        firebaseAuth = FirebaseAuth.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();
        storageReference = FirebaseStorage.getInstance().getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();

        profileImage = findViewById(R.id.profile_image);
        acc_button = findViewById(R.id.acc_button);
        acc_name = findViewById(R.id.acc_name);
        acc_progressBar = findViewById(R.id.acc_progressBar);
        acc_weight = findViewById(R.id.acc_weight);
        acc_height = findViewById(R.id.acc_height);

        acc_progressBar.setVisibility(View.VISIBLE);
        acc_button.setEnabled(false);

        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {

                        String name = task.getResult().getString("name");
                        String image = task.getResult().getString("profile_img");
                        String weight = task.getResult().getString("weight");
                        String height = task.getResult().getString("height");

                        mainImageURI = Uri.parse(image);
                        acc_name.setText(name);
                        acc_weight.setText(weight);
                        acc_height.setText(height);
                        RequestOptions placeHolderRequest = new RequestOptions();
                        placeHolderRequest.placeholder(R.drawable.default_image);
                        Glide.with(AccountActivity.this).setDefaultRequestOptions(placeHolderRequest).load(image).into(profileImage);

                    } else {
                        Toast.makeText(AccountActivity.this, "No data exists", Toast.LENGTH_LONG).show();
                    }

                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(AccountActivity.this, "Firestore Retrieval Error : " + error, Toast.LENGTH_LONG).show();

                }

                acc_progressBar.setVisibility(View.INVISIBLE);
                acc_button.setEnabled(true);
            }
        });


        acc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                if(isChanged) {

                final String user_name = acc_name.getText().toString();
                final String user_weight = acc_weight.getText().toString();
                final String user_height = acc_height.getText().toString();

                if (!TextUtils.isEmpty(user_name) && mainImageURI != null && !TextUtils.isEmpty(user_weight) && !TextUtils.isEmpty(user_height)) {
                    acc_progressBar.setVisibility(View.VISIBLE);
                    if (isChanged) {
                        user_id = firebaseAuth.getCurrentUser().getUid();

                        final StorageReference image_path = storageReference.child("profile_images").child(user_id + ".jpg");

                        image_path.putFile(mainImageURI).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                image_path.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {

                                        final String downloadUrl = uri.toString();
                                        defaultImgURI = downloadUrl;
                                        Map<String, String> userMap = new HashMap<>();
                                        userMap.put("name", user_name);
                                        userMap.put("profile_img", downloadUrl);
                                        userMap.put("weight", user_weight);
                                        userMap.put("height", user_height);
                                        userMap.put("bmi",calculateBMI(user_height,user_weight));
                                        userMap.put("bmiStatus",displayBMI(calculateBMI(user_height,user_weight)));

                                        firebaseFirestore.collection("Users").document(user_id).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {

                                                if (task.isSuccessful()) {
                                                    Toast.makeText(AccountActivity.this, "Successfully saved", Toast.LENGTH_LONG).show();
                                                } else {

                                                    String error = task.getException().getMessage();
                                                    Toast.makeText(AccountActivity.this, "Firestore error : " + error, Toast.LENGTH_LONG).show();
                                                }
                                                acc_progressBar.setVisibility(View.INVISIBLE);
                                            }
                                        });
                                        Toast.makeText(AccountActivity.this, "Image uploaded", Toast.LENGTH_LONG).show();
                                    }
                                });

                            }

                        }) // end on success listener
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        String error = e.getMessage();
                                        Toast.makeText(AccountActivity.this, "Error :" + error, Toast.LENGTH_LONG).show();
                                        acc_progressBar.setVisibility(View.INVISIBLE);
                                    }
                                });
                    } else {


                        Map<String, String> userMap = new HashMap<>();
                        userMap.put("name", user_name);
                        userMap.put("profile_img", mainImageURI.toString());
                        userMap.put("weight", user_weight);
                        userMap.put("height", user_height);
                        userMap.put("bmi",calculateBMI(user_height,user_weight));
                        userMap.put("bmiStatus",displayBMI(calculateBMI(user_height,user_weight)));
                        firebaseFirestore.collection("Users").document(user_id).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AccountActivity.this, "Successfully saved", Toast.LENGTH_LONG).show();
                                } else {
                                    String error = task.getException().getMessage();
                                    Toast.makeText(AccountActivity.this, "Firestore error : " + error, Toast.LENGTH_LONG).show();
                                }
                                acc_progressBar.setVisibility(View.INVISIBLE);

                            }
                        });
                    }
                    Intent mainIntent = new Intent(AccountActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();

                } else {
                    Toast.makeText(AccountActivity.this, "Please insert your information and profile picture", Toast.LENGTH_LONG).show();
                }
            }
        });//close acc_button

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if (ContextCompat.checkSelfPermission(AccountActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

//                        Toast.makeText(AccountActivity.this,"permission denied",Toast.LENGTH_LONG).show();
                        ActivityCompat.requestPermissions(AccountActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                    } else {
                        BringImagePicker();
                    }

                } else {
                    BringImagePicker();
                }
            }
        });
    }

    private void storeFirestore() {
        StorageReference image_path = storageReference.child("profile_images").child(user_id + ".jpg");
        image_path.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                final String user_name = acc_name.getText().toString();
                final String downloadUrl =
                        uri.toString();
                Map<String, String> userMap = new HashMap<>();
                userMap.put("name", user_name);
                userMap.put("profile_img", downloadUrl);
                firebaseFirestore.collection("Users").document(user_id).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(AccountActivity.this, "Successfully saved", Toast.LENGTH_LONG).show();

                        } else {

                            String error = task.getException().getMessage();
                            Toast.makeText(AccountActivity.this, "Firestore error : " + error, Toast.LENGTH_LONG).show();


                        }

                        acc_progressBar.setVisibility(View.INVISIBLE);

                    }
                });
                Toast.makeText(AccountActivity.this, "Image uploaded", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void BringImagePicker() {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(1, 1)
                .start(AccountActivity.this);
    }

    public String calculateBMI(String heightStr,String weightStr) {

        String bmiStr = "";
        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);
            DecimalFormat twoDForm = new DecimalFormat("#.##");
            float bmi = weightValue / (heightValue * heightValue);

             bmiStr= Float.toString(Float.valueOf(twoDForm.format(bmi)));

        }
        return bmiStr;
    }

    private String displayBMI(String x) {
        String bmiLabel = "";
        float bmi = Float.valueOf(x);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                mainImageURI = result.getUri();
                profileImage.setImageURI(mainImageURI);

                isChanged = true;

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();
            }
        }
    }
}
