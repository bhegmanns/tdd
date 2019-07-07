package de.hegmanns.fun;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

public class SimpleCalculationTest {

	@Test
	public void checkDifference() {
		double difference = 2.00 - 1.10;
		
		assertThat("" + difference, difference, is(0.90));
	}
}
