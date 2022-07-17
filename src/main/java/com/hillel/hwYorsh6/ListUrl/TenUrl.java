package com.hillel.hwYorsh6.ListUrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TenUrl {

    public static void main(String[] args) throws FileNotFoundException {

        List<String> fileToList = fileToList();
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
