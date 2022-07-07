package com.hillel.hwYorsh4.Menu;

import com.hillel.hwYorsh4.Check;
import com.hillel.hwYorsh4.Price;

public class Salad extends Check {

    public Salad(int counter) {
        super(counter);
    }

    @Override
    protected double priceAll() {
        return Price.getSalad();
    }
}
