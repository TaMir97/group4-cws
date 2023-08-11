package org.example;

import org.example.entity.Task;
import org.example.entity.User;
import org.example.entity.enumaration.Mode;
import org.example.entity.enumaration.TaskPriority;
import org.example.repository.TaskRepo;
import org.example.service.TaskService;
import org.example.service.UserService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setUsername("amin");
        user1.setPassword("aminamin");

        UserService userService = new UserService();
        userService.save(user1);



        Task task = new Task();
        task.setName("nasdasdahar");
        task.setDescription("emroooooz");
        task.setDueDate(LocalDate.of(2023, 12, 12));
        task.setTaskPriority(TaskPriority.HIGH);
        task.setMode(Mode.COMPLETED);
        task.setUser(user1);


        TaskService taskService = new TaskService();
        taskService.save(task);


    }
}