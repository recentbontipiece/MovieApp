package com.example.movieapp.util;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movieapp.R;



public class Util {

    private static final String base_url ="https://api.themoviedb.org/";

    public static void loadImage(ImageView img, String url, CircularProgressDrawable progressDrawable){

        String fulPath = String.format("https://image.tmdb.org/t/p/w342/%s",url);
        RequestOptions options = new RequestOptions()
                .placeholder(progressDrawable)
                .placeholder(R.drawable.loading_img)
                .error(R.mipmap.ic_launcher);

        Glide.with(img.getContext())
                .setDefaultRequestOptions(options)
                .load(fulPath)
                .into(img);
    }



    public static CircularProgressDrawable getProgressDrawable(Context context){
        CircularProgressDrawable cpd = new CircularProgressDrawable(context);
        cpd.setStrokeWidth(10f);
        cpd.setCenterRadius(50f);
        cpd.start();
        return cpd;
    }

}
