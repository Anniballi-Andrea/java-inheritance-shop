package org.lessons.java.shop.classes;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {

    protected long imei; // codice da 15 cifre
    protected int memory;

    public Smartphone(String name, String marca, BigDecimal price, BigDecimal iva, int imei, int memory) {
        super(name, marca, price, iva);
        this.imei = imei;
        this.memory = memory;
    }

}
