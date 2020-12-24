package com.xyzcorp.moviedb.controllers;

import com.xyzcorp.moviedb.entity.MovieDetail;
import com.xyzcorp.moviedb.entity.MovieRegisterForm;
import com.xyzcorp.moviedb.model.MovieDetails;
import com.xyzcorp.moviedb.service.MovieDetailsService;
import com.xyzcorp.moviedb.service.MovieRegisterFormService;
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

    @Autowired
    private MovieRegisterFormService movieRegisterFormService;

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

    @GetMapping(value = "/moviebyname",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieDetail> getMovieByName(@RequestParam String movieName) {

        List<MovieDetail> response = null;
        try {
            response = movieDetailsService.getMovieDetailByName(movieName);
        }catch (Exception e){
            throw e;
        }

        return response;
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

    @GetMapping(value = "/userbyid",produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieRegisterForm getUserById(@RequestParam Long userId) {

        MovieRegisterForm response = null;

        try{
            response = movieRegisterFormService.getUserById(userId);

        }catch (Exception e){
            throw e;
        }

        return response;

    }


    @PostMapping(value = "/adduser", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public String addMovieRegisterUser(@RequestBody MovieRegisterForm movie) {

        try {
            movieRegisterFormService.saveMovieRegisterUser(movie);
        }catch (Exception e){
            e.printStackTrace();
            return "Failure";
        }

        return "Success";

    }

    /*@DeleteMapping(value = "/deletebyid", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieDetails> deleteMovieDetails(@RequestParam Long movieId) {

        List<MovieDetails> movies = getMovieDetailList(null);
        movies.removeIf(movieDetails -> movieDetails.getMovieId().equals(movieId));

        return movies;
    }*/

    @DeleteMapping(value = "/deletebyid", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteMovieDetails(@RequestParam Long movieId) {

        try{
            movieDetailsService.deleteMovieDetails(movieId);
        }catch (Exception e){
            e.printStackTrace();
            return  "Error :"+e.getMessage();
        }
        return "Deleted";
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
