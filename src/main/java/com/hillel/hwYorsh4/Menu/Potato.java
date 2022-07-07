package com.hillel.hwYorsh4.Menu;

import com.hillel.hwYorsh4.Check;
import com.hillel.hwYorsh4.Price;

public class Potato extends Check {

    public Potato(int counter) {
        super(counter);
    }

    @Override
    protected double priceAll() {
        return Price.getPotato();
    }

}
