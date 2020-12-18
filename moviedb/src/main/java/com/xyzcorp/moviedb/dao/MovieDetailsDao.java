package com.xyzcorp.moviedb.dao;

import com.xyzcorp.moviedb.entity.MovieDetail;
import com.xyzcorp.moviedb.repository.MovieDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieDetailsDao {

    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    public void saveMovieDetails(MovieDetail movieDetail) {
        movieDetailsRepository.save(movieDetail);
    }
}
