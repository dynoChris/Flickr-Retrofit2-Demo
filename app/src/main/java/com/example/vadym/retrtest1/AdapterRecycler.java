package com.example.vadym.retrtest1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {

    private List<String> urlPictures;
    private Context context;

    AdapterRecycler(List<String> urlPictures, Context context) {
        this.urlPictures = urlPictures;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_item_picture, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        Glide.with(context)
//                .load(urlPictures.get(position))
//                .into(holder.img);

        Picasso.get()
                .load(urlPictures.get(position))
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return urlPictures.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        MyViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image_view_picture);
        }
    }
}
