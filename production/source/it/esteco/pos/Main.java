package it.esteco.pos;

import it.esteco.pos.adapters.ConsoleDisplay;
import it.esteco.pos.domain.Catalog;

import java.util.Scanner;

public class Main implements Catalog {

    private PointOfSale pointOfSale;

    public Main() {
        pointOfSale = new PointOfSale(new ConsoleDisplay(), this);
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