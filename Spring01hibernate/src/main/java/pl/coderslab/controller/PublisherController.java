package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import java.util.Optional;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    private final PublisherDao publisherDao;

    public PublisherController (PublisherDao publisherDao){
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String hello() {
        Publisher publisher = new Publisher();
        publisher.setName("Jan");
        publisherDao.savePublisher(publisher);
        return "ID dodanego wydawcy to: "
                + publisher.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable Long id) {
        return Optional.ofNullable(publisherDao.findById(id))
                .map(Publisher::toString)
                .orElse ( "Wydawca o zadanym ID nie znajduje sie w bazie");
    }


    @RequestMapping("update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return "Dane zaktualizowane " + publisher.toString();
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "Wydawca o id : " + id + " został usunięty z bazy";
    }
}
