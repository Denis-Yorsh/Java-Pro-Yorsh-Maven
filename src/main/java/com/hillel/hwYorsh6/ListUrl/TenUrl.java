package com.hillel.hwYorsh6.ListUrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * public static boolean isMoneyName(String name) {
 *         Pattern pattern = Pattern.compile("[0-9]{2}");
 *         Pattern pattern1 = Pattern.compile("[0-9]{1}");
 *         Matcher matcher = pattern.matcher(name);
 *         Matcher matcher1 = pattern1.matcher(name);
 *         if (matcher.find()) { return false; }
 *         if (matcher1.find()) { return true; }
 *         return false;
 *     }
 *
 */
public class TenUrl {

    public static void main(String[] args) throws FileNotFoundException {

        List<String> fileToListFirst = fileToList();
        //List<String> fileToListSecond = fileToList();
        System.out.println(fileToListFirst.size());
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\.[a-z]{2,4}\\/");

        for (String string : fileToListFirst) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                stringList.add(string);
            }
        }
        System.out.println(stringList.size());
//        for (String s : stringList) {
//            System.out.println(s);
//        }

        Set<String> domain = new HashSet<>();
//        Map<String, Integer> stringIntegerMap = new HashMap<>();
//        int count = 0;
        String[] array;
        String[] arrayTwo;
        for (int i = 0; i < fileToListFirst.size(); i++) {
            array = fileToListFirst.get(i).split("/");
            arrayTwo = array[0].split("\\.");
            domain.add(arrayTwo[arrayTwo.length-1]);
             }
//        for (String doman : domain) {
//            System.out.println(doman);
//        }
        System.out.println(domain.size());

    }

    private static List<String> fileToList() throws FileNotFoundException {
        File myFirstFile = new File("./Files/ReadFiles/urls.txt");
        List<String> stringList = new ArrayList<>();
        Scanner scannerFile = new Scanner(myFirstFile);
        while (scannerFile.hasNextLine()) {
            stringList.add(scannerFile.nextLine());
        }
        scannerFile.close();
        return stringList;
    }
}
