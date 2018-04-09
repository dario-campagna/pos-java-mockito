package it.esteco.pos.adapters;

import it.esteco.pos.domain.Display;
import it.esteco.pos.domain.Money;

public class ConsoleDisplay implements Display {
    @Override
    public void showEmptyBarcodeError() {
        System.out.printf("Scan error: empty barcode!");
    }

    @Override
    public void showProductNotFound(String barcode) {
        System.out.println("Product not found for " + barcode);
    }

    @Override
    public void showPrice(Money price) {
        System.out.println("$" + price.integerPart() + "." + price.fractionalPart());
    }
}
