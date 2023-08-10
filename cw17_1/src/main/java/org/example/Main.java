package org.example;

import org.example.entity.Task;
import org.example.entity.enumeration.Mode;
import org.example.entity.enumeration.TaskPriority;
import org.example.repository.TaskRepo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        task.setName("nahar");
        task.setDescription("emroz");
        task.setDueDate(LocalDate.of(2023,12,12));
        task.setTaskPriority(TaskPriority.HIGH);
        task.setMode(Mode.COMPLETED);
        TaskRepo taskRepo = new TaskRepo();
        taskRepo.save(task);

    }
}