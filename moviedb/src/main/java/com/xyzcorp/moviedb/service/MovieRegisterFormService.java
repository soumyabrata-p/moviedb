package com.xyzcorp.moviedb.service;

import com.xyzcorp.moviedb.dao.MovieRegisterFormDao;
import com.xyzcorp.moviedb.entity.MovieRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieRegisterFormService {
    @Autowired
    private MovieRegisterFormDao movieRegisterFormDao;

    public void saveMovieRegisterUser(MovieRegisterForm newUser){

        movieRegisterFormDao.saveMovieRegisterUser(newUser);

    }

    public MovieRegisterForm getUserById(Long userId){
       return movieRegisterFormDao.getUserById(userId);
    }
}
