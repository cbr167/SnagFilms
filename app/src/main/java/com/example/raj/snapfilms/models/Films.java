package com.example.raj.snapfilms.models;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by bhagy on 7/15/2018.
 */

public class Films {
    public int categories;
    public List<Film> film;

    public int getCategories() {
        return categories;
    }

    public void setCategories(int categories) {
        this.categories = categories;
    }

    public List<Film> getFilm() {
        return film;
    }

    public void setFilm(List<Film> film) {
        this.film = film;
    }


}
