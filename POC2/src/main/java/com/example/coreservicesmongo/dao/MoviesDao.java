package com.example.coreservicesmongo.dao;

import com.example.coreservicesmongo.entity.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class MoviesDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /*public MoviesDao(@Lazy MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }*/

    public Movies addmovie(Movies newMovie){
        Movies newarrivals = mongoTemplate.save(newMovie, "movies");
        return newarrivals;
    }

    public List<Movies>listallmovies(int id){
        Query query = new Query();
        query.addCriteria(Criteria.where("tenantid").is(String.valueOf(id)));
        List<Movies> AllMovies= mongoTemplate.find(query, Movies.class, "movies");
        return AllMovies;
    }
}
