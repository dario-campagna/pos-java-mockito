package it.esteco.pos.adapters;

import it.esteco.pos.domain.Catalog;
import it.esteco.pos.domain.Money;

public class InMemoryCatalog implements Catalog {
    @Override
    public Money findPrice(String barcode) {
        if ("123456".equals(barcode)) {
            return new Money(795);
        } else if ("789987".equals(barcode)) {
            return new Money(1199);
        } else {
            return null;
        }
    }
}
