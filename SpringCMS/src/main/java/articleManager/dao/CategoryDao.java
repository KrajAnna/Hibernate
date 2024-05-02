package articleManager.dao;

import articleManager.entity.Author;
import articleManager.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CategoryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void add(Category category){
        entityManager.persist(category);
    }
    public Category findById(Long id){
        return entityManager.find(Category.class, id);
    }
    public void update(Category category){
         entityManager.merge(category);
    }
    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }
}
