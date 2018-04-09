package it.esteco.pos.domain.ports;

import it.esteco.pos.domain.Money;

public interface Display {
    void showPrice(Money price);

    void showProductNotFoundFor(String barcode);

    void showEmptyBarcodeError();
}
