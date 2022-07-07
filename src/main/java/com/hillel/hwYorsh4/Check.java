package com.hillel.hwYorsh4;

public abstract class Check {

    private int counter;
    private final char DOLLARS = '$';

    public Check(int counter) {
        this.counter = counter;
    }

    public char getDOLLARS() {
        return DOLLARS;
    }

    protected abstract double priceAll();
}
