package articleManager.dao;

import articleManager.entity.Article;
import articleManager.entity.Author;
import articleManager.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
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

    public List<Category> findAll(){
        Query query = entityManager.createQuery("select cat from Category cat");
        return query.getResultList();
    }
}
