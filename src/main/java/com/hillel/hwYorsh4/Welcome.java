package com.hillel.hwYorsh4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Welcome {

    protected static void welcomeHuman() {
        System.out.println("Welcome to the Crazy Restaurant\nHere is your menu");
        crazyMenu();
    }

    protected static void crazyMenu() {
        String text = "Make your choice 0 - EXIT\n";
        List<Integer> choice = new LinkedList<>();
        humanChoice(text, choice);
        System.out.println(choice);
    }

    private static void humanChoice(String text, List<Integer> choice) {
        boolean inputDigits = false;
        int a;
        while (!inputDigits) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(text + MethodsCrazyMenu.CrazyMenu());
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
                if (a == 0) { inputDigits = true; }
                choice.add(a);
            } else {
                System.out.println("Try again");
            }
        }
    }
}
