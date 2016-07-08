package com.kaishengit.controller;

import com.kaishengit.pojo.Book;
import com.kaishengit.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class DataTableController {
    @Inject
    private BookService bookService;
    @RequestMapping(value="/datatable",method = RequestMethod.GET)
    public String dataList(Model model){
       model.addAttribute("books",bookService.findAllBook());
        for (Book book:bookService.findAllBook()) {
            System.out.println(book);

        }


        return "datatables/list";
    }




}
