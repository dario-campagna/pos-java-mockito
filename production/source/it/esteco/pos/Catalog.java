package it.esteco.pos;

public interface Catalog {
    Money findPrice(String barcode);
}
