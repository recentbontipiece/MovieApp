package com.example.movieapp.networking;




import com.example.movieapp.models.Movie;
import com.example.movieapp.models.MovieAPIResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieAPIClient {

    private static final String base_url ="https://api.themoviedb.org/";
    private static final String API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed";

    private MoviesService moviesService;

    public MovieAPIClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        moviesService = retrofit.create(MoviesService.class);
    }

    public void getListMovies(final CallbackResponse<List<Movie>> moviesListResponse){
        Call<MovieAPIResponse> current = moviesService.getListMovies();
        current.enqueue(new Callback<MovieAPIResponse>() {
            @Override
            public void onResponse(Call<MovieAPIResponse> call, Response<MovieAPIResponse> response) {
                MovieAPIResponse model = response.body();
                if(response.isSuccessful() && model !=null){
                    moviesListResponse.onSuccess(model.results);
                }else {
                    moviesListResponse.onFailure(new Throwable("error with response code " + response.code() + " " + response.message()));
                }
            }

            @Override
            public void onFailure(Call<MovieAPIResponse> call, Throwable t) {
                moviesListResponse.onFailure(t);
            }
        });



    }




}
