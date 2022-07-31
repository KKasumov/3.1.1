package ru.kata.spring.boot.demo.dao;

import ru.kata.spring.boot.demo.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> index() {
        String jpql = "SELECT c FROM User c ";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

        return query.getResultList();
    }


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void delete (User id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }
}
