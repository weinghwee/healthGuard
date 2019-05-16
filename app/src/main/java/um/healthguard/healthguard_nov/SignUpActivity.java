package um.healthguard.healthguard_nov;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText regEmailText;
    private EditText regPasswordText;
    private EditText regConfirmPasswordText;
    private Button registerButton;
    private Button alreadyButton;
    private ProgressBar regProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        regEmailText = (EditText)findViewById(R.id.regEmail);
        regPasswordText = (EditText)findViewById(R.id.regPassword);
        regConfirmPasswordText = (EditText)findViewById(R.id.regconfirmPassword);
        registerButton = (Button)findViewById(R.id.regButton);
        alreadyButton = (Button)findViewById(R.id.alreadyButton);
        regProgressBar = (ProgressBar)findViewById(R.id.regprogressBar);

        alreadyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = regEmailText.getText().toString();
                String password = regPasswordText.getText().toString();
                String confirm = regConfirmPasswordText.getText().toString();

                if(!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(confirm)){
                    if(password.equals(confirm)){

                        regProgressBar.setVisibility(View.VISIBLE);

                        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){

                                    Intent accountIntent = new Intent(SignUpActivity.this,AccountActivity.class);
                                    startActivity(accountIntent);
                                    finish();

                                }else{
                                    String errorMessage = task.getException().getMessage();
                                    Toast.makeText(SignUpActivity.this,"Error: "+errorMessage,Toast.LENGTH_LONG).show();
                                }

                                regProgressBar.setVisibility(View.INVISIBLE);
                            }
                        });
                    }else{
                        Toast.makeText(SignUpActivity.this,"Confirm password doesn't match",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(SignUpActivity.this,"All information are required",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            sendToMain();
        }
    }

    private void sendToMain() {
        Intent mainIntent = new Intent(SignUpActivity.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
