package com.xyzcorp.moviedb.service;

import com.xyzcorp.moviedb.dao.MovieDetailsDao;
import com.xyzcorp.moviedb.entity.MovieDetail;
import com.xyzcorp.moviedb.model.MovieDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieDetailsService {

    @Autowired
    private MovieDetailsDao movieDetailsDao;

    public void saveMovieDetails(MovieDetails requestDetails) {
        MovieDetail detail = convertToMovieDetail(requestDetails);
        movieDetailsDao.saveMovieDetails(detail);

    }

    public List<MovieDetail> getMovieDetailByName(String movieName) {
         return movieDetailsDao.movieName(movieName);
    }

    public MovieDetails getMovieDetailById(Long Id) {
        MovieDetail movieDetailFromDb = movieDetailsDao.getMovieById(Id);
        MovieDetails response = convertToMovieDetails(movieDetailFromDb) ;
        return response;
    }


    private MovieDetails convertToMovieDetails(MovieDetail movieDetailFromDb) {
        MovieDetails movieResponse = new MovieDetails();
        movieResponse.setMovieId(movieDetailFromDb.getMovieId());
        movieResponse.setMovieName(movieDetailFromDb.getMovieName());
        movieResponse.setRating(movieDetailFromDb.getRating());
        movieResponse.setReleaseYear(movieDetailFromDb.getReleaseYear());

        return movieResponse;
    }


    private MovieDetail convertToMovieDetail(MovieDetails requestDetails) {
        MovieDetail movie = new MovieDetail();
        movie.setMovieId(requestDetails.getMovieId());
        movie.setMovieName(requestDetails.getMovieName());
        movie.setRating(requestDetails.getRating());
        movie.setReleaseYear(requestDetails.getReleaseYear());

        return movie;

    }
}
