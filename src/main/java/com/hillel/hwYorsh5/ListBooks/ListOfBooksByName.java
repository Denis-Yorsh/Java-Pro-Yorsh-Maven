package com.hillel.hwYorsh5.ListBooks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListOfBooksByName {

    public static void main(String[] args) {
        // New HashMap Book
        Map<String, Book> bookMap = getBookMap();
        System.out.println("Map\n" + bookMap);

        // getting books by author
        Set<Book> bookSet = listBooksByAuthors(bookMap, "Michael Bulgakov");
        System.out.println("Set\n" + bookSet);
    }

    public static Set<Book> listBooksByAuthors(Map<String, Book> bookMap, String name) {
        Set<Book> stringSet = new HashSet<>();
        // getting the keys
        Set<String> stringList = bookMap.keySet();
        // compare the keys with the author's name and add a match to Set<Book>
        for (String list : stringList) {
            if (list.contains(name)) {
                stringSet.add(bookMap.get(list));
            }
        }
        return stringSet;
    }

    // database HashMap Book
    private static Map<String, Book> getBookMap() {
        Map<String, Book> bookMap = new HashMap<>();
        bookMap.put("Ray Bradbury", new RayBradbury
                ("Марсианские хроники", "Вино из одуванчиков", "Все лето в один день"));
        bookMap.put("George Orwell", new GeorgeOrwell
                ("Скотный двор", "Дни в Бирме", "Почему я пишу"));
        bookMap.put("Michael Bulgakov", new MichaelBulgakov
                ("Мастер и Маргарита", "Собачье сердце", "Белая гвардия"));
        bookMap.put("Daniel Keyes", new DanielKeyes
                ("Цветы для Элджернона", "Пяятая Салли", "Войны Миллмгана"));
        bookMap.put("Oscar Wilde", new OscarWilde
                ("Счастливый принц", "Эгоистичный великан", "Соловей и роза"));
        return bookMap;
    }
}
