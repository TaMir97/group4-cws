package org.example.util;

import org.example.repository.TaskRepo;
import org.example.repository.UserRepo;
import org.example.service.TaskService;
import org.example.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppEntityManagerFactory {

    private AppEntityManagerFactory() {
    }

    private static final EntityManagerFactory entityManagerFactory ;
    private static final EntityManager entityManager;
    private static final UserRepo userRepo;
    private static final UserService userService;
    private static final TaskRepo taskRepo;
    private static final TaskService taskService;


    static {
        entityManagerFactory =  Persistence.createEntityManagerFactory("postgres");
        entityManager = entityManagerFactory.createEntityManager();
        userRepo = new UserRepo(entityManager);
        userService = new UserService(userRepo);
        taskRepo = new TaskRepo(entityManager);
        taskService = new TaskService(taskRepo);
    }

    public static UserService getUserService() {
        return userService;
    }

    public static TaskService getTaskService() {
        return taskService;
    }
}
