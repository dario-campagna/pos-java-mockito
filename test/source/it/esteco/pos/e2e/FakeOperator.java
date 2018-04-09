package it.esteco.pos.e2e;

import java.io.ByteArrayInputStream;

public class FakeOperator {
    public void input(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
    }
}
