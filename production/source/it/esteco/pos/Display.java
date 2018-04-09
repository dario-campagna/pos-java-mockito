package it.esteco.pos;

public interface Display {
    void showPrice(String priceAsText);

    void showProductNotFoundFor(String s);

    void showEmptyBarcodeError();
}
