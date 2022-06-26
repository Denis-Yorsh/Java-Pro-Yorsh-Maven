package com.hillel.hwYorsh1;

public class TestClass {

    public static void main(String[] args) {

        MyArrayList<Integer> test = new MyArrayList<>();
        test.add(91345);
        test.add(3445);
        test.add(2);
        test.add(123);
        test.add(34);
        test.add(2);

        System.out.println(test);
        System.out.println();

        test.set(0, -23);
        test.remove(1);
        test.add(2, 987654321);

        System.out.println(test);
        System.out.println();

        System.out.println("isEmpty: " + test.isEmpty());
        System.out.println("get: "+ test.get(0));
        System.out.println("size: "+ test.size());
        System.out.println("contains: "+ test.contains(2));
        System.out.println("indexOf: "+ test.indexOf(2));
        System.out.println("lastIndexOf: "+ test.lastIndexOf(2));

        System.out.println();
        System.out.println(test);

        test.clear();
        System.out.println(test);

    }
}
