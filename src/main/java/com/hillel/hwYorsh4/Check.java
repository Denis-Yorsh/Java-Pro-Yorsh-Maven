package com.hillel.hwYorsh4;

public abstract class Check {

    private final char DOLLARS = '$';

    public char getDOLLARS() {
        return DOLLARS;
    }

    protected abstract double priceAll();
}
