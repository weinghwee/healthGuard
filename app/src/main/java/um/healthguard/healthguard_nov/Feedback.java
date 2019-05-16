package um.healthguard.healthguard_nov;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feedback extends AppCompatActivity {
    private android.support.v7.widget.Toolbar mainToolbar;
    private Button feedbackBut;
    private EditText subject;
    private EditText description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        mainToolbar = findViewById(R.id.feedback_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("User Feedback");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        subject = findViewById(R.id.subject_feedback);
        description = findViewById(R.id.description_feedback);
        feedbackBut = findViewById(R.id.feedback_but);
        feedbackBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

    }

    private void sendEmail() {
        Intent Email = new Intent(Intent.ACTION_SEND);
        Email.setType("text/email");
        Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "devilng05108@gmail.com" });
        Email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
        Email.putExtra(Intent.EXTRA_TEXT, description.getText().toString());
        startActivity(Intent.createChooser(Email, "Send Feedback:"));
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
