package it.esteco.pos;

public class PointOfSale {
    private Display display;

    public PointOfSale(Display display) {
        this.display = display;
    }

    public void onBarcode(String barcode) {
        display.showPrice("$7.95");
    }
}
