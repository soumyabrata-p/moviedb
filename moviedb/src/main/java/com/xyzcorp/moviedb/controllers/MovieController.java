package com.xyzcorp.moviedb.controllers;

import com.xyzcorp.moviedb.model.MovieDetails;
import com.xyzcorp.moviedb.service.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
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

    @Value("${superhit.rating}")
    private Integer superhitRating;

    @Autowired
    private MovieDetailsService movieDetailsService;

    @GetMapping(value="/movieList",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMovieList(){
        return "Bahubaali";
    }

    @GetMapping(value="/moviedetails",produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDetails getMovieDetails() {

        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setMovieName("Bahubaali");
        movieDetails.setRating(4);
        movieDetails.setReleaseYear("2015");

        return movieDetails;

    }

    @GetMapping(value = "/moviebyid",produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDetails getMovieById(@RequestParam Long movieId) {
        /*List<MovieDetails> movieDetailsList = getMovieDetailList(null);
        Optional<MovieDetails> details = movieDetailsList.stream().filter(x -> x.getMovieId().equals(movieId)).findFirst();
        if(details.isPresent()) {
            return details.get();
        }
        return null;*/
        MovieDetails response = null;

        try{
            response = movieDetailsService.getMovieDetailById(movieId);

        }catch (Exception e){
            throw e;
        }

        return response;

    }

    @GetMapping(value = "/moviebyid/{movieId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDetails getMovieByIdVariable(@PathVariable("movieId") Long movieId) {
        List<MovieDetails> movieDetailsList = getMovieDetailList(null);
        Optional<MovieDetails> details = movieDetailsList.stream().filter(x -> x.getMovieId().equals(movieId)).findFirst();
        MovieDetails movie = null;
        if(details.isPresent()) {
            movie = details.get();
            if(movie != null &&   movie.getRating() >= superhitRating) {
                movie.setSuperHit(true);
            }
        }
        return movie;

    }

    @PostMapping(value = "/addmovie", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public String addMovieDetails(@RequestBody MovieDetails movie) {

        /*List<MovieDetails> movieDetailsList = getMovieDetailList(movie);
        return movieDetailsList;*/
        try {
            movieDetailsService.saveMovieDetails(movie);
        }catch (Exception e){
            e.printStackTrace();
            return "Failure";
        }

        return "Success";

    }

    @DeleteMapping(value = "/deletebyid", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieDetails> deleteMovieDetails(@RequestParam Long movieId) {

        List<MovieDetails> movies = getMovieDetailList(null);
        movies.removeIf(movieDetails -> movieDetails.getMovieId().equals(movieId));

        return movies;
    }



    public List<MovieDetails> getMovieDetailList(MovieDetails movie){

        List<MovieDetails> movieDetailsList = new ArrayList<>();

        MovieDetails movie1 = new MovieDetails();
        movie1.setReleaseYear("2019");
        movie1.setMovieName("Movie 1");
        movie1.setRating(3);
        movie1.setMovieId(1l);

        MovieDetails movie2 = new MovieDetails();
        movie2.setReleaseYear("2018");
        movie2.setMovieName("Movie 2");
        movie2.setRating(4);
        movie2.setMovieId(2l);

        MovieDetails movie3 = new MovieDetails();
        movie3.setReleaseYear("2017");
        movie3.setMovieName("Movie 3");
        movie3.setRating(5);
        movie3.setMovieId(3l);

        movieDetailsList.add(movie1);
        movieDetailsList.add(movie2);
        movieDetailsList.add(movie3);
        if(movie != null) {
            movieDetailsList.add(movie);
        }

        return movieDetailsList;
    }



}
