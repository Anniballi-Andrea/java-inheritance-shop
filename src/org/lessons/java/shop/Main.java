package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.lessons.java.shop.classes.Cuffie;
import org.lessons.java.shop.classes.Smartphone;
import org.lessons.java.shop.classes.Televisore;

public class Main {
        public static void main(String[] args) {

                Smartphone telefono = new Smartphone("i-phone", "apple",
                                new BigDecimal(800.00).setScale(2, RoundingMode.CEILING),
                                new BigDecimal(0.22).setScale(2, RoundingMode.HALF_DOWN), 512);
                Televisore tv = new Televisore("Samsung-lcd", "Samsung",
                                new BigDecimal(726.24).setScale(2, RoundingMode.CEILING),
                                new BigDecimal(0.22).setScale(2, RoundingMode.HALF_DOWN), 42,
                                true);
                Cuffie cuffie = new Cuffie("cuffie", "cuffietti",
                                new BigDecimal(76.50).setScale(2, RoundingMode.CEILING),
                                new BigDecimal(0.22).setScale(2, RoundingMode.HALF_DOWN), "nero", false);

                telefono.getInfo();
                System.out.println(" ");
                tv.getInfo();
                System.out.println(" ");
                cuffie.getInfo();
                System.out.println(" ");
                System.out.println(telefono.getPrice(true));

        }

}
