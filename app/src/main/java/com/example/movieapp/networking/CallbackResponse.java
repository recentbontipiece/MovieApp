package com.example.movieapp.networking;

import com.example.movieapp.models.MovieResults;

import java.util.List;

public interface CallbackResponse<T> {
    void onSuccess(List<MovieResults> model);
    void onFailure(Throwable error);
}
