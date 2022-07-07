package com.hillel.hwYorsh4.MenuAndPrice;

import com.hillel.hwYorsh4.Check;

public class Salad extends Check {

    public Salad(int counter) {
        super(counter);
    }

    @Override
    public double priceAll() {
        return Price.getSalad();
    }
}
