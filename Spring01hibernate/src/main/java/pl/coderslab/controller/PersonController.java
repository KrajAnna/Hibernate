package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import java.util.Optional;


@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonDao dao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao dao, PersonDetailsDao personDetailsDao) {
        this.dao = dao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id) {
        return Optional.ofNullable(dao.findById(id))
                .map(Person::toString)
                .orElse("Person not found");
    }

    @GetMapping("/{id}/delete")
    @ResponseBody
    public String deletePerson(@PathVariable long id) {
        dao.delete(dao.findById(id));
        return "deleted";
    }

    @GetMapping("/{id}/updateEmail/{email}")
    @ResponseBody
    public String updatePerson(@PathVariable long id, @PathVariable String email) {
        Person person = dao.findById(id);
        person.setEmail(email);
        dao.update(person);
        return person.toString();
    }

    @GetMapping
    @ResponseBody
    public String savePerson() {
        PersonDetails personDetails = new PersonDetails("Jan", "Nowak", "25/4", "Street", "City");
        personDetailsDao.savePersonDetails(personDetails);
        Person person = new Person("testLogin", "haslo", "test@test.com", personDetails);
        dao.savePerson(person);
        return "Person id: " + person.getId();
    }
}

