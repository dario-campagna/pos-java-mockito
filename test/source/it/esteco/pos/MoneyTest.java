package it.esteco.pos;

import it.esteco.pos.domain.Money;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MoneyTest {

    @Test
    public void integerPartOfTwelveIsZero() {
        assertThat(new Money(12).integerPart(), is(equalTo("0")));
    }

    @Test
    public void integerPartOfNineThousandIsNinety() {
        assertThat(new Money(9000).integerPart(), is(equalTo("90")));
    }

    @Test
    public void fractionalPartOfNinetyNineIsNinetyNine() {
        assertThat(new Money(99).fractionalPart(), is(equalTo("99")));
    }

    @Test
    public void fractionalPartOfOneHundredIsDoubleZero() {
        assertThat(new Money(100).fractionalPart(), is(equalTo("00")));
    }
}
