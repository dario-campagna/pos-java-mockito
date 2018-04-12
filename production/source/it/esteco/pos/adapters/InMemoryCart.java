package it.esteco.pos.adapters;

import it.esteco.pos.domain.Cart;
import it.esteco.pos.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class InMemoryCart implements Cart {

    private List<Money> prices = new ArrayList<>();

    @Override
    public void add(Money price) {
        prices.add(price);
    }

    @Override
    public Money getTotal() {
        return prices.stream().reduce(new Money(0), (a, b) -> a.plus(b));
    }

    @Override
    public void clear() {
        prices.clear();
    }
}
