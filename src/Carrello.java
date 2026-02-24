import java.math.BigDecimal;
import java.util.Scanner;

import org.lessons.java.shop.classes.Cuffie;
import org.lessons.java.shop.classes.Prodotto;
import org.lessons.java.shop.classes.Smartphone;
import org.lessons.java.shop.classes.Televisore;

public class Carrello {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("hai una carta fedelta? (inserisci TRUE o FALSE)");
        Boolean haveCard = Boolean.parseBoolean(input.nextLine());

        System.out.println("Quanti prodotti vuoi aggiungere al carrello?");

        int numberProduct = Integer.parseInt(input.nextLine());

        Prodotto[] products = new Prodotto[numberProduct];

        for (int i = 0; i < products.length; i++) {

            System.out.println("Nome del prodotto : ");

            String productsName = input.nextLine();

            System.out.println("Marca del prodotto : ");

            String productBrand = input.nextLine();

            System.out.println("Prezzo (senza iva) : ");

            String prezzoInput = input.nextLine().replace(",", ".");

            BigDecimal productPrice = new BigDecimal(prezzoInput);

            System.out.println("A quale categria appartiene? tv, smartphone, cuffie");

            String productCategoryString = input.nextLine();

            switch (productCategoryString.toLowerCase()) {
                case "tv":
                    System.out.println("Dimensioni della TV in pollici : ");

                    int tvSize = Integer.parseInt(input.nextLine());

                    System.out.println("Smart TV? (inserisci TRUE o FALSE)");

                    Boolean isSmartTv = Boolean.parseBoolean(input.nextLine());

                    Televisore tv = new Televisore(productsName, productBrand, productPrice,
                            new BigDecimal(0.22), tvSize, isSmartTv);

                    products[i] = tv;

                    break;

                case "smartphone":

                    System.out.println("Gigabyte di memoria : ");

                    int giga = Integer.parseInt(input.nextLine());

                    Smartphone phone = new Smartphone(productsName, productBrand, productPrice,
                            new BigDecimal(0.22), giga);

                    products[i] = phone;

                    break;

                case "cuffie":

                    System.out.println("Colore delle cuffie : ");

                    String cuffieColor = input.nextLine();

                    System.out.println("sono wirless? (inserisci TRUE o FALSE)");

                    Boolean isWirless = Boolean.parseBoolean(input.nextLine());

                    Cuffie cuffie = new Cuffie(productsName, productBrand, productPrice,
                            new BigDecimal(0.22), cuffieColor, isWirless);

                    products[i] = cuffie;

                    break;
            }
            System.out.println("------------------");
        }
        input.close();

        System.out.println("Ecco il tuo carrello: ");

        BigDecimal totalPrice = BigDecimal.ZERO;

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);

            totalPrice = totalPrice.add(products[i].getPrice(haveCard));
            System.out.println("------------------");
        }
        System.out.println("Il prezzo totale è: " + totalPrice);

        /*
         * Scanner input = new Scanner(System.in);
         * System.out.println("hai una tessera fedeltà?");
         * String haveCard = input.nextLine();
         * Boolean cardState = false;
         * if (haveCard.toLowerCase().equals("si")) {
         * cardState = true;
         * }
         * 
         * System.out.
         * println("Stai aggiungendo uno smartphone, un televisore o delle cuffie?");
         * String typeOfProduct = input.nextLine();
         * 
         * if (typeOfProduct.toLowerCase().equals("televisore")) {
         * System.out.println("come si chiama?");
         * String name = input.nextLine();
         * System.out.println("che marca è?");
         * String marca = input.nextLine();
         * System.out.println("è una smartTv?");
         * String isSmart = input.nextLine();
         * System.out.println("quanto costa?");
         * BigDecimal price = input.nextBigDecimal();
         * System.out.println("inserisci l'iva per questo tipo di prodotto");
         * BigDecimal iva = input.nextBigDecimal().setScale(2);
         * System.out.println("da quanti pollici è?");
         * int dimensions = input.nextInt();
         * 
         * Boolean smartState;
         * if (isSmart.toLowerCase().equals("si")) {
         * smartState = true;
         * } else {
         * smartState = false;
         * }
         * Televisore tv = new Televisore(name, marca, price, iva, dimensions,
         * smartState);
         * System.out.println(tv.toString());
         * if (cardState) {
         * System.out.println(
         * "con la carta fedeltà hai diritto ad uno sconto, prezzo finale: " +
         * tv.getPrice(cardState)
         * + " euro");
         * } else {
         * System.out.println(
         * "il prezzo del prodotto è: " + tv.getPrice(cardState) + " euro");
         * }
         * 
         * } else if (typeOfProduct.toLowerCase().equals("smartphone")) {
         * System.out.println("come si chiama?");
         * String name = input.nextLine();
         * System.out.println("che marca è?");
         * String marca = input.nextLine();
         * System.out.println("quanta memoria ha?");
         * int memory = input.nextInt();
         * System.out.println("quanto costa?");
         * BigDecimal price = input.nextBigDecimal();
         * System.out.println("inserisci l'iva per questo tipo di prodotto");
         * BigDecimal iva = input.nextBigDecimal().setScale(2);
         * 
         * Smartphone tel = new Smartphone(name, marca, price, iva, memory);
         * System.out.println(tel.toString());
         * if (cardState) {
         * System.out.println(
         * "con la carta fedeltà hai diritto ad uno sconto, prezzo finale: " +
         * tel.getPrice(cardState)
         * + " euro");
         * } else {
         * System.out.println(
         * "il prezzo del prodotto è: " + tel.getPrice(cardState) + " euro");
         * }
         * 
         * } else if (typeOfProduct.toLowerCase().equals("cuffie")) {
         * System.out.println("sono Cuffie");
         * System.out.println("come si chiama?");
         * String name = input.nextLine();
         * System.out.println("che marca è?");
         * String marca = input.nextLine();
         * System.out.println("di che colore sono?");
         * String color = input.nextLine();
         * System.out.println("sono wirless");
         * String iswirless = input.nextLine();
         * System.out.println("quanto costa?");
         * BigDecimal price = input.nextBigDecimal();
         * System.out.println("inserisci l'iva per questo tipo di prodotto");
         * BigDecimal iva = input.nextBigDecimal().setScale(2);
         * 
         * Boolean wirlessState;
         * if (iswirless.toLowerCase().equals("si")) {
         * wirlessState = true;
         * } else {
         * wirlessState = false;
         * }
         * 
         * Cuffie cuffie = new Cuffie(name, marca, price, iva, color, wirlessState);
         * System.out.println(cuffie.toString());
         * if (cardState) {
         * System.out.println(
         * "con la carta fedeltà hai diritto ad uno sconto, prezzo finale: " +
         * cuffie.getPrice(cardState)
         * + " euro");
         * } else {
         * System.out.println(
         * "il prezzo del prodotto è: " + cuffie.getPrice(cardState) + " euro");
         * }
         * } else {
         * System.out.println("il prodotto non è stato trovato");
         * }
         * 
         * input.close();
         */
    }
}
