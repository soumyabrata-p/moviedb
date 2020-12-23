package com.xyzcorp.moviedb.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="movie_theatre_details")
public class MovieTheatreDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_theatre_details_id")
    private Long movieTheatreDetailsId;
    @Column(name = "movie_theatre_name")
    private String movieTheatreCity;
    @Column(name ="movie_theatre_city")
    private String movieTheatreName;
    @Column(name = "movie_run_days_count")
    private Long movieRunDaysCount;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private MovieDetail movieDetail;

    public Long getMovieTheatreDetailsId() {
        return movieTheatreDetailsId;
    }

    public void setMovieTheatreDetailsId(Long movieTheatreDetailsId) {
        this.movieTheatreDetailsId = movieTheatreDetailsId;
    }

    public String getMovieTheatreCity() {
        return movieTheatreCity;
    }

    public void setMovieTheatreCity(String movieTheatreCity) {
        this.movieTheatreCity = movieTheatreCity;
    }

    public String getMovieTheatreName() {
        return movieTheatreName;
    }

    public Long getMovieRunDaysCount() {
        return movieRunDaysCount;
    }

    public void setMovieRunDaysCount(Long movieRunDaysCount) {
        this.movieRunDaysCount = movieRunDaysCount;
    }

    public void setMovieTheatreName(String movieTheatreName) {
        this.movieTheatreName = movieTheatreName;
    }
}
