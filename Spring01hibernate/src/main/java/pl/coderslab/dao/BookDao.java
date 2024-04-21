package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;
    public void save (Book book){
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }
    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> findAll(){
        return entityManager.createQuery("select b FROM Book b").getResultList();
    }
    public List<Book> findAllByRating(int rat){
        return entityManager.createQuery("select b FROM Book b WHERE b.rating = :rating", Book.class)
                .setParameter("rating", rat) //ustawiam rat jako "rating" w tabeli
                .getResultList();
    }

    public List<Book> findAllWithPublisher(){
        return entityManager.createQuery("select b FROM Book b JOIN b.publisher", Book.class).getResultList();
    }


}
