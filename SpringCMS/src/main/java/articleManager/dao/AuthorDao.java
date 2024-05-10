package articleManager.dao;

import articleManager.entity.Article;
import articleManager.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void add(Author author){
        entityManager.persist(author);
    }
    public Author findById(Long id){
        return entityManager.find(Author.class, id);
    }
    public void update(Author author){
         entityManager.merge(author);
    }
    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }

    public List<Author> findAll(){
        Query query = entityManager.createQuery("select au from Author au");
        return query.getResultList();
    }
}
