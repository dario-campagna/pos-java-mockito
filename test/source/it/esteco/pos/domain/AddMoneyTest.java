package it.esteco.pos.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddMoneyTest {

    @Test
    public void fivePlusSixIsEleven() {
        assertThat(new Money(5).plus(new Money(6)), is(equalTo(new Money(11))));
    }
}
