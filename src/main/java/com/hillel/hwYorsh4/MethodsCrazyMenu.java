package com.hillel.hwYorsh4;

import com.hillel.hwYorsh4.MenuAndPrice.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MethodsCrazyMenu {

    protected static void checkTotal(List<Integer> humanChoice) {
        StringBuilder name = checkTotalName(humanChoice);
        double sum = checkTotalSum(humanChoice);
        toStringCheck(name, sum);
    }

    protected static StringBuilder checkTotalName(List<Integer> humanChoice) {
        StringBuilder name = new StringBuilder();
        for (Integer integer : humanChoice) {
            if (integer > 0) {
                name.append(databaseName(integer)).append(" ");
            }
        }
        return name;
    }

    protected static double checkTotalSum(List<Integer> humanChoice) {
        double sun = 0;
        for (Integer integer : humanChoice) {
            if (integer > 0) {
                sun += databaseSum(integer);
            }
        }
        return sun;
    }

    protected static StringBuilder databaseName(int number) {
        HashMap<Integer, Object> menu = new HashMap<>();
        menu.put(1, new Borscht(1));
        menu.put(2, new Soup(1));
        menu.put(3, new Potato(1));
        menu.put(4, new Steak(1));
        menu.put(5, new Salad(1));
        menu.put(6, new Tea(1));
        menu.put(7, new Coffee(1));
        menu.put(8, new Cola(1));
        menu.put(9, new Water(1));

        StringBuilder namePrice = new StringBuilder();
        return namePrice
                .append(menu.get(number).getClass().getSimpleName())
                .append(" ")
                .append(((Check) menu.get(number)).priceAll())
                .append(((Check) menu.get(1)).getDOLLARS());
    }

    protected static double databaseSum(int number) {
        HashMap<Integer, Object> menu = new HashMap<>();
        menu.put(1, new Borscht(1));
        menu.put(2, new Soup(1));
        menu.put(3, new Potato(1));
        menu.put(4, new Steak(1));
        menu.put(5, new Salad(1));
        menu.put(6, new Tea(1));
        menu.put(7, new Coffee(1));
        menu.put(8, new Cola(1));
        menu.put(9, new Water(1));

        return ((Check) menu.get(number)).priceAll();
    }

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

    protected static void toStringCheck(StringBuilder name, double sun) {
        System.out.println("You ordered\n"+ name);
        System.out.printf("Total sum = %.2f", sun);
        System.out.println("Enjoy your meal");
    }
}
