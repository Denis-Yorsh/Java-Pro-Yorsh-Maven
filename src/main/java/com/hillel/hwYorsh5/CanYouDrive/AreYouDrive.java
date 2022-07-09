package com.hillel.hwYorsh5.CanYouDrive;

import java.util.ArrayList;
import java.util.List;

public class AreYouDrive {

    public static void main(String[] args) {
        // New People List
        List<People> peopleList = getPeopleList();
        isWhoisDrive(peopleList);
    }

    public static void isWhoisDrive(List<People> list) {
        // New Lists
        List<People> isYesDriveCar = new ArrayList<>();
        List<People> isNoDriveCar = new ArrayList<>();
        // use the method yesOrNo for condition check
        yesOrNo(list, isYesDriveCar, isNoDriveCar);
        // result
        System.out.println("You can drive a car\n" + isYesDriveCar);
        System.out.println("You don't not drive a car\n" + isNoDriveCar);
    }
        // condition check
    private static void yesOrNo(List<People> list, List<People> isYesDriveCar, List<People> isNoDriveCar) {
        boolean isYes;
        for (People people : list) {
            isYes = people.isDriverLicense() && people.isPassport() && people.getNoPenalty() > 365;
            if (isYes) {
                isYesDriveCar.add(people);
            } else {
                isNoDriveCar.add(people);
            }
        }
    }

    // databasePeople
    private static List<People> getPeopleList() {
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new Dima(true, true, 275));
        peopleList.add(new Ivan(false, true, 365));
        peopleList.add(new Lara(true, true, 370));
        peopleList.add(new Masha(true, true, 165));
        peopleList.add(new Petay(true, false, 397));
        peopleList.add(new Sasha(true, true, 1275));
        peopleList.add(new Sveta(true, true, 653));
        return peopleList;
    }
}
