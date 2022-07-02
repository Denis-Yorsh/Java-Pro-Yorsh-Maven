package com.hillel.hwYorsh3;

public class TestMain {

    public static void main(String[] args) {
        System.out.println("\nMyHashCode test\n");
        MyHashCode humanOne = new MyHashCode("Denis", "Yorsh", 39);
        MyHashCode humanTwo = new MyHashCode("Ivan", "Petrov", 45);
        MyHashCode humanThee = new MyHashCode("Svetlana", "Sidorova", 25);
        MyHashCode humanFour = new MyHashCode("Denis", "Yorsh", 39);

        System.out.println("humanOne.hashCode() - " + humanOne.hashCode());
        System.out.println("humanTwo.hashCode() - " + humanTwo.hashCode());
        System.out.println("humanThee.hashCode() - " + humanThee.hashCode());
        System.out.println("humanFour.hashCode() - " + humanFour.hashCode());
        System.out.println("humanOne.equals(humanFour) - " + humanOne.equals(humanFour));
        System.out.println("humanOne.equals(humanTwo) - " + humanOne.equals(humanTwo));

        System.out.println("\nMyEquals test\n");
        MyEquals humanFive = new MyEquals("Denis", "Yorsh", 39);
        MyEquals humanSix = new MyEquals("Ivan", "Petrov", 45);
        MyEquals humanSeven = new MyEquals("Svetlana", "Sidorova", 25);
        MyEquals humanEight = new MyEquals("Denis", "Yorsh", 39);

        System.out.println("humanFive.hashCode() - " + humanFive.hashCode());
        System.out.println("humanSix.hashCode() - " + humanSix.hashCode());
        System.out.println("humanSeven.hashCode() - " + humanSeven.hashCode());
        System.out.println("humanEight.hashCode() - " + humanEight.hashCode());
        System.out.println("humanFive.equals(humanEight) - " + humanFive.equals(humanEight));
        System.out.println("humanFive.equals(humanEight) - " + humanFive.equals(humanSix));
    }
}
