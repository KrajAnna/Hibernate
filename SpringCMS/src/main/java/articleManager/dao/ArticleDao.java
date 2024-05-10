package articleManager.dao;

import articleManager.entity.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void add(Article article){
        entityManager.persist(article);
    }
    public Article findById(Long id){
        return entityManager.find(Article.class, id);
    }
    public void update(Article article){
         entityManager.merge(article);
    }
    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public List<Article> findAll(){
        Query query = entityManager.createQuery("select ar from Article ar");
        return query.getResultList();
    }
    public List<Article> findQty(int qty){
        Query query = entityManager.createQuery("select ar from Article ar");
        return query.setMaxResults(qty).getResultList();
    }
}
