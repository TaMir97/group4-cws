package org.example.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.example.ui.Logic.*;
import static org.example.ui.Printer.*;

public class Menu {


    public <T> void makeMenuD(String[] options, String[] methods, Class <T> userClassForMenu) {


        Map<String, Runnable> actions = new HashMap<>();
        for (int i = 0; i < options.length; i++) {
            int optionNumber = i + 1;
            String methodName = methods[i];

            actions.put(String.valueOf(optionNumber), () -> invokeMethod(methodName, userClassForMenu));
        }


        int EXIT_OPTION = options.length + 2 ;
        int BACK_OPTION = options.length + 1 ;
        actions.put(String.valueOf(EXIT_OPTION), () -> System.exit(0));
        actions.put(String.valueOf(BACK_OPTION), () -> { });



        while (true) {
            printMenu(options, "Welcome");
            printPrompt();

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next().trim();

            if (actions.containsKey(choice)) {
                actions.get(choice).run();
            } else {
                printWarning("Item not found");
            }
        }
    }


    String[] mainOptions  = {"Choose an entity"};
    String[] mainMethods = {"chooseEntity"};




}
