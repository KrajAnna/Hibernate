package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.*;
import org.springframework.ui.Model;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

//@Transactional
@Controller
@RequestMapping("/bookForm")
public class BookFormController {
    //    private final BookDao bookDao;
    private final BookRepository bookRepository;
    private final PublisherDao publisherDao;
    private final Validator validator;

    public BookFormController(BookRepository bookRepository, PublisherDao publisherDao, Validator validator) {
        this.bookRepository = bookRepository;
        this.publisherDao = publisherDao;
        this.validator = validator;
    }


    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.findAll();
    }

    @GetMapping("/form")
    public String displayForm(Model model) {
        model.addAttribute("book", new Book());
        return "/book/form";
    }

    @PostMapping("/form")
    public String sendForm(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/form";
        } else {
            if (book.getId() != null) {
                //bookRepository.update(book);
            } else {
                bookRepository.save(book);
            }
            bookRepository.save(book);
            return "redirect:/bookForm/list";
        }

    }

    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable long id, Model model) {
        Book book = bookRepository.getOne(id);
        model.addAttribute("book", book);
        return "/book/form";
    }

    @GetMapping("/confirmDel/{id}")
    public String confirmDel(@PathVariable long id, Model model) {
        Book book = bookRepository.getOne(id);
        model.addAttribute("book", book);
        return "/book/confirmDel";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookRepository.deleteById(id);
        return "redirect:/bookForm/list";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        Category category = new Category();
        category.setId(1L);
        category.setName("category");
        return bookRepository.findFirstByOrderByCategoryAsc(category).toString();
    }


}
