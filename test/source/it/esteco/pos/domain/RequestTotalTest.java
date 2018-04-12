package it.esteco.pos.domain;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RequestTotalTest {

    private Display display;
    private Catalog catalog;
    private PointOfSale pointOfSale;
    private Cart cart;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        catalog = mock(Catalog.class);
        cart = mock(Cart.class);
        pointOfSale = new PointOfSale(display, catalog, cart);
    }

    @Test
    public void noProductsScanned() {
        when(cart.getTotal()).thenReturn(new Money(0));

        pointOfSale.onTotalRequested();

        verify(cart).getTotal();
        verify(display).showPrice(new Money(0));
    }

    @Test
    public void oneProductScanned() {
        when(catalog.findPrice("123456")).thenReturn(new Money(795));
        when(cart.getTotal()).thenReturn(new Money(795));

        pointOfSale.onBarcode("123456");

        pointOfSale.onTotalRequested();

        verify(cart).add(new Money(795));
        verify(cart).getTotal();
        verify(display, times(2)).showPrice(new Money(795));
    }

    @Test
    public void twoProductsScanned() {
        when(catalog.findPrice("123456")).thenReturn(new Money(795));
        when(cart.getTotal()).thenReturn(new Money(1590));

        pointOfSale.onBarcode("123456");
        pointOfSale.onBarcode("123456");

        pointOfSale.onTotalRequested();

        verify(cart, times(2)).add(new Money(795));
        verify(display, times(2)).showPrice(new Money(795));
        verify(cart).getTotal();
        verify(display).showPrice(new Money(1590));
    }

    @Test
    public void clearCart() {
        when(catalog.findPrice("123456")).thenReturn(new Money(795));
        when(cart.getTotal()).thenReturn(new Money(795));

        pointOfSale.onBarcode("123456");

        pointOfSale.onTotalRequested();

        verify(cart).add(new Money(795));
        verify(cart).getTotal();
        verify(cart).clear();
        verify(display, times(2)).showPrice(new Money(795));
    }
}
