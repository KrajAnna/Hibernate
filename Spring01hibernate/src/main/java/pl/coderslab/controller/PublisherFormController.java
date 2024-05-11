package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

import javax.validation.Valid;

@Controller
@RequestMapping("/publisherForm")
public class PublisherFormController {

    private final PublisherDao publisherDao;

    public PublisherFormController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping
    public String form(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/form";
    }

    @PostMapping
    public String saveForm(@Valid Publisher publisher, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "publisher/form";
        } else {
            if (publisher.getId() != null) {
                publisherDao.update(publisher);
            } else {
                publisherDao.savePublisher(publisher);
            }
            return "redirect:/publisherForm/list";
        }

    }

    @GetMapping("/list")
    public String listPublishers(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        return "publisher/list";
    }

    @GetMapping("/edit/{id}")
    public String editPublisher(@PathVariable long id, Model model) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "/publisher/form";
    }

    @GetMapping("/confirmDel/{id}")
    public String confirmDel(@PathVariable long id, Model model) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "/publisher/confirmDel";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable long id) {
        publisherDao.delete(publisherDao.findById(id));
        return "redirect:/publisherForm/list";
    }
}