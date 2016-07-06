package com.kaishengit.controller;

import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import com.kaishengit.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

  /*  @Inject
   private BookService bookService;
    @RequestMapping(value = "/new" ,method = RequestMethod.GET)
    public String saveBook(Model model ){
    }*/

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Book> bookList = bookService.findAllBook();
        model.addAttribute("books", bookList);
        return "books/list";
    }

    @RequestMapping(value = "/{id:\\d+}/del", method = RequestMethod.GET)
    public String del(@PathVariable Integer id,
                      RedirectAttributes redirectAttributes) {
        bookService.delBook(id);
        System.out.println(id);
        redirectAttributes.addAttribute("message", "操作成功");
        return "redirect:/books";
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    public String editBook(@PathVariable Integer id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("types", bookService.findAlltype());
        model.addAttribute("pubs", bookService.findAllPub());
        model.addAttribute("book", book);
        return "/books/edit";
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.POST)
    public String editBook(Book book, RedirectAttributes redirectAttributes) {
        bookService.update(book);
        redirectAttributes.addFlashAttribute("message", "操作成功");

        return "redirect:/books";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String saveBook(Model model) {

        List<BookType> bookTypeList = bookService.findAlltype();
        List<Publisher> publisherList = bookService.findAllPub();

        model.addAttribute("types", bookTypeList);
        model.addAttribute("pubs", publisherList);
        return "books/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveBook(Book book ){
        bookService.saveBook(book);
        return "redirect:/books";

    }
    

}
