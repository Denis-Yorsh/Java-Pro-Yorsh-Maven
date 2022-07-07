package com.hillel.hwYorsh4.MenuAndPrice;

import com.hillel.hwYorsh4.Check;

public class Water extends Check {

    public Water(int counter) {
        super(counter);
    }

    @Override
    public double priceAll() {
        return Price.getWater();
    }
}
