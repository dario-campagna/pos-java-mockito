package it.esteco.pos.adapters;

import it.esteco.pos.domain.Catalog;

public class InMemoryCatalog implements Catalog {
    @Override
    public String findPrice(String barcode) {
        if ("123456".equals(barcode)) {
            return "$7.95";
        } else if ("789987".equals(barcode)) {
            return "$11.99";
        } else {
            return null;
        }
    }
}
