package org.example.repository;

import org.example.util.AppEntityManagerFactory;
import org.example.entity.Task;
import org.example.exception.TaskNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class TaskRepo {
    private final EntityManager entityManager;

    public TaskRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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

    public List<Task> loadAll(){
        return  entityManager.createQuery("select t from Task t", Task.class).getResultList();
    }

    public List<Task> sortByDueDateAscending(){
        String jpql = "select t from Task t order by t.dueDate asc ";
        TypedQuery<Task> query = entityManager.createQuery(jpql,Task.class);
        return query.getResultList();
    }
    public List<Task> sortByDueDateDescending(){
        String jpql = "select t from Task t order by t.dueDate desc ";
        TypedQuery<Task> query = entityManager.createQuery(jpql,Task.class);
        return query.getResultList();
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
