package it.esteco.pos;

import it.esteco.pos.adapters.ConsoleDisplay;
import it.esteco.pos.adapters.InMemoryCatalog;
import it.esteco.pos.adapters.MessageFormatter;
import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.PointOfSale;
import it.esteco.pos.domain.ports.Catalog;
import it.esteco.pos.domain.ports.Display;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointOfSaleServiceTest {

    private ByteArrayOutputStream outputStream;
    private Display display;
    private PointOfSale pointOfSale;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        display = new ConsoleDisplay(new MessageFormatter());
        Catalog catalog = new InMemoryCatalog(new HashMap<String, Money>(){{
            put("123345", new Money(34490));
        }});
        pointOfSale = new PointOfSale(display, catalog);
    }

    @Test
    public void productFound() {
        pointOfSale.onBarcode("123345");
        assertThat(scanner().nextLine(), is(equalTo("$344.90")));
    }

    @Test
    public void productNotFound() {
        pointOfSale.onBarcode("111111");
        assertThat(scanner().nextLine(), is(equalTo("Product not found for 111111")));
    }

    @Test
    public void emptyBarcode() {
        pointOfSale.onBarcode("");
        assertThat(scanner().nextLine(), is(equalTo("Scanning error: empty barcode")));
    }

    private Scanner scanner() {
        return new Scanner(new BufferedInputStream(new ByteArrayInputStream(outputStream.toByteArray())));
    }
}
