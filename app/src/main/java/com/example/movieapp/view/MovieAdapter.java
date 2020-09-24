package com.example.movieapp.view;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.movieapp.R;
import com.example.movieapp.models.MovieResults;
import com.example.movieapp.util.Util;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final List<MovieResults> movies;
    public MovieAdapter(List<MovieResults> movies, MoviesFragment moviesFragment) {
        this.movies = movies;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
      holder.mTitle.setText(movies.get(position).title);
      holder.mOverview.setText(movies.get(position).overview);

      String mvUrl ="";
      int orientation = holder.mView.getContext().getResources().getConfiguration().orientation;
          if(orientation == Configuration.ORIENTATION_LANDSCAPE){
              mvUrl = movies.get(position).backdrop_path_url;
          }else {
              mvUrl = movies.get(position).poster_path_url;
          }

        Util.loadImage(holder.mImageView, mvUrl ,Util.getProgressDrawable(holder.mImageView.getContext()));
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        private final TextView mTitle;
        private final TextView mOverview;
        private final ImageView mImageView;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            mView      = itemView;
            mTitle     = (TextView) mView.findViewById(R.id.titleMovie);
            mOverview  = (TextView) mView.findViewById(R.id.overview);
            mImageView = (ImageView) mView.findViewById(R.id.ivPoster);
        }
    }

}
