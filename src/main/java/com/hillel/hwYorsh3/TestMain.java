package com.hillel.hwYorsh3;

public class TestMain {

    public static void main(String[] args) {
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
    }
}
