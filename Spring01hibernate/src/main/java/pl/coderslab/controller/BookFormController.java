package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.*;
import org.springframework.ui.Model;

import javax.validation.Valid;
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
    public String sendForm(@Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "book/form";
        } else {
            if (book.getId() != null) {
                bookDao.update(book);
            } else {
                bookDao.save(book);
            }
            return "redirect:/bookForm/list";
        }

    }

    @GetMapping("/list")
    public String findAll(Model model){
        model.addAttribute("books", bookDao.findAll());
        return "book/list";
    }
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "/book/form";
    }

    @GetMapping("/confirmDel/{id}")
    public String confirmDel(@PathVariable long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "/book/confirmDel";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/bookForm/list";
    }


}
