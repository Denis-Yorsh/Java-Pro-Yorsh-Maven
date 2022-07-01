package com.hillel.hwYorsh2;

import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) {

        MyLinkedList<Object> test = new MyLinkedList<>();
        test.addFirst("Denis");
        test.addLast(9847);
        test.set(1, -101);
        System.out.println("toArray - " + Arrays.toString(test.toArray()));

        test.offerFirst("My");
        test.offerLast(4937);
        test.push("Maria");
        System.out.println("toArray - " + Arrays.toString(test.toArray()));

        test.removeFirst();
        test.removeLast();
        test.remove(2);
        System.out.println("toArray - " + Arrays.toString(test.toArray()));

        test.add(2435);
        test.add(0, "Take");
        System.out.println("toArray - " + Arrays.toString(test.toArray()));

        System.out.println("getFirst - " + test.getFirst());
        System.out.println("getLast - " + test.getLast());
        System.out.println("get(1) - " + test.get(1));
        System.out.println("element - " + test.element());

        test.pollFirst();
        test.pollLast();
        System.out.println("toArray - " + Arrays.toString(test.toArray()));

        System.out.println("peekFirst - " + test.peekFirst());
        System.out.println("peekLast - " + test.peekLast());
        System.out.println("peek - " + test.peek());

        test.addFirst("Sveta");
        test.addLast(9);
        test.addFirst("Roma");
        test.addLast(98);
        test.addFirst("Sasha");
        test.addLast(-2);
        System.out.println("toArray - " + Arrays.toString(test.toArray()));

        test.remove();
        test.remove("Roma");
        System.out.println("toArray - " + Arrays.toString(test.toArray()));

        test.removeFirst();
        test.removeLast();
        System.out.println("toArray - " + Arrays.toString(test.toArray()));

        System.out.println("size - " + test.size());
        System.out.println("isEmpty - " + test.isEmpty());
        System.out.println("contains - " + test.contains("Denis"));
        System.out.println("indexOf - " + test.indexOf("Denis"));
        System.out.println("lastIndexOf - " + test.lastIndexOf(98));

        test.clear();
        System.out.println("toArray - " + Arrays.toString(test.toArray()));
    }
}
