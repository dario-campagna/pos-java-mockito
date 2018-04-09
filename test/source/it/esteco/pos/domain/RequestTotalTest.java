package it.esteco.pos.domain;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RequestTotalTest {

    private Display display;
    private Catalog catalog;
    private PointOfSale pointOfSale;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        catalog = mock(Catalog.class);
        pointOfSale = new PointOfSale(display, catalog);
    }

    @Test
    public void noProductsScanned() {
        pointOfSale.onTotalRequested();

        verify(display).showPrice(new Money(0));
    }

    @Test
    public void oneProductScanned() {
        when(catalog.findPrice("123456")).thenReturn(new Money(795));

        pointOfSale.onBarcode("123456");

        pointOfSale.onTotalRequested();

        verify(display, times(2)).showPrice(new Money(795));
    }
}
