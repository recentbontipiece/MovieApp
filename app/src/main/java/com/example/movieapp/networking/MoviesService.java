package com.example.movieapp.networking;

import com.example.movieapp.models.MovieAPIResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesService {
    @GET("3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed")
    Call<MovieAPIResponse> getListMovies();
}
