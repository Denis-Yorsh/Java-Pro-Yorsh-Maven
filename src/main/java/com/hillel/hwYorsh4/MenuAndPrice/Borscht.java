package com.hillel.hwYorsh4.MenuAndPrice;

import com.hillel.hwYorsh4.Check;

public class Borscht extends Check {

    @Override
    public double priceAll() {
        return Price.getBorscht();
    }
}
