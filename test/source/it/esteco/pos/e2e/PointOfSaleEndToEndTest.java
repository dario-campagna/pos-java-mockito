package it.esteco.pos.e2e;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PointOfSaleEndToEndTest {

    private FakeOperator fakeOperator;
    private ApplicationRunner applicationRunner;

    @Before
    public void setUp() throws Exception {
        fakeOperator = new FakeOperator();
        applicationRunner = new ApplicationRunner();
    }

    @Test@Ignore
    public void productFound() {
        fakeOperator.input("123456\n");
        applicationRunner.start();
        applicationRunner.showsPrice("$7.95");
    }
}
