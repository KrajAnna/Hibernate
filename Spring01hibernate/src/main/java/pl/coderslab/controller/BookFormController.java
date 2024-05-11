package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/bookForm")
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }


    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.findAll();
    }
    @GetMapping("/form")
    public String displayForm(Model model){
    model.addAttribute("book", new Book());
    return "/book/form";
    }

    @PostMapping("/form")
    public String sendForm(Book book) {
        bookDao.save(book);
        return "redirect:/bookForm/list";
    }

    @GetMapping("/list")
    public String findAll(Model model){
        model.addAttribute("books", bookDao.findAll());
        return "book/list";
    }


}
