package com.hillel.hwYorsh5.ListBooks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ListOfBooksByName {

    public static void main(String[] args) {
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
    }

    public Set<Book> listBooksByAuthors (Map<String, Book> bookMap, String name){
        return null;
    }
}
