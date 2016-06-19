package com.kaishengit.service;
import com.kaishengit.dao.MovieDao;
import com.kaishengit.entity.Movie;
import com.kaishengit.util.Page;

import java.util.List;

public class MovieService {

    private MovieDao movieDao = new MovieDao();

    public List<Movie> findAllMovie(){

        return movieDao.findAll();
    }

    public Page<Movie> findMovieByPageNo(int pageNo){


        int  totalSize = movieDao.count().intValue();

        Page<Movie> page = new Page<>(totalSize,10,pageNo);


        List<Movie> movieList = movieDao.findByPage(page.getStart(),10);
        page.setItems(movieList);
        return page;

//        int  totalsize = movieDao.count().intValue();
//        int size = 10;
//        int start = (pageNo -1)*size;
//        int totalPageSize = totalsize/size;
//        if(totalsize%size != 0){
//            totalPageSize++;
//        }
//        if(pageNo>totalPageSize){
//            pageNo = totalPageSize;
//        }
//
//
//
//
//
//        return movieDao.findByPage(start,size);

    }
}
