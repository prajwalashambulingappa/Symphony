package com.example.coreservicesmongo.controller;

import com.example.coreservicesmongo.entity.Movies;
import com.example.coreservicesmongo.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @PostMapping("/new-arrivals")
    public Movies addmovie(@RequestBody Movies movie){
        return moviesService.addmovie(movie);
    }

    @GetMapping("/home")
    public List<Movies> listallmovies(){
        return moviesService.listallmovies();
    }

}
