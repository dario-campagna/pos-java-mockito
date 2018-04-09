package it.esteco.pos;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class SellOneItem {

    private Display display;
    private PointOfSale pointOfSale;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        pointOfSale = new PointOfSale(display);
    }

    @Test
    public void productFound() {
        pointOfSale.onBarcode("123456");

        verify(display).showPrice("$7.95");
    }

    @Test
    public void anotherProductFound() {
        pointOfSale.onBarcode("789987");

        verify(display).showPrice("$11.99");
    }

    @Test
    public void productNotFound() {
        pointOfSale.onBarcode("999999");

        verify(display).showProductNotFoundFor("999999");
    }

    @Test
    public void emptyBarcode() {
        pointOfSale.onBarcode("");

        verify(display).showEmptyBarcodeError();
    }
}
