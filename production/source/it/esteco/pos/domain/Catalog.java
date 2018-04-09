package it.esteco.pos.domain;

public interface Catalog {
    Money findPrice(String barcode);
}
