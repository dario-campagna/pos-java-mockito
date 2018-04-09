package it.esteco.pos.adapters;

import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.ports.Display;

public class ConsoleDisplay implements Display {
    private MessageFormatter messageFormatter;

    public ConsoleDisplay(MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public void showPrice(Money price) {
        System.out.println(messageFormatter.format(price));
    }

    @Override
    public void showProductNotFoundFor(String barcode) {
        System.out.println(messageFormatter.notFoundMessage(barcode));
    }

    @Override
    public void showEmptyBarcodeError() {
        System.out.println(messageFormatter.emptyBarcodeMessage());
    }
}
