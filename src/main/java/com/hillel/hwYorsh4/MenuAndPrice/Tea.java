package com.hillel.hwYorsh4.MenuAndPrice;

import com.hillel.hwYorsh4.Check;

public class Tea extends Check {

    public Tea(int counter) {
        super(counter);
    }

    @Override
    public double priceAll() {
        return Price.getTea();
    }
}
