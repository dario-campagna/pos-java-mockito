package it.esteco.pos.domain;

public class Money {

    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public Money plus(Money that) {
        return new Money(this.amount + that.amount);
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

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            Money that = (Money) obj;
            return this.amount == that.amount;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.amount * 19 + 5;
    }
}
