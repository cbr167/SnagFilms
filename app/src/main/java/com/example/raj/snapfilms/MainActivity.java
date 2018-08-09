package com.example.raj.snapfilms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.raj.snapfilms.models.Film;
import com.example.raj.snapfilms.models.Films;
import com.example.raj.snapfilms.models.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

RecyclerView snagFilmRecyclerView,filmRecyclerView;
GridLayoutManager gridLayoutManager;
RecyclerView.LayoutManager layoutManager;
SnagFilmRecyclerView recyclerViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SnagAsyncTask snagAsyncTask = new SnagAsyncTask(this);
        snagAsyncTask.execute();

        snagFilmRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewAdapter = new SnagFilmRecyclerView(MainActivity.this,  null);
        gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        snagFilmRecyclerView.setLayoutManager(gridLayoutManager);
        snagFilmRecyclerView.setHasFixedSize(true);
        snagFilmRecyclerView.setAdapter(recyclerViewAdapter);




//        filmRecyclerView = (RecyclerView)findViewById(R.id.recyclerView2);
//        gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
//        filmRecyclerView.setLayoutManager(gridLayoutManager);
//        filmRecyclerView.setHasFixedSize(true);
//        filmRecyclerView.setAdapter(filmAdapter);

       // showAllDetails(response);
    }

    public void showAllDetails(Films films){
        Log.e("Check", films.getFilm().size() + "Size");
        recyclerViewAdapter.setFilms(films.getFilm());

    }
}
