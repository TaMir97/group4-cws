package org.example.repository;

import org.example.config.AppEntityManagerFactory;
import org.example.entity.User;
import org.example.exception.UserNotFoundException;

import javax.persistence.EntityManager;

public class UserRepo {
    private final EntityManager entityManager = AppEntityManagerFactory.getEntityManagerFactory();

    public void save(User user){
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

    public boolean contains(User user) {
        return user.getId() != null;
    }


    public void beginTransaction(){
        if (!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();
    }
    public void commitTransaction(){
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().commit();
    }

    public void rollBack() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();

    }
}
