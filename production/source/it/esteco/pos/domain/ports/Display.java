package it.esteco.pos.domain.ports;

public interface Display {
    void showPrice(String priceAsText);

    void showProductNotFound(String barcode);

    void showEmptyError();
}
