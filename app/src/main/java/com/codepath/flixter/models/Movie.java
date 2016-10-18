package com.codepath.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.R.attr.format;

/**
 * Created by sgontare on 10/17/16.
 */

public class Movie {

    public String getPoster() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",poster);
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdrop);
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    private String title;
    private String overview;
    private String poster;
    private String backdrop;

    public Movie(JSONObject json) throws JSONException {
        this.poster = json.getString("poster_path");
        this.title = json.getString("original_title");
        this.overview = json.getString("overview");
        this.backdrop = json.getString("backdrop_path");
    }

    public static ArrayList<Movie> makeFromJsonArray(JSONArray json) {
        ArrayList<Movie> movies = new ArrayList<>();

        for (int x = 0; x < json.length(); x++) {
            try {
                movies.add(new Movie(json.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }
}