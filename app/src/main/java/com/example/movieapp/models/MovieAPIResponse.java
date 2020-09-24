package com.example.movieapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;



public class MovieAPIResponse {

    @SerializedName("status")
    public String status;


//    @SerializedName("results")
//    public MovieResults results;


    @SerializedName("results")
    @Expose
    public List<MovieResults> results = null;

    public List<MovieResults> getResults(){
        return results;
    }

    public void setResults(List<MovieResults> results){
        this.results = results;
    }

}
