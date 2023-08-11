package org.example.ui;

import org.example.entity.Task;
import org.example.entity.User;
import org.example.entity.enumaration.Mode;
import org.example.entity.enumaration.TaskPriority;
import org.example.service.TaskService;
import org.example.service.UserService;
import org.example.util.AppEntityManagerFactory;
import org.example.util.Constant;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class Menu {
    static Scanner input = new Scanner(System.in);
    static UserService userService = AppEntityManagerFactory.getUserService();
    static TaskService taskService = AppEntityManagerFactory.getTaskService();

    public static void run() {
        System.out.println("Enter your choice: ");
        Printer.printItem(Constant.ENTRANCE_MENU, "Entrance Menu");
        String initialInput = input.nextLine();
        boolean initialMenuLoop = true;

        while (initialMenuLoop) {
            switch (initialInput) {
                case "1" -> signIn();
                case "2" -> singUp();
                case "3" -> initialMenuLoop = false;
                default ->  System.out.println("This choice does not exist.");
            }
        }
    }

    private static void signIn() {
        System.out.print("username: ");
        String username = input.nextLine();
        System.out.print("password:");
        String password = input.nextLine();
        User user = userService.readByUsernamePassword(username, password);

        if (user == null) {
            System.out.println("user does not exist");
            return;
        }
        Printer.printItem(Constant.SIGN_IN_MENU, "****You have signed in successfully****");
        String taskInput = input.nextLine();
        task_menu(taskInput, user);
    }

    private static void task_menu(String taskInput, User user) {
        System.out.println("Enter your choice: ");
        boolean taskMenuLoop = true;

        while (taskMenuLoop) {
            switch (taskInput) {
                case "1" -> {
                    List<Task> taskList = taskService.loadAll();
                    String[] allTasks = new String[taskList.size()];
                    for (int i = 0; i < taskList.size(); i++)
                        allTasks[i] = String.valueOf(taskList.get(i));
                    Printer.printItem(allTasks, "Here are your tasks:");
                }
                case "2" -> {
                    Task newTask = new Task();
                    System.out.println("Enter the task title:");
                    newTask.setName(input.nextLine());
                    System.out.println("Enter the Description(optional):");
                    newTask.setDescription(input.nextLine());
                    System.out.println("Enter the dueDate(year,month,day)");
                    try {
                        LocalDate dueDate = LocalDate.of(input.nextInt(),
                                input.nextInt(),
                                input.nextInt());
                        newTask.setDueDate(dueDate);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    String[] priorities = new String[3];
                    for (int i = 0; i < 3; i++)
                        priorities[i] = String.valueOf(Arrays.asList(TaskPriority.values()).get(i));
                    Printer.printItem(priorities, "Choose a Priority:");
                    try {
                        newTask.setTaskPriority(TaskPriority.values()[input.nextInt() - 1]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    String[] modes = new String[3];
                    for (int i = 0; i < 3; i++)
                        modes[i] = String.valueOf(Arrays.asList(Mode.values()).get(i));
                    Printer.printItem(modes, "Choose a Mode:");
                    try {
                        newTask.setMode(Mode.values()[input.nextInt() - 1]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    newTask.setUser(user);
                    taskService.save(newTask);
                }
                case "3" -> {
                    taskService.loadAll();
                    System.out.println("Choose an existing task to change the mode: ");
                    Task changedTask;
                    try {
                        changedTask = taskService.readById(input.nextLong());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    String[] newMode = new String[3];
                    for (int i = 0; i < 3; i++)
                        newMode[i] = String.valueOf(Arrays.asList(Mode.values()).get(i));
                    Printer.printItem(newMode, "Choose a Mode:");
                    try {
                        changedTask.setMode(Mode.values()[input.nextInt() - 1]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    taskService.update(changedTask);
                }
                case "4" -> {
                    Printer.printItem(Constant.SORTING_MODE, "Choose a sorting mode: ");
                    switch (input.nextLine()) {
                        case "1" -> taskService.sortByDueDateAscending().forEach(System.out::println);
                        case "2" -> taskService.sortByDueDateDescending().forEach(System.out::println);
                        default -> System.out.println("your choice does not exist.");
                    }
                }
                case "5" -> {
                    taskMenuLoop = false;
                    break;
                }
                default -> System.out.println("your choice does not exist.");
            }
        }


    }

    private static void singUp(){
        User user = new User();
        System.out.println("Enter your username");
        user.setUsername(input.nextLine());
        System.out.println("Enter your password");
        user.setPassword(input.nextLine());
        userService.save(user);
    }

}
