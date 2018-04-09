package it.esteco.pos.domain.port;

import it.esteco.pos.domain.Money;

public interface Display {
    void showPrice(Money price);

    void showProductNotFoundFor(String s);

    void showEmptyBarcodeError();
}
