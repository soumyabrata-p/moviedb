package com.xyzcorp.moviedb.dao;

import com.xyzcorp.moviedb.entity.MovieRegisterForm;
import com.xyzcorp.moviedb.repository.MovieRegisterFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MovieRegisterFormDao {
    @Autowired
    private MovieRegisterFormRepository movieRegisterFormRepository;

    public void saveMovieRegisterUser(MovieRegisterForm movieRegisterUser){
        movieRegisterFormRepository.save(movieRegisterUser);
    }

    public MovieRegisterForm getUserById(Long userId) {
        Optional<MovieRegisterForm> movieRegisterForm = movieRegisterFormRepository.findById(userId);
        if(movieRegisterForm.isPresent()) {
            return movieRegisterForm.get();
        }

        return null;
    }
}
