package org.example.service;

import org.example.config.AppEntityManagerFactory;
import org.example.entity.Task;
import org.example.repository.TaskRepo;

import javax.persistence.EntityManager;

public class TaskService {

    private final TaskRepo repository = new TaskRepo();


    public void save(Task task) {
        try {
            repository.beginTransaction();
            repository.save(task);

            repository.commitTransaction();

        } catch (Exception e) {
            repository.rollBack();
        }

    }

    public void update(Task task) {
        try {
            repository.beginTransaction();
            repository.update(task);
            repository.commitTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            repository.rollBack();
        }
    }

    public Task readById(Long id) {
        try {
            return repository.readById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteById(Long id) {
        try {
            repository.beginTransaction();
            repository.deleteById(id);
            repository.commitTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            repository.rollBack();
        }

    }

    public boolean contains(Task task) {
        return repository.contains(task);

    }


}
