package it.esteco.pos.domain;

public interface Display {
    void showEmptyBarcodeError();

    void showProductNotFound(String barcode);

    void showPrice(Money price);
}
