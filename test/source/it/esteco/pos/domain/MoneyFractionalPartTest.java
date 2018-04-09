package it.esteco.pos.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MoneyFractionalPartTest {

    @Test
    public void fractionalPartOfOneUndredFourteenIsFourteen() {
        assertThat(new Money(114).fractionalPart(), is(equalTo("14")));
    }

    @Test
    public void fractionalPartOfSixThousandIsDoubleZero() {
        assertThat(new Money(6000).fractionalPart(), is(equalTo("00")));
    }
}
