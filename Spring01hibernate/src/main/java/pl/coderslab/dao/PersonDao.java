package pl.coderslab.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Person;

import javax.persistence.*;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(Person person) {
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }
}
