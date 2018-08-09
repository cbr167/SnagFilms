package com.example.raj.snapfilms.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhagy on 7/17/2018.
 */

public class    Response {
    private Films films;

    public Films getFilms() {
        return films;
    }

    public void setFilms(Films films) {
        this.films = films;
    }

    public static Films getAllFilms(JSONObject jsonObject) {
        Response response = new Response();
        Films films = new Films();

        if (jsonObject != null) {
            JSONObject filmsObject = jsonObject.optJSONObject("films");
            if (filmsObject != null) {
                JSONArray filmArray = filmsObject.optJSONArray("film");
                List<Film> filmList = new ArrayList<>();

                if (filmArray != null && filmArray.length() > 0) {
                    for (int i = 0; i < filmArray.length(); i++) {
                        JSONObject filmObject = filmArray.optJSONObject(i);
                        Film film = new Film();
                        if (filmObject != null) {
                            film.setTitle(filmObject.optString("title"));
                            film.setDurationMinutes(filmObject.optInt("durationMinutes"));
                        }
                        JSONObject imagesObject = filmObject.optJSONObject("images");
                        Images images = new Images();
                        if (imagesObject != null) {
                            JSONArray imageArray = imagesObject.optJSONArray("image");
                            List<Image> imageList = new ArrayList<>();
                            if (imageArray != null && imageArray.length() > 0) {
                                for (int j = 0; j < filmArray.length(); j++) {
                                    JSONObject imageObject = imageArray.optJSONObject(j);
                                    Image image = new Image();
                                    if (imageObject != null) {
                                        image.setSrc(imageObject.optString("src"));
                                        image.setType(imageObject.optString("type"));
                                        imageList.add(image);
                                    }
                                }
                                images.setImage(imageList);
                                film.setImages(images);
                                filmList.add(film);
                                // Log.d("responseFilm", String.valueOf(film.));
                                //filmList.add()
                            }
                        }
                        JSONObject relatedFilmObject = filmObject.optJSONObject("relatedFilms");
                        RelatedFilms relatedFilmsObject = new RelatedFilms();
                        if (relatedFilmObject != null) {
                            JSONArray relatedFilmArray = relatedFilmObject.optJSONArray("relatedFilm");
                            List<RelatedFilm> relatedFilmList = new ArrayList<>();

                            if (relatedFilmArray != null && relatedFilmArray.length() > 0) {
                                for (int j = 0; j < relatedFilmArray.length(); j++) {
                                    JSONObject relatedFilmObjects = relatedFilmArray.optJSONObject(j);
                                    RelatedFilm relatedFilm = new RelatedFilm();
                                    if (relatedFilmObjects != null) {
                                        relatedFilm.setTitle(relatedFilmObjects.optString("title"));
                                        JSONObject relatedFilmImagesObject = relatedFilmObjects.optJSONObject("images");
                                        RelatedFilmImages relatedFilmImages = new RelatedFilmImages();
                                        if (relatedFilmImages != null) {
                                            JSONArray relatedFilmImagesArray = relatedFilmImagesObject.optJSONArray("image");
                                            List<RelatedFilmImage> relatedFilmImageList = new ArrayList<>();
                                            if (relatedFilmImagesArray != null && relatedFilmImagesArray.length() > 0) {
                                                for (int k = 0; k < relatedFilmImagesArray.length(); k++) {
                                                    JSONObject relatedFilmImagesObjects = relatedFilmImagesArray.optJSONObject(k);
                                                    RelatedFilmImage relatedFilmImage = new RelatedFilmImage();
                                                    relatedFilmImage.setSrc(relatedFilmImagesObjects.optString("src"));
                                                    relatedFilmImageList.add(relatedFilmImage);
                                                }

                                            }
                                            relatedFilmImages.setImage(relatedFilmImageList);
                                            relatedFilm.setImages(relatedFilmImages);
                                            relatedFilmList.add(relatedFilm);
                                            relatedFilmsObject.setRelatedFilm(relatedFilmList);
                                            film.setRelatedFilms(relatedFilmsObject);
//                                            filmList.add(film);

                                        }

                                    }

                                }

                            }

                        }

                    }


                }

                films.setFilm(filmList);
                Log.d("rammm", String.valueOf(films.getFilm().size()));
            }
            response.setFilms(films);
            Log.d("baram", films.toString());
        }
        return films;
    }
}
