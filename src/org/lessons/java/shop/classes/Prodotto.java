package org.lessons.java.shop.classes;

import java.math.BigDecimal;
import java.util.Random;

public class Prodotto {

    protected int codice;
    protected String name;
    protected String marca;
    protected BigDecimal price;
    protected BigDecimal iva;

    public Prodotto(String name, String marca, BigDecimal price, BigDecimal iva) {

        Random rand = new Random();

        this.codice = rand.nextInt(99999);
        this.name = name;
        this.marca = marca;
        this.price = price;
        this.iva = iva;

    }

    public Prodotto() {
        Random rand = new Random();

        this.codice = rand.nextInt(99999);
    }

    public int getProductCode() {
        return this.codice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) >= 0) {
            this.price = price;
        } else {
            System.out.println("il prezzo non può essere inferiore a 0");
        }

    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setIva(BigDecimal iva) {
        if (iva.compareTo(BigDecimal.ZERO) > 0 && iva.compareTo(BigDecimal.ONE) < 0) {
            this.iva = iva;
        } else {
            System.out.println("inserisci l'iva nel formato 0,iva");
        }
    }

    @Override
    public String toString() {
        return String.format("Prodotto: ''%d'' - ''%s'', marca: ''%d'', prezzo: ''%f''", this.codice, this.name,
                this.marca, this.price);
    }
}
