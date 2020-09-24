package com.example.movieapp.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.movieapp.R;
import com.example.movieapp.models.Movie;
import com.example.movieapp.models.MovieResults;
import com.example.movieapp.networking.CallbackResponse;
import com.example.movieapp.networking.MovieAPIClient;
import java.util.List;


public class MoviesFragment extends Fragment{


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_movies, container, false);
      ContentLoadingProgressBar progressBar = (ContentLoadingProgressBar) view.findViewById(R.id.progress);
      RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.list);

      Context context = view.getContext();
      recyclerView.setLayoutManager(new LinearLayoutManager(context));
      updateAdapter(progressBar, recyclerView);
      return view;
    }

    private void updateAdapter(final ContentLoadingProgressBar progressBar, final RecyclerView recyclerView) {
       progressBar.show();
        MovieAPIClient movieAPIClient = new MovieAPIClient();

        movieAPIClient.getListMovies(new CallbackResponse<List<Movie>>() {
            @Override
            public void onSuccess(List<MovieResults> model) {
                progressBar.hide();
                recyclerView.setAdapter(new MovieAdapter(model, MoviesFragment.this));

                Log.d("Inside Fragment ", "response successful"+model.get(0).title);
            }

            @Override
            public void onFailure(Throwable error) {
                progressBar.hide();
                Log.e("MoviesFragment", error.getMessage());
            }
        });

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}