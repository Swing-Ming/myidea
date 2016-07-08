package com.kaishengit.service;

import com.kaishengit.mapper.BookMapper;
import com.kaishengit.mapper.BookPubMapper;
import com.kaishengit.mapper.BookTypeMapper;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import com.kaishengit.util.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
@Transactional
public class BookService {

    @Inject
    private BookMapper bookMpper;
    @Inject
    private BookTypeMapper bookTypeMapper;
    @Inject
    private BookPubMapper bookPubMapper;

    public void  saveBook(Book book){
        bookMpper.save(book);
    }

    public List<Book> findAllBook(){
       return bookMpper.findAll();
    }

    public void delBook(Integer id){
        bookMpper.del(id);
    }

    public void update(Book book){
        bookMpper.update(book);

    }

    public Book findById(Integer id ){

        return bookMpper.findById(id);
    }

    public List<BookType> findAlltype(){
        return bookTypeMapper.findAlltype();
    }

    public List<Publisher> findAllPub(){
        return bookPubMapper.findAllPub();
    }

    /*public Long count(){
        return
    }*/

    public Page<Book> findByPage(Integer p){
        int totalSize  = bookMpper.count().intValue();
        Page<Book> page = new Page<>(p,5,totalSize);
        List<Book> bookList =bookMpper.findByPage(page.getStart(),5);
        page.setItems(bookList);
        return page;
    }


    public Page<Book> findByPage(Integer p, Map<String, Object> param) {
        int totalSize = bookMpper.countByParam(param).intValue();
        Page<Book> page = new Page<>(p,5,totalSize);
        param.put("start",page.getStart());
        param.put("size",5);
        List<Book> bookList = bookMpper.findByParam(param);
        page.setItems(bookList);
        return page;
    }

    public List<Book> findDataTable(){

        return bookMpper.findAll();

    }
}
