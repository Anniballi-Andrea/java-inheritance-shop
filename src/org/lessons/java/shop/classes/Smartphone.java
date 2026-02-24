package org.lessons.java.shop.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Smartphone extends Prodotto {

    protected long imei; // codice da 15 cifre
    protected int memory;

    public Smartphone(String name, String marca, BigDecimal price, BigDecimal iva, int memory) {
        super(name, marca, price, iva);
        Random rand = new Random();
        this.imei = rand.nextLong(100000000000000L, 1000000000000000L);
        this.memory = memory;
    }

    public long getImei() {
        return this.imei;
    }

    public int getMemory() {
        return this.memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void getInfo() {

        BigDecimal ivaForPrint = this.iva.multiply(BigDecimal.valueOf(100));

        System.out.println("prodotto: " +
                this.codice + "-" + this.name + ", marca: " + this.marca + ", prezzo: " + this.price + " euro, iva: "
                + ivaForPrint + " %, codice imei: "
                + this.imei + ", memoria: " + this.memory + " GB");
    }

    @Override
    public BigDecimal getPrice(Boolean haveCard) {
        if (haveCard) {
            if (this.memory <= 32) {
                return this.price
                        .subtract(this.price.multiply(new BigDecimal(0.05)).setScale(2, RoundingMode.HALF_DOWN));
            }

            return this.price.subtract(this.price.multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_DOWN));
        } else {
            return this.price;
        }

    }

    @Override
    public String toString() {
        return String.format(
                "Prodotto: %d - %s, marca: %s, prezzo: %s euro, memoria: %d GB",
                this.codice, this.name,
                this.marca, this.price, this.memory);
    }
}
