package org.example.service;

import org.example.entity.Task;
import org.example.repository.TaskRepo;

import java.util.List;

public class TaskService {

    private final TaskRepo repository;

    public TaskService(TaskRepo repository) {
        this.repository = repository;
    }


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

    public List<Task> loadAll(){
        return repository.loadAll();
    }

    public boolean contains(Task task) {
        return repository.contains(task);

    }


}
