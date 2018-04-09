package it.esteco.pos;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class SellOneItemTest {

    private Display display;
    private PointOfSale pointOfSale;
    private Catalog catalog;
    private InOrder inOrder;

    @Before
    public void setUp() {
        display = mock(Display.class);
        catalog = mock(Catalog.class);
        pointOfSale = new PointOfSale(display, catalog);
        inOrder = inOrder(catalog, display);
    }

    @Test
    public void productFound() {
        String barcode = "123456";
        Money price = new Money(795);
        when(catalog.findPrice(barcode)).thenReturn(price);

        pointOfSale.onBarcode(barcode);

        inOrder.verify(catalog).findPrice(barcode);
        inOrder.verify(display, times(1)).showPrice(price);
    }

    @Test
    public void anotherProductFound() {
        String barcode = "789987";
        Money price = new Money(1199);
        when(catalog.findPrice(barcode)).thenReturn(price);

        pointOfSale.onBarcode(barcode);

        inOrder.verify(catalog).findPrice(barcode);
        inOrder.verify(display, times(1)).showPrice(price);
    }

    @Test
    public void productNotFound() {
        pointOfSale.onBarcode("999999");

        verify(display, times(1)).showProductNotFoundFor("999999");
    }

    @Test
    public void emptyBarcode() {
        pointOfSale.onBarcode("");

        verify(display, times(1)).showEmptyBarcodeError();
    }
}
