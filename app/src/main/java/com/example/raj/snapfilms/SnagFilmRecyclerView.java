package com.example.raj.snapfilms;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.raj.snapfilms.models.Film;
import com.example.raj.snapfilms.models.Films;
import com.example.raj.snapfilms.models.Image;
import com.example.raj.snapfilms.models.Response;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by bhagy on 7/18/2018.
 */

public class SnagFilmRecyclerView extends RecyclerView.Adapter<SnagFilmRecyclerView.SnagFilmViewHolder> {

    private List<Film> films;
    private List<Image> images;

    Context context;

    public SnagFilmRecyclerView(Context context, List<Film> films) {
        this.context = context;
        this.films = films;
    }

    @Override
    public SnagFilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_layout, parent, false);
        return new SnagFilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SnagFilmViewHolder holder, int position) {
        String imgSource = films.get(position).getImages().getImage().get(0).getSrc();
        Picasso.get().load(imgSource).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return films != null ? films.size() : 0;
    }

    public void setFilms(List<Film> films){
        this.films = films;
        notifyDataSetChanged();
    }

    public class SnagFilmViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public SnagFilmViewHolder(View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.snagImage);

        }
    }
}
