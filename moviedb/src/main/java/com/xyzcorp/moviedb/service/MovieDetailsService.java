package com.xyzcorp.moviedb.service;

import com.xyzcorp.moviedb.dao.MovieDetailsDao;
import com.xyzcorp.moviedb.entity.MovieDetail;
import com.xyzcorp.moviedb.model.MovieDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieDetailsService {

    @Autowired
    private MovieDetailsDao movieDetailsDao;

    public void saveMovieDetails(MovieDetails requestDetails) {
        MovieDetail detail = convertToMovieDetail(requestDetails);
        movieDetailsDao.saveMovieDetails(detail);

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
