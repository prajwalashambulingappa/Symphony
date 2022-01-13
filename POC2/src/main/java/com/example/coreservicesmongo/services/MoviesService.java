package com.example.coreservicesmongo.services;

import com.example.coreservicesmongo.dao.MoviesDao;
import com.example.coreservicesmongo.configurations.TenantContext;
import com.example.coreservicesmongo.entity.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MoviesDao moviesDao;

    public Movies addmovie(Movies movie) {

        int id= TenantContext.getTenantID();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                TenantContext.createContext(id);
                System.out.println(TenantContext.getTenantID());
            }
        });

        t.start();

        String seqname = id + " " + Movies.SEQUENCE_NAME;
        long Id = DBsequenceService.Gensequence(seqname);
        movie.setId(id + "_" +Id);
        movie.setTenantid(String.valueOf(id));
        return moviesDao.addmovie(movie);
    }

    public List<Movies>listallmovies(){
        int id = TenantContext.getTenantID();
        return moviesDao.listallmovies(id);
    }
}
