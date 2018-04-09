package it.esteco.pos.adapters;

import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.ports.Catalog;

import java.util.Map;

public class InMemoryCatalog implements Catalog {
    private Map<String, Money> priceByBarcode;

    public InMemoryCatalog(Map<String, Money> priceByBarcode) {
        this.priceByBarcode = priceByBarcode;
    }

    @Override
    public Money findPrice(String barcode) {
        return priceByBarcode.get(barcode);
    }
}
