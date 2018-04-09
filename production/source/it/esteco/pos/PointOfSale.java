package it.esteco.pos;

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
        } else {
            String priceAsText = catalog.findPrice(barcode);
            if (priceAsText != null) {
                display.showPrice(priceAsText);
            } else {
                display.showProductNotFoundFor(barcode);
            }
        }
    }
}
