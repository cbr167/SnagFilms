package com.example.raj.snapfilms.models;

/**
 * Created by bhagy on 7/15/2018.
 */

public class Film {

    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public RelatedFilms getRelatedFilms() {
        return relatedFilms;
    }

    public void setRelatedFilms(RelatedFilms relatedFilms) {
        this.relatedFilms = relatedFilms;
    }

    public Renditions getRenditions() {
        return renditions;
    }

    public void setRenditions(Renditions renditions) {
        this.renditions = renditions;
    }

    public int author;
    public String title;
    public int durationMinutes;
    public Images images;
    public RelatedFilms relatedFilms;
    public Renditions renditions;


}
