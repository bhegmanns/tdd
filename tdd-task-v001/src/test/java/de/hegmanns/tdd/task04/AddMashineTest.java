package de.hegmanns.tdd.task04;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;

public class AddMashineTest {

	@Test
	public void hereCanBeYourTest() {
		AddMashine addMashine = new AddMashine(0L);
		addMashine.add(2L);
		
		assertThat(addMashine.getSum(), is(1));
		assertThat(addMashine.getAverage(), comparesEqualTo(new BigDecimal("2.0")));
	}
}
