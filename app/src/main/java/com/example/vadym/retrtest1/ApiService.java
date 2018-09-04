package com.example.vadym.retrtest1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    public static final String BASE_URL = "https://api.flickr.com";
    public static final String API_KEY = "5716bb95477866da706c0f552a1627ca";

    //full response
    //https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=5716bb95477866da706c0f552a1627ca&format=json&nojsoncallback=1&extras=url_s

    @GET("/services/rest/")
    Call<PhotoResponse> getRecent(
            @Query("method") String method,
            @Query("api_key") String api_key,
            @Query("format") String format,
            @Query("nojsoncallback") String set,
            @Query("extras") String url_small
    );

}
