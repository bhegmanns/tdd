package de.hegmanns.tdd.task01;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

import de.hegmanns.tdd.task01.CheckerFunctions;

public class OddCheckerFunctionTest {
	
	/**
	 * Integer.MAX_VALUE = 2147483647
	 */
	@Test
	public void NumberMaxInIsOdd() {
		assertThat("" + Integer.MAX_VALUE, CheckerFunctions.isOdd(Integer.MAX_VALUE), is(true));
	}
	
	/**
	 * Integer.MIN_VALUE = -2147483648
	 */
	@Test
	public void NumberMinValueIsNotOdd() {
		assertThat("" + Integer.MIN_VALUE, CheckerFunctions.isOdd(Integer.MIN_VALUE), is(false));
	}

	@Test
	public void Number1000IsNotOdd() {
		assertThat(CheckerFunctions.isOdd(1000), is(false));
	}
	
	public void Number1001IsOdd() {
		assertThat(CheckerFunctions.isOdd(1001), is(true));
	}
	
	@Test
	public void Number0IsNotOdd() {
		assertThat(CheckerFunctions.isOdd(0), is(false));
	}
	
}
