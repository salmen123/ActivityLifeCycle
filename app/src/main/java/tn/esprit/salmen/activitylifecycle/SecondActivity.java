package tn.esprit.salmen.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class SecondActivity extends TracerActivity {

    TextView tv_choix;
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Receive data
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        // Recover the choice
        String value1 = extras.getString(Intent.EXTRA_TEXT);
        if (value1 != null) {
            // Show choice
        }

        tv_choix = (TextView) findViewById(R.id.tv_choix);
        tv_choix.setText(extras.getCharSequence("choix"));

        rating = (RatingBar) findViewById(R.id.ratingBar1);

        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        setTitle(strings[strings.length - 1]);
    }

    @Override
    public void finish() {

        Intent data = new Intent();

        // Activity finished ok, return the data
        data.putExtra("rating", ""+rating.getProgress());

        // to return the Intent to the application
        setResult(RESULT_OK, data);

        super.finish();
    }
}
