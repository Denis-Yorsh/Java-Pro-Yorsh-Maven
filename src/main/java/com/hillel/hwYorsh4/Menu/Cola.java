package com.hillel.hwYorsh4.Menu;

import com.hillel.hwYorsh4.Check;
import com.hillel.hwYorsh4.Price;

public class Cola extends Check {

    public Cola(int counter) {
        super(counter);
    }

    @Override
    protected double priceAll() {
        return Price.getCola();
    }
}
