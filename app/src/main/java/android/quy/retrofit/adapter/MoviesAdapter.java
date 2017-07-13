package android.quy.retrofit.adapter;

import android.content.Context;
import android.quy.retrofit.R;
import android.quy.retrofit.model.Example;
import android.quy.retrofit.model.Movie;
import android.quy.retrofit.model.Results;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by iamme on 17/06/12.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Example> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView id,name,user;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            id = (TextView) v.findViewById(R.id.id);
            name = (TextView) v.findViewById(R.id.name);
            user = (TextView) v.findViewById(R.id.user);
        }
    }

    public MoviesAdapter(List<Example> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.id.setText(movies.get(position).getId()+"");
        holder.name.setText(movies.get(position).getName());
        holder.user.setText(movies.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}