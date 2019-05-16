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

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText loginEmailText;
    private EditText loginPasswordText;
    private Button signInButton;
    private Button signUpButton;
    private ProgressBar loginprogressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();

        loginEmailText = (EditText)findViewById(R.id.regEmail);
        loginPasswordText = (EditText)findViewById(R.id.regPassword);
        signInButton = (Button)findViewById(R.id.signInButton);
        signUpButton = (Button)findViewById(R.id.signUpButton);
        loginprogressBar = (ProgressBar)findViewById(R.id.loginprogressBar);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(Login.this,SignUpActivity.class);
                startActivity(regIntent);


            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String loginEmail =loginEmailText.getText().toString();
                String loginPassword =loginPasswordText.getText().toString();

                if(!TextUtils.isEmpty(loginEmail)&&!TextUtils.isEmpty(loginPassword)){
                    loginprogressBar.setVisibility(View.VISIBLE);

                    mAuth.signInWithEmailAndPassword(loginEmail,loginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                sendToMain();
                            }else{
                                String errorMessage = task.getException().getMessage();
                                Toast.makeText(Login.this,"Error : "+errorMessage,Toast.LENGTH_LONG).show();
                            }

                            loginprogressBar.setVisibility(View.INVISIBLE);
                        }
                    });
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
        //intent to login
        Intent mainIntent = new Intent(Login.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
