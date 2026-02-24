package org.lessons.java.shop.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    @Override
    public BigDecimal getPrice(Boolean haveCard) {
        if (haveCard) {
            if (!this.isWirless) {
                return this.price
                        .subtract(this.price.multiply(new BigDecimal(0.07)).setScale(2, RoundingMode.HALF_DOWN));
            }

            return this.price.subtract(this.price.multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_DOWN));
        } else {
            return this.price;
        }

    }

    @Override
    public String toString() {

        return super.toString() + "\nColore : " + getColor() + "\nWirless : " + getIsWirless();
        /*
         * String wirlessInfo;
         * if (this.isWirless) {
         * wirlessInfo = "sono wirless";
         * } else {
         * wirlessInfo = "non sono wirless";
         * }
         * return String.format(
         * "Prodotto: %d - %s, marca: %s, colore: %s, prezzo: %s euro, %s",
         * this.codice, this.name,
         * this.marca, this.color, this.price, wirlessInfo);
         */
    }
}
