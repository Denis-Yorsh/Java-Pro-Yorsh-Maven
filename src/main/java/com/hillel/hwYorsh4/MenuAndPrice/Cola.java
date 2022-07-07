package com.hillel.hwYorsh4.MenuAndPrice;

import com.hillel.hwYorsh4.Check;

public class Cola extends Check {

    public Cola(int counter) {
        super(counter);
    }

    @Override
    public double priceAll() {
        return Price.getCola();
    }
}
