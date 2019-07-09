package de.hegmanns.tdd.task12;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

public class BankAccountWithLimitTest {

	@Test
	public void smokeTest() {
		assertThat(1, is(1));
	}
}
