package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

import java.util.Optional;

@Controller
public class BookController {
    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String hello() {
        Book book = new Book();
        book.setTitle("Książka 1");
        book.setRating(8);
        book.setDescription("Opis książki");
        bookDao.saveBook(book);
        return "ID dodanej książki to: "
                + book.getId();
    }

    @RequestMapping("/book/get/{id}")
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

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return "Ksiązka zaktualizowana: " + book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "Deleted";
    }


}
