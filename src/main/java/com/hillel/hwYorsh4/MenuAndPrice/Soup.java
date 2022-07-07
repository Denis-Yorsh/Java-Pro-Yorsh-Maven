package com.hillel.hwYorsh4.MenuAndPrice;

import com.hillel.hwYorsh4.Check;

public class Soup extends Check {

    public Soup(int counter) {
        super(counter);
    }

    @Override
    public double priceAll() {
        return Price.getSoup();
    }
}
