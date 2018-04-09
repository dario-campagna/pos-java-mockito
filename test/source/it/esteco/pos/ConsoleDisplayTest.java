package it.esteco.pos;

import it.esteco.pos.adapters.ConsoleDisplay;
import it.esteco.pos.adapters.MessageFormatter;
import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.ports.Display;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ConsoleDisplayTest {

    private ByteArrayOutputStream outputStream;
    private Display display;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        display = new ConsoleDisplay(new MessageFormatter());
    }

    @Test
    public void showEmptyBarcodeError() {
        display.showEmptyBarcodeError();

        assertThat(scanner().nextLine(), is(equalTo("Scanning error: empty barcode")));
    }

    @Test
    public void showProductNotFoundFor() {
        display.showProductNotFoundFor("999999");

        assertThat(scanner().nextLine(), is(equalTo("Product not found for 999999")));
    }

    @Test
    public void showPrice() {
        display.showPrice(new Money(1199));
        assertThat(scanner().nextLine(), is(equalTo("$11.99")));
    }

    private Scanner scanner() {
        return new Scanner(new BufferedInputStream(new ByteArrayInputStream(outputStream.toByteArray())));
    }
}
