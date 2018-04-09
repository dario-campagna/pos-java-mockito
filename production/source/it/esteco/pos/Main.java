package it.esteco.pos;

import it.esteco.pos.domain.PointOfSale;

import java.util.Scanner;

public class Main {

    private PointOfSale pointOfSale;

    public Main() {
        pointOfSale = new PointOfSale();
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
}
