package it.esteco.pos.domain;

public class PointOfSale {
    private Display display;
    private Catalog catalog;

    public PointOfSale(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.showEmptyBarcodeError();
            return;
        }
        
        Money price = catalog.findPrice(barcode);
        if (price != null) {
            display.showPrice(price);
        } else {
            display.showProductNotFound(barcode);
        }
    }

    public void onTotalRequested() {
        display.showPrice(new Money(0));
    }
}
