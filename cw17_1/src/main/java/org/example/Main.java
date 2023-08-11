package org.example;

import org.example.entity.Task;
import org.example.entity.User;
import org.example.entity.enumaration.Mode;
import org.example.entity.enumaration.TaskPriority;
import org.example.repository.TaskRepo;
import org.example.service.TaskService;
import org.example.service.UserService;
import org.example.ui.Menu;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Menu.run();


    }
}