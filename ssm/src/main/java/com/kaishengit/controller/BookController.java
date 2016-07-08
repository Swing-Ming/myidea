package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import com.kaishengit.service.BookService;
import com.kaishengit.util.Page;
import com.kaishengit.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

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
    public String list( @RequestParam(required = false,defaultValue = "1") Integer p,
                        @RequestParam(required = false) String bookname,
                        @RequestParam(required = false) Integer type,
                        @RequestParam(required = false) Integer pub,
                        Model model) {
        bookname = Strings.toUTF8(bookname);
     /*   List<Book> bookList = bookService.findAllBook();*/
        Map<String,Object> param = Maps.newHashMap();
        param.put("bookname",bookname);
        param.put("type",type);
        param.put("pub",pub);

        Page<Book> page = bookService.findByPage(p,param);

        model.addAttribute("types",bookService.findAlltype());
        model.addAttribute("pubs",bookService.findAllPub());
        model.addAttribute("page", page);
        model.addAttribute("bookname",bookname);
        model.addAttribute("typeid",type);
        model.addAttribute("pubid",pub);
        return "books/list";
    }

    @RequestMapping(value = "/{id:\\d+}/del", method = RequestMethod.GET)
    public String del(@PathVariable Integer id,
                      RedirectAttributes redirectAttributes) {
        bookService.delBook(id);
        System.out.println(id);
        redirectAttributes.addFlashAttribute("message","操作成功");
        return "redirect:/books";
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    public String editBook(@PathVariable Integer id, Model model) {
        Book book = bookService.findById(id);
        if(book==null){
            throw new NotFoundException();
        }
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
    public String saveBook(Book book ,RedirectAttributes redirectAttributes){

        bookService.saveBook(book);
        redirectAttributes.addFlashAttribute("message","操作成功");
        return "redirect:/books";

    }


}
