package de.hegmanns.fun;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

public class SimpleDevisionTest {

	@Test
	public void calculate1000() {
		long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
		long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
		
		assertThat(MICROS_PER_DAY / MILLIS_PER_DAY, is(1000));
		
	}
}
