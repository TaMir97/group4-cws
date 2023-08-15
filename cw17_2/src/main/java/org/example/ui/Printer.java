package org.example.ui;

import static org.example.ui.Color.*;

public class Printer {


    public static void printMenu(String[] items, String topic) {
        int selectedIndex = 0;
        System.out.println("----------- " + topic + " -----------");
        for (int i = 0; i < items.length; i++) {
            System.out.println(ANSI_GREEN + (i + 1) + ") " + ANSI_RESET + items[i]);
        }

        System.out.println(ANSI_GREEN + (items.length + 1) + ") " + ANSI_RESET + "go to back menu");
        System.out.println(ANSI_GREEN + (items.length + 2) + ") " + ANSI_RESET + "Exit");
    }

    public static void printPrompt() {

        System.out.print(ANSI_GREEN + "Choose an option : " + ANSI_RESET);
    }


    public static void printMsg(String msg, boolean nextLine) {
        if (nextLine)
            System.out.println(msg);
        else
            System.out.print(msg);
    }


    public static void printWarning(String msg) {
        System.out.println(ANSI_RED + ">>>> " + msg + "\n" + ANSI_RESET);
    }



}
