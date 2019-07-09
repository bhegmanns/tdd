package de.hegmanns.tdd.task10;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import de.hegmanns.tdd.task10.CurrencyConverter;

@TestMethodOrder(OrderAnnotation.class)
public class AnotherTestInOrder {

	CurrencyConverter converter = new CurrencyConverter();
	static BigDecimal convertedAmmount;
	
	@Test
	@Order(1)
	public void test01() {
		Assertions.assertEquals(converter.convert(BigDecimal.TEN, "EUR", "USD"), new BigDecimal("476.195"));
	}
	
	@Test
	@Order(2)
	public void resultIsCNY() {
		convertedAmmount = converter.convert(BigDecimal.TEN, "EUR", "CNY");
		Assertions.assertEquals(new BigDecimal("700.00"), convertedAmmount);
	}
	
	@Test
	@Order(3)
	public void andBack() {
		BigDecimal shouldBeTen = converter.convert(convertedAmmount, "CNY", "EUR");
		Assertions.assertEquals(BigDecimal.TEN, shouldBeTen);
	}
}
