package it.esteco.pos.adapters;

import it.esteco.pos.domain.Display;

public class ConsoleDisplay implements Display {
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
}
