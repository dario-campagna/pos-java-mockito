package it.esteco.pos.domain;

public class PointOfSale {
    private Display display;
    private Catalog catalog;
    private Money lastPrice = new Money(0);

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
            lastPrice = price;
        } else {
            display.showProductNotFound(barcode);
        }
    }

    public void onTotalRequested() {
        display.showPrice(lastPrice);
    }
}
