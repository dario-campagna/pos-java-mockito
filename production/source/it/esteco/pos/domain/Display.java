package it.esteco.pos.domain;

public interface Display {
    void showEmptyBarcodeError();

    void showPrice(String priceAsText);

    void showProductNotFound(String barcode);
}
