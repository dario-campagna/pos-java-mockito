package it.esteco.pos.e2e;

import java.io.ByteArrayInputStream;

public class FakeOperator {
    public void input(String inputAsText) {
        System.setIn(new ByteArrayInputStream(inputAsText.getBytes()));
    }
}
