package com.hillel.hwYorsh4;

import com.hillel.hwYorsh4.MenuAndPrice.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MethodsCrazyMenu {
    // user selection processing
    protected static void checkTotal(List<Integer> humanChoice) {
        StringBuilder name = checkTotalName(humanChoice);
        double sum = checkTotalSum(humanChoice);
        toStringCheck(name, sum);
    }
    // data acquisition and processing databaseName
    protected static StringBuilder checkTotalName(List<Integer> humanChoice) {
        StringBuilder name = new StringBuilder();
        for (Integer integer : humanChoice) {
            if (integer > 0) {
                name.append(databaseName(integer)).append(" ");
            }
        }
        return name;
    }
    // data acquisition and processing databaseSum
    protected static double checkTotalSum(List<Integer> humanChoice) {
        double sun = 0;
        for (Integer integer : humanChoice) {
            if (integer > 0) {
                sun += databaseSum(integer);
            }
        }
        return sun;
    }
    // food database
    protected static StringBuilder databaseName(int number) {
        HashMap<Integer, Check> menu = new HashMap<>();
        menu.put(1, new Borscht());
        menu.put(2, new Soup());
        menu.put(3, new Potato());
        menu.put(4, new Steak());
        menu.put(5, new Salad());
        menu.put(6, new Tea());
        menu.put(7, new Coffee());
        menu.put(8, new Cola());
        menu.put(9, new Water());

        StringBuilder namePrice = new StringBuilder();
        return namePrice
                .append(menu.get(number).getClass().getSimpleName())
                .append(" ")
                .append(menu.get(number).priceAll())
                .append(menu.get(number).getDOLLARS());
    }
    // food database
    protected static double databaseSum(int number) {
        HashMap<Integer, Check> menu = new HashMap<>();
        menu.put(1, new Borscht());
        menu.put(2, new Soup());
        menu.put(3, new Potato());
        menu.put(4, new Steak());
        menu.put(5, new Salad());
        menu.put(6, new Tea());
        menu.put(7, new Coffee());
        menu.put(8, new Cola());
        menu.put(9, new Water());

        return menu.get(number).priceAll();
    }
    // list of dishes present
    protected static HashSet<String> crazyMenu() {
        HashSet<String> crazyMenu = new HashSet<>();
        crazyMenu.add("1 - Borscht");
        crazyMenu.add("2 - Soup");
        crazyMenu.add("3 - Potato");
        crazyMenu.add("4 - Steak");
        crazyMenu.add("5 - Salad");
        crazyMenu.add("6 - Tea");
        crazyMenu.add("7 - Coffee");
        crazyMenu.add("8 - Cola");
        crazyMenu.add("9 - Water");
        crazyMenu.add("0 - EXIT");
        return crazyMenu;
    }
    // formation of a check
    protected static void toStringCheck(StringBuilder name, double sun) {
        System.out.println("You ordered\n"+ name);
        System.out.printf("Total sum = %.2f%s", sun, new Borscht().getDOLLARS());
        System.out.println("\nEnjoy your meal");
    }
}
