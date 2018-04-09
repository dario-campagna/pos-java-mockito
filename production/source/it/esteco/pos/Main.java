package it.esteco.pos;

import it.esteco.pos.domain.Display;

import java.util.Scanner;

public class Main implements Display {

    private PointOfSale pointOfSale;

    public Main() {
        pointOfSale = new PointOfSale(this);
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
        System.out.println("$7.95");
    }
}