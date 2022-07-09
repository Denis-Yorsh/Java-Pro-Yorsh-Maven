package com.hillel.hwYorsh5.ListBooks;

import java.util.Objects;

public class Book {

    private String book1;
    private String book2;
    private String book3;

    public Book(String book1, String book2, String book3) {
        this.book1 = book1;
        this.book2 = book2;
        this.book3 = book3;
    }

    public String getBook1() {
        return book1;
    }

    public void setBook1(String book1) {
        this.book1 = book1;
    }

    public String getBook2() {
        return book2;
    }

    public void setBook2(String book2) {
        this.book2 = book2;
    }

    public String getBook3() {
        return book3;
    }

    public void setBook3(String book3) {
        this.book3 = book3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(book1, book.book1) && Objects.equals(book2, book.book2) && Objects.equals(book3, book.book3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book1, book2, book3);
    }

    @Override
    public String toString() {
        return "Book {" +
                "book1 ='" + book1 + '\'' +
                ", book2 ='" + book2 + '\'' +
                ", book3 ='" + book3 + '\'' +
                '}';
    }
}
