package it.esteco.pos.domain;

public class PointOfSale {
    private Display display;
    private Catalog catalog;
    private Cart cart;
    private Money lastPrice = new Money(0);

    public PointOfSale(Display display, Catalog catalog, Cart cart) {
        this.display = display;
        this.catalog = catalog;
        this.cart = cart;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.showEmptyBarcodeError();
            return;
        }
        
        Money price = catalog.findPrice(barcode);
        if (price != null) {
            display.showPrice(price);
            cart.add(price);
        } else {
            display.showProductNotFound(barcode);
        }
    }

    public void onTotalRequested() {
        display.showPrice(cart.getTotal());
        cart.clear();
    }
}
