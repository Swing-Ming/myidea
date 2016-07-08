package com.kaishengit.service;


import com.kaishengit.mapper.BookMapper;
import com.kaishengit.pojo.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ListTestCase {

    private Logger logger = LoggerFactory.getLogger(ListTestCase.class);

    @Inject
    private BookService bookService;

    @Test
    public void findaAllTestCase(){
       List<Book> bookList = bookService.findAllBook();
        Assert.assertEquals(bookList.size(),29);

    }


}
