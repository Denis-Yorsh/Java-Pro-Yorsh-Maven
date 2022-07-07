package com.hillel.hwYorsh4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Welcome {

    protected static void welcomeHuman() {
        System.out.println("Welcome to the 🤪Crazy🤪 Restaurant\nHere is your menu");
        crazyMenu();
    }

    protected static void crazyMenu() {
        String text = "Make your choice 0 - EXIT\n";
        List<Integer> choice = new LinkedList<>();
        humanChoice(text, choice);
        MethodsCrazyMenu.check(choice);
    }

    private static void humanChoice(String text, List<Integer> choice) {
        boolean inputDigits = false;
        String noChoice = "Try again";
        int a;
        while (!inputDigits) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(text + MethodsCrazyMenu.crazyMenu());
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
                if (a == 0) {
                    inputDigits = true;
                } else if (a > 0 && a < 10) {
                    choice.add(a);
                } else {
                    System.out.println(noChoice);
                }
            } else {
                System.out.println(noChoice);
            }
        }
    }
}
