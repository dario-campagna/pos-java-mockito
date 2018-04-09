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
            display.showPrice("$7.95");
        }
    }
}
