package com.hillel.hwYorsh2;

import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) {

        MyLinkedList<Object> test = new  MyLinkedList<>();
        test.addFirst("Denis");
        test.addLast(9847);

        System.out.println("toArray() - "+ Arrays.toString(test.toArray()));
        System.out.println("isEmpty() - "+test.isEmpty());
    }
}
