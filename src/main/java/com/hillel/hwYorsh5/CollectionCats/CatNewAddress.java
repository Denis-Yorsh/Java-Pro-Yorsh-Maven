package com.hillel.hwYorsh5.CollectionCats;

import java.util.ArrayList;
import java.util.List;

public class CatNewAddress {

    public static void main(String[] args) {
        List<Cat> catList = new ArrayList<>();
        catList.add(new Kisa("Kisa", 2, "New York"));
        catList.add(new MayMay("May May", 1, "London"));
        catList.add(new Myrka("Myrka", 3, "Paris"));

        System.out.println("Old address" + catList);
        List<Cat> newCatList = moving(catList);
        System.out.println("New address = " + newCatList);
    }

    public static List<Cat> moving(List<Cat> catList){
        for (Cat cat : catList) {
            cat.setAddress("Ukraine");
        }
        return catList;
    }
}
