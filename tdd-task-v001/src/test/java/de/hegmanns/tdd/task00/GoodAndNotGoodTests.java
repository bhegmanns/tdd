package de.hegmanns.tdd.task00;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;


/**
 * What do you say about these tests.
 * 
 * @author B. Hegmanns
 *
 */
@TestMethodOrder(OrderAnnotation.class)
public class GoodAndNotGoodTests {

	@Test
	public void goodSum() {
		assertThat(1+1, is(2));
	}
	
	@Test
	public void oneTimeIncrementIncreasesValueWithOne() {
		Counter c = new Counter();
		c.increment();
		assertThat(c.getValue(), is(1));
	}
	
	@Test
	public void shouldIncrementAndDecrement() {
		Counter c = new Counter();
		c.increment();
		assertThat(c.getValue(), is(1));
		c.decrement();
		assertThat(c.getValue(), is(0));
	}
	
	Counter counter = new Counter();
	@Test
	@Order(1)
	public void testOne() {
		assertThat(counter.getValue(), is(0));
	}
	
	@Test
	@Order(2)
	public void testTwo() {
		// comes later
	}

	@Test
	@Order(3)
	public void testFinal() {
		counter.increment();
		assertThat(counter.getValue(), is(1));
	}
}

class Counter{
	private int value;
	public Counter() {
		value = 0;
	}
	
	public void increment() {
		value++;
	}
	
	public void decrement() {
		value--;
	}
	
	public int getValue() {
		return value;
	}
}
