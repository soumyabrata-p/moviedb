package com.xyzcorp.moviedb.model;

import com.xyzcorp.moviedb.entity.MovieTheatreDetails;

import java.io.Serializable;
import java.util.List;

/**
 * Created by s.purakayastha
 * Date: 12/11/2020
 * Time: 12:52 AM
 */
public class MovieDetails implements Serializable {


    private static final long serialVersionUID = 3471800304358962971L;

    private Long movieId;
    private String movieName;

    public List<MovieTheatreDetails> getMovieTheatreDetailsList() {
        return movieTheatreDetailsList;
    }

    public void setMovieTheatreDetailsList(List<MovieTheatreDetails> movieTheatreDetailsList) {
        this.movieTheatreDetailsList = movieTheatreDetailsList;
    }

    private String releaseYear;
    private Integer rating;
    private Boolean isSuperHit;

    private List<MovieTheatreDetails> movieTheatreDetailsList;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Boolean getSuperHit() {
        return isSuperHit;
    }

    public void setSuperHit(Boolean superHit) {
        isSuperHit = superHit;
    }
}
