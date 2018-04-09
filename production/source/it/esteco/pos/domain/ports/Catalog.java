package it.esteco.pos.domain.ports;

import it.esteco.pos.domain.Money;

public interface Catalog {
    Money findPrice(String barcode);
}
