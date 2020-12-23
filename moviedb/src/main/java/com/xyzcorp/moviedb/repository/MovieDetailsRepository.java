package com.xyzcorp.moviedb.repository;

import com.xyzcorp.moviedb.entity.MovieDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetail,Long> {

     public static final String getByMovieNameQuery= "select * from movie_details where movie_name = :movieName";

    //Native Queries
    @Query(value = getByMovieNameQuery, nativeQuery = true)
    List<MovieDetail> getMovieByName(String movieName);

}


