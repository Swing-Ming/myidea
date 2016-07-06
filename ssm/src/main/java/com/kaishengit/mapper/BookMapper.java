package com.kaishengit.mapper;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;


import java.util.List;

public interface BookMapper {
    void save(Book book);
    List<Book> findAll();
    void del(Integer id);
    void update(Book book);
    Book findById( Integer id);


}
