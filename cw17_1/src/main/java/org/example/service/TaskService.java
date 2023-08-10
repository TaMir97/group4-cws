package org.example.service;

import org.example.config.AppEntityManagerFactory;
import org.example.entity.Task;
import org.example.repository.TaskRepo;

import javax.persistence.EntityManager;

public class TaskService {

    private final TaskRepo repository = new TaskRepo();


    public void save(Task task){
        try {
            repository.beginTransaction();
            repository.save(task);

            repository.commitTransaction();

        }catch (Exception e){
            repository.rollBack();
        }

    }

}
