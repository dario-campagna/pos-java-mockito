package it.esteco.pos.domain.ports;

public interface Catalog {
    String findPrice(String barcode);
}
