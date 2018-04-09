package it.esteco.pos;

public class PointOfSale {
    private Display display;

    public PointOfSale(Display display) {
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("123456".equals(barcode)) {
            display.showPrice("$7.95");
        } else {
            display.showPrice("$11.99");
        }
    }
}
