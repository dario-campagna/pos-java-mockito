package it.esteco.pos;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class SellOneItem {

    @Test
    public void productFound() {
        Display display = mock(Display.class);
        PointOfSale pointOfSale = new PointOfSale(display);

        pointOfSale.onBarcode("123456");

        verify(display).showPrice("$7.95");
    }
}
