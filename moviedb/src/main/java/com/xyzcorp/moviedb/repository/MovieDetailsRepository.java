package com.xyzcorp.moviedb.repository;

import com.xyzcorp.moviedb.entity.MovieDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetail,Long> {
}
