package com.hillel.hwYorsh3;

import java.util.Objects;

public class HashCode {

    String firstName;
    String lastName;
    int age;

    public HashCode(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCode hashCode = (HashCode) o;
        return age == hashCode.age && Objects.equals(firstName, hashCode.firstName) && Objects.equals(lastName, hashCode.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "HashCode{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
