package com.xyzcorp.moviedb.repository;

import com.xyzcorp.moviedb.entity.MovieRegisterForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRegisterFormRepository  extends JpaRepository<MovieRegisterForm, Long> {
}
