package com.hillel.hwYorsh4.MenuAndPrice;

import com.hillel.hwYorsh4.Check;

public class Steak extends Check {

    public Steak(int counter) {
        super(counter);
    }

    @Override
    public double priceAll() {
        return Price.getSteak();
    }
}
