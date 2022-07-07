package com.hillel.hwYorsh4;

import java.util.HashSet;

public class MethodsCrazyMenu {

    protected static HashSet<String> CrazyMenu() {
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
}
