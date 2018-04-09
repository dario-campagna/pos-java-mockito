package it.esteco.pos.domain;

public interface Cart {
    void add(Money price);

    Money getTotal();
}
