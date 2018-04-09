package it.esteco.pos;

public interface Display {
    void showPrice(Money price);

    void showProductNotFoundFor(String s);

    void showEmptyBarcodeError();
}
