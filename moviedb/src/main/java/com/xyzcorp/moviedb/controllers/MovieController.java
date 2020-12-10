package com.xyzcorp.moviedb.controllers;

import com.xyzcorp.moviedb.model.MovieDetails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by s.purakayastha
 * Date: 12/9/2020
 * Time: 1:07 AM
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @GetMapping(value="/movieList",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMovieList(){
        return "Bahubaali";
    }

    @GetMapping(value="/moviedetails",produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDetails getMovieDetails() {

        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setMovieName("Bahubaali");
        movieDetails.setRating("4/5");
        movieDetails.setReleaseYear("2015");

        return movieDetails;

    }

    @GetMapping(value = "/moviebyid",produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDetails getMovieById(@RequestParam Long movieId) {
        List<MovieDetails> movieDetailsList = getMovieDetailList();
        Optional<MovieDetails> details = movieDetailsList.stream().filter(x -> x.getMovieId().equals(movieId)).findFirst();
        if(details.isPresent()) {
            return details.get();
        }
        return null;

    }




    public List<MovieDetails> getMovieDetailList(){

        List<MovieDetails> movieDetailsList = new ArrayList<>();

        MovieDetails movie1 = new MovieDetails();
        movie1.setReleaseYear("2019");
        movie1.setMovieName("Movie 1");
        movie1.setRating("3/5");
        movie1.setMovieId(1l);

        MovieDetails movie2 = new MovieDetails();
        movie2.setReleaseYear("2018");
        movie2.setMovieName("Movie 2");
        movie2.setRating("4/5");
        movie2.setMovieId(2l);

        MovieDetails movie3 = new MovieDetails();
        movie3.setReleaseYear("2017");
        movie3.setMovieName("Movie 3");
        movie3.setRating("5/5");
        movie3.setMovieId(3l);

        movieDetailsList.add(movie1);
        movieDetailsList.add(movie2);
        movieDetailsList.add(movie3);

        return movieDetailsList;
    }



}
