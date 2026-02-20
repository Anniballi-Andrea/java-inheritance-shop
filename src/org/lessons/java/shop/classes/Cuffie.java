package org.lessons.java.shop.classes;

import java.math.BigDecimal;

public class Cuffie extends Prodotto {
    protected String color;
    protected Boolean isWirless;

    public Cuffie(String name, String marca, BigDecimal price, BigDecimal iva, String color, Boolean isWirless) {
        super(name, marca, price, iva);
        this.color = color;
        this.isWirless = isWirless;
    }

}
