package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import java.util.Optional;


@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao dao, PersonDetailsDao personDetailsDao) {
        this.personDao = dao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id) {
        return Optional.ofNullable(personDao.findById(id))
                .map(Person::toString)
                .orElse("Person not found");
    }

    @GetMapping("/{id}/delete")
    @ResponseBody
    public String deletePerson(@PathVariable long id) {
        personDao.delete(personDao.findById(id));
        return "deleted";
    }

    @GetMapping("/{id}/updateEmail/{email}")
    @ResponseBody
    public String updatePerson(@PathVariable long id, @PathVariable String email) {
        Person person = personDao.findById(id);
        person.setEmail(email);
        personDao.update(person);
        return person.toString();
    }

    @GetMapping
    @ResponseBody
    public String savePerson() {
        PersonDetails personDetails = new PersonDetails("Jan", "Nowak", "25/4", "Street", "City");
        personDetailsDao.savePersonDetails(personDetails);
        Person person = new Person("testLogin", "haslo", "test@test.com", personDetails);
        personDao.savePerson(person);
        return "Person id: " + person.getId();
    }

    @GetMapping("/form")
    public String displayForm(){
        return "person/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String sendForm(@RequestParam String login, @RequestParam String password, @RequestParam String email){

        Person person = new Person(login, password, email);
        personDao.savePerson(person);
        return person.toString() +" Użytkownik został dodany do bazy, ID: " + person.getId();
    }

    @GetMapping("/form/bind")
    public String displayFormBind(Model model){
        model.addAttribute("person", new Person());
        return "person/form-bind";
    }

    @PostMapping("/form/bind")
    @ResponseBody
    public String sendFormBind(Person person){
        personDao.savePerson(person);
        return person.toString() +" Użytkownik został dodany do bazy pod ID: " + person.getId();
    }

}

