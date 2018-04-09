package it.esteco.pos.domain;

public class Money {

    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            Money that = (Money) obj;
            return this.amount == that.amount;
        }
        return false;
    }

    public String integerPart() {
        return String.valueOf(amount / 100);
    }

    public String fractionalPart() {
        int fractionalPart = amount % 100;
        if (fractionalPart == 0) {
            return "00";
        } else {
            return String.valueOf(fractionalPart);
        }
    }
}
