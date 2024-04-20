package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import java.util.Optional;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController (AuthorDao authorDao){
        this.authorDao = authorDao;
    }


    @RequestMapping("/add")
    @ResponseBody
    public String hello() {
        Author author = new Author();
        author.setFirstName("Jan");
        author.setLastName("Brzechwa");
        authorDao.saveAuthor(author);
        return "ID dodanego autora to: "
                + author.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable Long id) {
        return Optional.ofNullable(authorDao.findById(id))
                .map(Author::toString)
                .orElse ( "Author o zadanym ID nie znajduje sie w bazie");
    }


    @RequestMapping("update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName, @PathVariable String lastName) {
        Author author = authorDao.findById(id);
        author.setLastName(lastName);
        author.setFirstName(firstName);
        authorDao.update(author);
        return "Dane zaktualizowane " + author.toString();
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "Autor o id : " + id + " został usunięty z bazy";
    }
}
