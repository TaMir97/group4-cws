package org.example.repository;

import org.example.util.AppEntityManagerFactory;
import org.example.entity.User;
import org.example.exception.UserNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserRepo {
    private final EntityManager entityManager;

    public UserRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        if (contains(user))
            entityManager.remove(user);
        else
            throw new UserNotFoundException("The user doesn't exist.");
    }

    public void update(User user) {
        if (contains(user))
            entityManager.merge(user);
        else
            throw new UserNotFoundException("The user doesn't exist.");
    }

    public User readById(Long id) {
        User user = entityManager.find(User.class, id);
        if (contains(user))
            return user;
        else
            throw new UserNotFoundException("The user doesn't exist.");
    }

    public User readByUsernamePassword(String username, String password) {
        String jpql = "select u from User u where u.username = :username and u.password = :password";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = (User) query.getSingleResult();
        if (contains(user))
            return user;
        else
            throw new UserNotFoundException("The user doesn't exist.");
    }

    public boolean contains(User user) {
        return user.getId() != null;
    }


    public void beginTransaction() {
        if (!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();
    }

    public void commitTransaction() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().commit();
    }

    public void rollBack() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();

    }
}
