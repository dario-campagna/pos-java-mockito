package it.esteco.pos.adapters;

import it.esteco.pos.domain.Cart;
import it.esteco.pos.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCart implements Cart {

    private List<Money> prices = new ArrayList<>();

    @Override
    public void add(Money price) {
        prices.add(price);
    }

    @Override
    public Money getTotal() {
        return prices.size() == 0 ? new Money(0) : prices.get(0);
    }
}
