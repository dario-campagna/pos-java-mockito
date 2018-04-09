package it.esteco.pos.domain;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class SellOneItemTest {

    private Display display;
    private PointOfSale pointOfSale;
    private Catalog catalog;

    @Before
    public void setUp() {
        display = mock(Display.class);
        catalog = mock(Catalog.class);
        pointOfSale = new PointOfSale(display, catalog);
    }

    @Test
    public void emptyBarcode() {
        pointOfSale.onBarcode("");

        verify(display).showEmptyBarcodeError();
    }

    @Test
    public void productFound() {
        when(catalog.findPrice("123456")).thenReturn("$7.95");

        pointOfSale.onBarcode("123456");

        verify(catalog).findPrice("123456");
        verify(display).showPrice("$7.95");
    }

    @Test
    public void anotherProductFound() {
        when(catalog.findPrice("789987")).thenReturn("$11.99");

        pointOfSale.onBarcode("789987");

        verify(catalog).findPrice("789987");
        verify(display).showPrice("$11.99");
    }

    @Test
    public void productNotFound() {
        pointOfSale.onBarcode("000000");

        verify(catalog).findPrice("000000");
        verify(display).showProductNotFound("000000");
    }
}
