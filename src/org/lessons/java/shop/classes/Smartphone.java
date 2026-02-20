package org.lessons.java.shop.classes;

import java.math.BigDecimal;
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
}
