package it.esteco.pos;

import it.esteco.pos.adapters.ConsoleDisplay;
import it.esteco.pos.adapters.InMemoryCart;
import it.esteco.pos.adapters.InMemoryCatalog;
import it.esteco.pos.domain.PointOfSale;

import java.util.Scanner;

public class Main {

    private PointOfSale pointOfSale;

    public Main() {
        pointOfSale = new PointOfSale(new ConsoleDisplay(), new InMemoryCatalog(), new InMemoryCart());
    }

    public static void main() {
        Main main = new Main();
        main.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if ("TOTAL".equals(input)) {
                pointOfSale.onTotalRequested();
            } else {
                pointOfSale.onBarcode(input);
            }
        }
    }

}