package de.hegmanns.tdd.stringconverter;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

public class StringTest {

	//a) An empty String ("") results 0
	@Test
	public void emptyStringResultZero() {
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.calculate("");
		assertThat(result, is(0));
	}
}


