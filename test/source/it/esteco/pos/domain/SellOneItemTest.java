package it.esteco.pos.domain;

import it.esteco.pos.PointOfSale;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class SellOneItemTest {

    @Test
    public void emptyBarcode() {
        Display display = mock(Display.class);
        PointOfSale pointOfSale = new PointOfSale(display);

        pointOfSale.onBarcode("");

        verify(display).showEmptyBarcodeError();
    }

    @Test
    public void productFound() {
        Display display = mock(Display.class);
        PointOfSale pointOfSale = new PointOfSale(display);

        pointOfSale.onBarcode("123456");

        verify(display).showPrice("$7.95");
    }

    @Test
    public void anotherProductFound() {
        Display display = mock(Display.class);
        PointOfSale pointOfSale = new PointOfSale(display);

        pointOfSale.onBarcode("789987");

        verify(display).showPrice("$11.99");
    }

    @Test
    public void productNotFound() {
        Display display = mock(Display.class);
        PointOfSale pointOfSale = new PointOfSale(display);

        pointOfSale.onBarcode("000000");

        verify(display).showProductNotFound("000000");
    }
}