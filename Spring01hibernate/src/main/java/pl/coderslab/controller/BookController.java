package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    //private final List<Author> authors;
    private final AuthorDao authorDao;


    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;

    }

    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        Book book = new Book();
        Publisher publisher = new Publisher();
        publisher.setName("Publisher1");
        Author author1 = authorDao.findById(4);
        Author author2 = authorDao.findById(2);
        //book.setAuthors(authors);
        book.setTitle("Książka 1");
        book.setRating(8);
        book.setDescription("Opis książki");
        book.addAuthor(author1);
        book.addAuthor(author2);
        bookDao.save(book);
        return "ID dodanej książki to: "
                + book.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
//        try {
//            Book book = bookDao.findById(id);
//            return book.toString();
//        } catch (NullPointerException e){
//            return "Ksiązka o zadanym ID nie znajduje sie w bazie";
//        }
        return Optional.ofNullable(bookDao.findById(id))
                .map(Book::toString)
                .orElse ( "Ksiązka o zadanym ID nie znajduje sie w bazie");
    }

    @RequestMapping("/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return "Ksiązka zaktualizowana: " + book.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "Deleted";
    }

    @GetMapping("/all")
    @ResponseBody
    public String findAll(){
        return bookDao.findAll().toString();
    }

    @GetMapping("/allByRating/{rating}")
    @ResponseBody
    public String findAllByRating(@PathVariable int rating){
        return bookDao.findAllByRating(rating).toString();
    }


}
