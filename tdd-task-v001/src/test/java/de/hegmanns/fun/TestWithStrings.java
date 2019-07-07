package de.hegmanns.fun;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * Which tests pass and which tests fail?
 * 
 * @author B. Hegmanns
 */
public class TestWithStrings {
	
	private String part1 = "Hello ";
	private String part2 = "World";
	
	private String a = "Hello World";
	private String b = part1 + part2;
	private String c = "Hello " + "World";
	private String d = "Hello " + part2;

	@Test
	public void aEqualsb() {
		MatcherAssert.assertThat(a, Matchers.sameInstance(b)); // that means a == b
	}
	
	@Test
	public void aEqualsDirectSum() {
		MatcherAssert.assertThat(a, Matchers.sameInstance("Hello " + "World")); // that means a == "Hello " + "World"
	}
	
	@Test
	public void aEqualsc() {
		MatcherAssert.assertThat(a, Matchers.sameInstance(c));// that means a == c
	}
	
	@Test
	public void bEqualsc() {
		MatcherAssert.assertThat(b, Matchers.sameInstance(c));// that means b == b
	}
	
	@Test
	public void bEqualsd() {
		MatcherAssert.assertThat(b, Matchers.sameInstance(d));// that means b == d
	}
	
}
