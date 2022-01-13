package com.example.coreservicesmongo;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class MoviesDao {

    private final MongoTemplate mongoTemplate;

    public MoviesDao(@Lazy MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public Movies addmovie(Movies newMovie){
        Movies newarrivals = mongoTemplate.save(newMovie, "movies");
        return newarrivals;
    }

    public List<Movies>listallmovies(){
        Query query = new Query();
        List<Movies> AllMovies= (List<Movies>) mongoTemplate.find(query, Movies.class, "movies");
        return AllMovies;
    }
}
