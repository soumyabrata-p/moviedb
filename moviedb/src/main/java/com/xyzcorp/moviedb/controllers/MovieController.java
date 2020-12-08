package com.xyzcorp.moviedb.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by s.purakayastha
 * Date: 12/9/2020
 * Time: 1:07 AM
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @GetMapping(value="/movieList",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMovieList(){
        return "Bahubaali";
    }

}
