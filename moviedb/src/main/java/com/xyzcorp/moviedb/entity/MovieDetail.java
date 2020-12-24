package com.xyzcorp.moviedb.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movie_details")
public class MovieDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name ="movie_name")
    private String movieName;
    @Column(name ="release_year")
    private String releaseYear;



    @Column(name ="rating")
    private Integer rating;
    @Column(name ="is_superhit")
    private String isSuperhit;

    @OneToMany(mappedBy = "movieDetail",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MovieTheatreDetails> movieTheatreDetailsList;

    //DAO - Data Access Objects

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

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

    public String getIsSuperhit() {
        return isSuperhit;
    }

    public void setIsSuperhit(String isSuperhit) {
        this.isSuperhit = isSuperhit;
    }
    public List<MovieTheatreDetails> getMovieTheatreDetailsList() {
        return movieTheatreDetailsList;
    }

    public void setMovieTheatreDetailsList(List<MovieTheatreDetails> movieTheatreDetailsList) {
        this.movieTheatreDetailsList = movieTheatreDetailsList;
    }
}
