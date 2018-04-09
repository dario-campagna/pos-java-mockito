package it.esteco.pos.domain;

public interface Display {
    void showEmptyBarcodeError();

    void showPrice(String priceAsText);
}
