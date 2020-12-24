package com.xyzcorp.moviedb.repository;

import com.xyzcorp.moviedb.entity.MovieDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetail,Long> {

     public static final String getByMovieNameQuery= "select * from movie_details where movie_name = :movieName";
     public static final String deleteByMovieNameQuery= "delete from movie_details where movie_name = :movieName";

    //Native Queries
    @Query(value = getByMovieNameQuery, nativeQuery = true)
    List<MovieDetail> getMovieByName(String movieName);


    @Modifying
    @Transactional
    @Query(value = deleteByMovieNameQuery, nativeQuery = true)
    void deleteByMovieName(String movieName);

}


