package com.movie.movieService;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Movie {
    public Movie(int id, String title, String releaseDate, String genre) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Movie(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonProperty
    private int id;
    @JsonProperty
    private String title;
    @JsonProperty
    private String releaseDate;
    @JsonProperty
    private String genre;
}
