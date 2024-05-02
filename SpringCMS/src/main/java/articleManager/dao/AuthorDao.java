package articleManager.dao;

import articleManager.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
