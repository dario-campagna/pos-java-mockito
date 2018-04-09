package it.esteco.pos.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoneyIntegerPartTest {

    @Test
    public void integerPartOfEighteenIsZero() {
        assertThat(new Money(18).integerPart(), is(equalTo("0")));
    }

    @Test
    public void integerPartOfTwoHundredIsTwo() {
        assertThat(new Money(200).integerPart(), is(equalTo("2")));
    }
}
