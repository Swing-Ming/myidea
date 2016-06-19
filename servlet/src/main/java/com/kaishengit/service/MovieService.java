package com.kaishengit.service;

import com.kaishengit.dao.MovieDao;
import com.kaishengit.entity.Movie;
import com.kaishengit.util.Page;
import java.util.List;


public class MovieService {

     private MovieDao movieDao = new MovieDao();

     public Page<Movie> serviceMovie(int pageNo){
         int totalSize = movieDao.count().intValue();
         Page<Movie> page = new Page<>(totalSize,pageNo,10);

         List<Movie> movieList = movieDao.findByPage(page.getStart(),10);

         return null;
     }

}
