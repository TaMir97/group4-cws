package org.example.repository;

import org.example.config.AppEntityManagerFactory;
import org.example.entity.Task;
import org.example.exception.TaskNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TaskRepo {
    private final EntityManager entityManager = AppEntityManagerFactory.getEntityManagerFactory();

    public void save(Task task) {
        entityManager.persist(task);
    }

    public void deleteById(Long id) {
        Task task = entityManager.find(Task.class, id);
        if (contains(task))
            entityManager.remove(task);
        else
            throw new TaskNotFoundException("The task doesn't exist.");
    }

    public void update(Task task) {
        if (contains(task))
            entityManager.merge(task);
        else
            throw new TaskNotFoundException("The task doesn't exist.");
    }

    public Task readById(Long id) {
        Task task = entityManager.find(Task.class, id);
        if (contains(task))
            return task;
        else
            throw new TaskNotFoundException("The task doesn't exist.");
    }

    public boolean contains(Task task) {
        return task.getId() != null;
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
