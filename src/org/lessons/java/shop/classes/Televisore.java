package org.lessons.java.shop.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Televisore extends Prodotto {
    protected int dimensions;
    protected Boolean isSmart;

    public Televisore(String name, String marca, BigDecimal price, BigDecimal iva, int dimensions, Boolean isSmart) {
        super(name, marca, price, iva);
        this.dimensions = dimensions;
        this.isSmart = isSmart;
    }

    public int getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public Boolean getIsSmart() {
        return this.isSmart;
    }

    public void isSmartTv() {
        this.isSmart = true;
    }

    public void notSmartTv() {
        this.isSmart = false;
    }

    public void getInfo() {
        String smartInfo;
        if (this.isSmart) {
            smartInfo = "la tv è smart";
        } else {
            smartInfo = "la tv non è smart";
        }

        BigDecimal ivaForPrint = this.iva.multiply(BigDecimal.valueOf(100));

        System.out.println("prodotto: " +
                this.codice + "-" + this.name + ", marca: " + this.marca + ", prezzo: " + this.price + " euro, iva: "
                + ivaForPrint + " %, dimensioni: "
                + this.dimensions + " pollici, " + smartInfo);
    }

    @Override
    public BigDecimal getPrice(Boolean haveCard) {
        if (haveCard) {
            if (!this.isSmart) {
                return this.price
                        .subtract(this.price.multiply(new BigDecimal(0.10)).setScale(2, RoundingMode.HALF_DOWN));
            }

            return this.price.subtract(this.price.multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_DOWN));
        } else {
            return this.price;
        }

    }

    @Override
    public String toString() {

        return super.toString() + "\nDimensioni Tv : " + getDimensions() + "\nSmart : " + getIsSmart();
        /*
         * String smartInfo;
         * if (this.isSmart) {
         * smartInfo = "la tv è smart";
         * } else {
         * smartInfo = "la tv non è smart";
         * }
         * return String.format(
         * "Prodotto: %d - %s, marca: %s, prezzo: %s euro, dimensioni: %d pollici, %s",
         * this.codice, this.name,
         * this.marca, this.price, this.dimensions, smartInfo);
         */
    }
}
