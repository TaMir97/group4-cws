package org.example.repository;

import org.example.config.AppEntityManagerFactory;
import org.example.entity.Task;
import org.example.entity.User;

import javax.persistence.EntityManager;

public class UserRepo {
    private final EntityManager entityManager = AppEntityManagerFactory.getEntityManagerFactory();

    public void save(User user){
        entityManager.persist(user);
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
