package it.esteco.pos;

import it.esteco.pos.domain.Display;

public class PointOfSale {

    private Display display;

    public PointOfSale(Display display) {
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.showEmptyBarcodeError();
        } else {
            if ("123456".equals(barcode)) {
                display.showPrice("$7.95");
            } else if ("789987".equals(barcode)) {
                display.showPrice("$11.99");
            } else {
                display.showProductNotFound(barcode);
            }
        }
    }
}
