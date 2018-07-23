package sg.edu.rp.c346.mymovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    TextView tvtitle;
    TextView tvDescription;
    TextView tvDetail;
    ImageView ivImage;
    RatingBar startbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvtitle = findViewById(R.id.textViewTitle);
        tvDescription = findViewById(R.id.textViewInfo);
        tvDetail = findViewById(R.id.textViewDetail);
        ivImage = findViewById(R.id.imageViewRate);
        startbar = findViewById(R.id.ratingBar);

        Intent intentReceived  = getIntent();
        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String rated = intentReceived.getStringExtra("rated");
        String genre = intentReceived.getStringExtra("genre");
        String watched_on = intentReceived.getStringExtra("watched_on");
        String in_theatre = intentReceived.getStringExtra("in_theatre");
        String description = intentReceived.getStringExtra("description");
        int star = intentReceived.getIntExtra("star",0);


        if(rated.equals("g")){
            ivImage.setImageResource(R.drawable.rating_g);
        }
        else if(rated.equals("pg")){
            ivImage.setImageResource(R.drawable.rating_pg);
        }
        else if(rated.equals("pg13")){
            ivImage.setImageResource(R.drawable.rating_pg13);
        }
        else if(rated.equals("nc16")){
            ivImage.setImageResource(R.drawable.rating_nc16);
        }
        else if(rated.equals("m18")){
            ivImage.setImageResource(R.drawable.rating_m18);
        }
        else if(rated.equals("r21")){
            ivImage.setImageResource(R.drawable.rating_r21);
        }

        tvtitle.setText(title);
        tvDescription.setText(year+" - "+genre);
        tvDetail.setText(description +"\n\n"+"Watch on:"+ watched_on +"\nIn Theatre: "+in_theatre);

        startbar.setRating(star);
        startbar.setIsIndicator(true);
    }
}
