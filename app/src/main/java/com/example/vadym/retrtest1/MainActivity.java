package com.example.vadym.retrtest1;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private SwipeRefreshLayout refreshLayout;
    private AdapterRecycler adapterRecycler;

    private List<String> urlPictures = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchPictures();

        adapterRecycler = new AdapterRecycler(urlPictures, this);
        rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new GridLayoutManager(this, 3));

        final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchPictures();
            }
        };

        refreshLayout = findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(onRefreshListener);

        setAdapterRecycler();
    }

    private void setAdapterRecycler() {
        rv.setAdapter(adapterRecycler);
        adapterRecycler.notifyDataSetChanged();
    }

    private void fetchPictures() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<PhotoResponse> call = api.getRecent(
                "flickr.photos.getRecent",
                ApiService.API_KEY,
                "json",
                "1",
                "url_s");

        call.enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(@NonNull Call<PhotoResponse> call, @NonNull Response<PhotoResponse> response) {
                urlPictures.clear();
                for (PhotoResponse.Photos.Photo ph : response.body().getPhotos().getPhoto()) {
                    String url = ph.getUrlS();
                    if(url != null) {
                        urlPictures.add(url);
                    }
                }

                setAdapterRecycler();
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(@NonNull Call<PhotoResponse> call, @NonNull Throwable t) {
                Log.d("devtag", t.getMessage());
            }
        });
    }
}