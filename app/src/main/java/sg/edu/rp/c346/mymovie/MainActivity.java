package sg.edu.rp.c346.mymovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<MovieItem> alMovieList;
    CustomAdatper caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovie);
        alMovieList = new ArrayList<>();



        MovieItem item1 = new MovieItem("The Avengers","2012","pg13","Action | Sci-Fi","15/11/20147","Golden Village - Bishan","Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.",4);
        MovieItem item2 = new MovieItem("Planes","2013","pg","Animation | Comedy","15/5/2015","Cathay - AMK Hub","A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",2);

        alMovieList.add(item1);
        alMovieList.add(item2);
        caMovie = new CustomAdatper(this,R.layout.movie_item,alMovieList);

        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentDetail = new Intent(getBaseContext(),SecondActivity.class);

                MovieItem currentMovie = alMovieList.get(i);
                intentDetail.putExtra("title",currentMovie.getTitle());
                intentDetail.putExtra("year",currentMovie.getYear());
                intentDetail.putExtra("genre",currentMovie.getGenre());
                intentDetail.putExtra("rated",currentMovie.getRated());
                intentDetail.putExtra("watched_on",currentMovie.getWatched_on());
                intentDetail.putExtra("in_theatre",currentMovie.getIn_theatre());
                intentDetail.putExtra("description",currentMovie.getDescription());
                intentDetail.putExtra("star",currentMovie.getStar());
                startActivity(intentDetail);
            }
        });
    }
}
