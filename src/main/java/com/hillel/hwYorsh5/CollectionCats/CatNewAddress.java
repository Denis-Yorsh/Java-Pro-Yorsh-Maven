package com.hillel.hwYorsh5.CollectionCats;

import java.util.ArrayList;
import java.util.List;

public class CatNewAddress {

    public static void main(String[] args) {
        // New Cat List
        List<Cat> catList = getCats();
        System.out.println("Old address" + catList);

        // Cat List pass to function moving
        List<Cat> newCatList = moving(catList);
        System.out.println("New address = " + newCatList);
    }

    // We change the address
    public static List<Cat> moving(List<Cat> catList){
        // loop through on catList calling a method setAddress
        // and change the address
        for (Cat cat : catList) {
            cat.setAddress("Ukraine");
        }
        return catList;
    }

    // database Cat
    private static List<Cat> getCats() {
        List<Cat> catList = new ArrayList<>();
        catList.add(new Kisa("Kisa", 2, "New York"));
        catList.add(new MayMay("May May", 1, "London"));
        catList.add(new Myrka("Myrka", 3, "Paris"));
        return catList;
    }
}
