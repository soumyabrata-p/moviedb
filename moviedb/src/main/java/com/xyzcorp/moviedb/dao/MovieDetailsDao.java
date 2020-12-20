package com.xyzcorp.moviedb.dao;

import com.xyzcorp.moviedb.entity.MovieDetail;
import com.xyzcorp.moviedb.repository.MovieDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MovieDetailsDao {

    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    public void saveMovieDetails(MovieDetail movieDetail) {
        movieDetailsRepository.save(movieDetail);
    }

    public MovieDetail getMovieById(Long movieId) {
        Optional<MovieDetail> movieDetail = movieDetailsRepository.findById(movieId);
        if(movieDetail.isPresent()) {
            return movieDetail.get();
        }
        return null;


    }
}
