package sg.edu.rp.c346.mymovie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16003753 on 23/7/2018.
 */

public class CustomAdatper extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<MovieItem> movieList;


    public CustomAdatper(@NonNull Context context, int resource, @NonNull ArrayList<MovieItem> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent,false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvInfo = rowView.findViewById(R.id.textViewInfo);
        ImageView ivImpt = rowView.findViewById(R.id.imageViewRate);

        MovieItem currentItem = movieList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvInfo.setText(currentItem.getYear()+" - "+ currentItem.getGenre());
        if(currentItem.getRated().equals("g")){
            ivImpt.setImageResource(R.drawable.rating_g);
        }
        else if(currentItem.getRated().equals("pg")){
            ivImpt.setImageResource(R.drawable.rating_pg);
        }
        else if(currentItem.getRated().equals("pg13")){
            ivImpt.setImageResource(R.drawable.rating_pg13);
        }
        else if(currentItem.getRated().equals("nc16")){
            ivImpt.setImageResource(R.drawable.rating_nc16);
        }
        else if(currentItem.getRated().equals("m18")){
            ivImpt.setImageResource(R.drawable.rating_m18);
        }
        else if(currentItem.getRated().equals("r21")){
            ivImpt.setImageResource(R.drawable.rating_r21);
        }

        return rowView;

    }
}
