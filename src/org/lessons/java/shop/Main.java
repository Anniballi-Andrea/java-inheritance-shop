package org.lessons.java.shop;

import java.math.BigDecimal;

import org.lessons.java.shop.classes.Prodotto;

public class Main {
    public static void main(String[] args) {

        Prodotto telefono = new Prodotto("telefono", "apple", new BigDecimal(599.99), new BigDecimal(0.22));

        System.out.println("il codice del prodotto è: " + telefono.getProductCode());

    }

}
