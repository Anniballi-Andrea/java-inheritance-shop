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

    public String getColor() {
        return this.color;
    }

    public Boolean getIsWirless() {
        return this.isWirless;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void haveWirles() {
        this.isWirless = true;
    }

    public void noWirles() {
        this.isWirless = false;
    }

    public void getInfo() {
        String wirlessInfo;
        if (this.isWirless) {
            wirlessInfo = "Sono wirless";
        } else {
            wirlessInfo = "Non sono wirless";
        }

        BigDecimal ivaForPrint = this.iva.multiply(BigDecimal.valueOf(100));

        System.out.println("prodotto: " +
                this.codice + "-" + this.name + ", marca: " + this.marca + ", prezzo: " + this.price + " euro, iva: "
                + ivaForPrint + " %, colore: "
                + this.color + ", " + wirlessInfo);
    }
}
