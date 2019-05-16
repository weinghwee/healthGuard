package um.healthguard.healthguard_nov;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleDetails extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_details);

        TextView tv = (TextView) findViewById(R.id.title);
        TextView tv1 = (TextView) findViewById(R.id.articleDetails);
        ImageView iv = (ImageView) findViewById(R.id.image);
        tv.setText(getIntent().getStringExtra("title"));
        tv1.setText(getIntent().getStringExtra("articledetails"));
        iv.setImageResource(getIntent().getIntExtra("image",00));

        mainToolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Articles and Guides");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
