package org.example.repository;

import org.example.config.AppEntityManagerFactory;
import org.example.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TaskRepo {
    private final EntityManager entityManager = AppEntityManagerFactory.getEntityManagerFactory();

    public void save(Task task){
        entityManager.persist(task);
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
