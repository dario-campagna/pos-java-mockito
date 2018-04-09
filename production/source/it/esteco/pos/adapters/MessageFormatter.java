package it.esteco.pos.adapters;

import it.esteco.pos.domain.Money;

public class MessageFormatter {
    public String format(Money price) {
        return "$" + price.integerPart() + "." + price.fractionalPart();
    }

    public String notFoundMessage(String barcode) {
        return "Product not found for " + barcode;
    }

    public String emptyBarcodeMessage() {
        return "Scanning error: empty barcode";
    }

}
