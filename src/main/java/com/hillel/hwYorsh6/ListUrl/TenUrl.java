package com.hillel.hwYorsh6.ListUrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TenUrl {

    public static void main(String[] args) throws FileNotFoundException {
        // converting the resulting file to ArrayList
        List<String> fileToListFirst = new ArrayList<>(fileToList());
        // separating the URL from the putty
        List<String> emptySorting = new ArrayList<>(emptySorting(fileToListFirst));
        // getting a domain name
        List<String> getDomainName = new ArrayList<>(getDomainName(emptySorting));
        // String - domain name, Integer - count
        Map<String, Integer> domainEqualsFileList = new HashMap<>
                (domainEqualsFileList(getDomainName, emptySorting));
        // Sorting Map and transform to ArrayList
        Map<String, Integer> sortingMapToValue = new LinkedHashMap<>(sortingMapToValue(domainEqualsFileList));
        // console output
        toPrint(sortingMapToValue);
    }

    private static List<String> fileToList() {
        File myFirstFile = new File("./Files/ReadFiles/urls.txt");
        List<String> stringList = new ArrayList<>();
        Scanner scannerFile;
        try {
            scannerFile = new Scanner(myFirstFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scannerFile.hasNextLine()) {
            stringList.add(scannerFile.nextLine());
        }
        scannerFile.close();
        return stringList;
    }

    private static List<String> emptySorting(List<String> fileToListFirst) {
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\/");

        for (String string : fileToListFirst) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                stringList.add(string);
            }
        }

        return stringList;
    }

    private static List<String> getDomainName(List<String> stringList) {
        Set<String> domain = new HashSet<>();
        String[] array;
        String[] arrayTwo;

        for (int i = 0; i < stringList.size(); i++) {
            array = stringList.get(i).split("/");
            arrayTwo = array[0].split("\\.");
            domain.add(arrayTwo[arrayTwo.length - 1]);
        }
        List<String> listDomain = new ArrayList<>(setToDomainList(domain));

        return listDomain;
    }

    private static List<String> setToDomainList(Set<String> domain) {
        String stringAppend = "";
        List<String> list = new ArrayList<>(domain);
        List<String> listDomain = new ArrayList<>(350);

        for (int i = 0; i < list.size(); i++) {
            stringAppend = "." + list.get(i) + "/";
            listDomain.add(stringAppend);
        }

        return listDomain;
    }

    private static Map<String, Integer> domainEqualsFileList(List<String> listDomain, List<String> fileToListFirst) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();

        int count = 0;
        for (int i = 0; i < listDomain.size(); i++) {
            for (int j = 0; j < fileToListFirst.size(); j++) {
                if (fileToListFirst.get(j).contains(listDomain.get(i))) {
                    count++;
                }
                stringIntegerMap.put(listDomain.get(i), count);
            }
            count = 0;
        }

        return stringIntegerMap;
    }

    private static <K, V> Map<String, Integer> sortingMapToValue(Map<K, V> stringIntegerMap) {
        List<Map.Entry<K, V>> sortingList = new LinkedList<>(stringIntegerMap.entrySet());
        Collections.sort(sortingList, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (int) o2.getValue() - (int) o1.getValue();
            }
        });
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : sortingList) {
            result.put((String) entry.getKey(), (Integer) entry.getValue());
        }

        return result;
    }

    private static void toPrint(Map<String, Integer> sortingMapToValue) {
        List<String> stringList = new ArrayList<>(sortingMapToValue.keySet());
        List<Integer> integerList = new ArrayList<>(sortingMapToValue.values());
        int counts = 0;
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i) + " = " + integerList.get(i));
            counts++;
            if (counts == 10) {
                break;
            }
        }
    }
}
