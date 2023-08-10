package org.example.repository;

import org.example.config.AppEntityManagerFactory;
import org.example.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;

public class TaskRepo {
    private final EntityManagerFactory entityManagerFactory = AppEntityManagerFactory.getEntityManagerFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Task task){
        try {
        beginTransaction();
        entityManager.persist(task);
        commitTransaction();

        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }

    }


    public void beginTransaction(){
        if (!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();
    }
    public void commitTransaction(){
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().commit();
    }



}
