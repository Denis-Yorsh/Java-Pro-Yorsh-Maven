package com.hillel.hwYorsh4;

public abstract class Check {

    private int counter;
    private final char DOLLARS = '$';

    public Check(int counter) {
        this.counter = counter;
    }

    protected abstract double priceAll();

    @Override
    public String toString() {
        return "Check {" +
                "counter=" + counter +
                ", DOLLARS=" + DOLLARS +
                '}';
    }
}
