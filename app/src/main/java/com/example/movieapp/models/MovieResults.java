package com.example.movieapp.models;

import com.google.gson.annotations.SerializedName;

public class MovieResults {


   @SerializedName("poster_path")
   public String poster_path_url;

   @SerializedName("backdrop_path")
   public String backdrop_path_url;

   @SerializedName("title")
   public  String title;

   @SerializedName("overview")
   public String overview;


//   @SerializedName("results")
//   public Movie movies;

//   @SerializedName("results")
//   public List<Movie> movies;
}
