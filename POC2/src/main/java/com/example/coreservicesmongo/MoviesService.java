package com.example.coreservicesmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return moviesDao.addmovie(movie);
    }

    public List<Movies>listallmovies(){
        return moviesDao.listallmovies();
    }
}
