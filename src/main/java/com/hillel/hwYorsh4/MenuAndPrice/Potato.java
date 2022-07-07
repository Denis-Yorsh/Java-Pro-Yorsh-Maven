package com.hillel.hwYorsh4.MenuAndPrice;

import com.hillel.hwYorsh4.Check;

public class Potato extends Check {

    public Potato(int counter) {
        super(counter);
    }

    @Override
    public double priceAll() {
        return Price.getPotato();
    }

}
