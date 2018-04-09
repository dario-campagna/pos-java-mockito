package it.esteco.pos;

import it.esteco.pos.domain.Catalog;
import it.esteco.pos.domain.Display;

import java.util.Scanner;

public class Main implements Display, Catalog {

    private PointOfSale pointOfSale;

    public Main() {
        pointOfSale = new PointOfSale(this, this);
    }

    public static void main() {
        Main main = new Main();
        main.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            pointOfSale.onBarcode(scanner.nextLine());
        }
    }

    @Override
    public void showEmptyBarcodeError() {
        System.out.printf("Scan error: empty barcode!");
    }

    @Override
    public void showPrice(String priceAsText) {
        System.out.println(priceAsText);
    }

    @Override
    public void showProductNotFound(String barcode) {
        System.out.println("Product not found for " + barcode);
    }

    @Override
    public String findPrice(String barcode) {
        if ("123456".equals(barcode)) {
            return "$7.95";
        } else if ("789987".equals(barcode)) {
            return "$11.99";
        } else {
            return null;
        }
    }
}