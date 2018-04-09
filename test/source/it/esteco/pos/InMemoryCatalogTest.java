package it.esteco.pos;

import it.esteco.pos.adapters.InMemoryCatalog;
import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.ports.Catalog;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InMemoryCatalogTest {

    private Catalog catalog;

    @Before
    public void setUp() {
        Map<String, Money> priceByBarcode = new HashMap() {{
            put("123456", new Money(795));
            put("789987", new Money(1199));
        }};
        catalog = new InMemoryCatalog(priceByBarcode);
    }

    @Test
    public void findPrice() {
        assertEquals(new Money(795), catalog.findPrice("123456"));
        assertEquals(new Money(1199), catalog.findPrice("789987"));
    }

    @Test
    public void priceNotFound() {
        assertNull(catalog.findPrice("999999"));
    }
}
