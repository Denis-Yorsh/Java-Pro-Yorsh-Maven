package com.hillel.hwYorsh3;

import java.util.Objects;

public class MyHashCode {

    private String firstName;
    private String lastName;
    private int age;

    public MyHashCode(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyHashCode hashCode = (MyHashCode) o;
        return age == hashCode.age
                && Objects.equals(firstName, hashCode.firstName)
                && Objects.equals(lastName, hashCode.lastName);
    }

    @Override
    public int hashCode() {
        return hashCodeNumber(firstName) + hashCodeNumber(lastName) + hashCodeNumber(age);
    }

    @Override
    public String toString() {
        return "HashCode{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    private static int hashCodeNumber(Object object) {
        int hashCode = 0;
        String stringObject = String.valueOf(object);
        char[] chars = stringObject.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hashCode += chars[i] * 2;
        }
        return hashCode;
    }
}
