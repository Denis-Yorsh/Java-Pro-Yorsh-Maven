package com.hillel.hwYorsh4.MenuAndPrice;

import com.hillel.hwYorsh4.Check;

public class Coffee extends Check {

    public Coffee(int counter) {
        super(counter);
    }

    @Override
    public double priceAll() {
        return Price.getCoffee();
    }
}
