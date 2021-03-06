package it.esteco.pos.e2e;

import org.junit.Before;
import org.junit.Test;

public class PointOfSaleEndToEndTest {

    private FakeOperator fakeOperator;
    private ApplicationRunner applicationRunner;

    @Before
    public void setUp() throws Exception {
        fakeOperator = new FakeOperator();
        applicationRunner = new ApplicationRunner();
    }

    @Test
    public void emptyBarcode() {
        fakeOperator.input("\n");
        applicationRunner.start();
        applicationRunner.showsEmptyBarcodeError();
    }

    @Test
    public void productFound() {
        fakeOperator.input("123456\n");
        applicationRunner.start();
        applicationRunner.showsPrice("$7.95");
    }

    @Test
    public void anotherProductFound() {
        fakeOperator.input("789987\n");
        applicationRunner.start();
        applicationRunner.showsPrice("$11.99");
    }

    @Test
    public void productNotFound() {
        fakeOperator.input("000000\n");
        applicationRunner.start();
        applicationRunner.showsProductNotFound();
    }

    @Test
    public void totalForNoProducts() {
        fakeOperator.input("TOTAL\n");
        applicationRunner.start();
        applicationRunner.showsPrice("$0.00");
    }

    @Test
    public void totalForProductsScanned() {
        fakeOperator.input("123456\n789987\nTOTAL\n");
        applicationRunner.start();
        applicationRunner.showsPrice("$7.95");
        applicationRunner.showsPrice("$11.99");
        applicationRunner.showsPrice("$19.94");
    }

    @Test
    public void totalClosesCart() {
        fakeOperator.input("123456\nTOTAL\nTOTAL\n");
        applicationRunner.start();
        applicationRunner.showsPrice("$7.95");
        applicationRunner.showsPrice("$7.95");
        applicationRunner.showsPrice("$0.00");
    }
}
