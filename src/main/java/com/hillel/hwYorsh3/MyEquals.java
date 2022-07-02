package com.hillel.hwYorsh3;

import java.util.Objects;

public class MyEquals {

    private String firstName;
    private String lastName;
    private int age;

    public MyEquals(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) { return false; }
        return myEquals(o, firstName)
                && myEquals(o, lastName)
                && myEquals(o, age) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Equals{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    private boolean myEquals(Object firstObject, Object secondObject) {
        String firstString = String.valueOf(firstObject);
        String secondString = String.valueOf(secondObject);
        return firstString.contains(secondString);
    }
}
