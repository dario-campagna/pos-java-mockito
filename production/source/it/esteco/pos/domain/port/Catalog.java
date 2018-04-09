package it.esteco.pos.domain.port;

import it.esteco.pos.domain.Money;

public interface Catalog {
    Money findPrice(String barcode);
}
