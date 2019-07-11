package de.hegmanns.tdd.task10;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import de.hegmanns.tdd.task10.CurrencyConverter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * What do you say about these tests?
 * 
 * @author B. Hegmanns
 *
 */
public class CurrencyConverterTest {
	HegiCurrencyDTO currencyDto;
	CurrencyConverter converter;
	BigDecimal convertedAmmount;
	
	public  CurrencyConverterTest() {
		 currencyDto = new HegiCurrencyDTO();
		 converter = new CurrencyConverter(currencyDto);
	}
	
	@Test
	public void test01() {
		Assertions.assertEquals(converter.convert(BigDecimal.TEN, "EUR", "USD"), new BigDecimal("100"));
		Assertions.assertTrue(currencyDto.isMethodCalled());
	}
	
	@Test
	public void resultIsUsd() {
		convertedAmmount = converter.convert(BigDecimal.TEN, "EUR", "CAN");
		Assertions.assertEquals(new BigDecimal("100"), convertedAmmount);
	}
	
//	@Test
//	public void andBack() {
//		BigDecimal shouldBeTen = converter.convert(convertedAmmount, "CAN", "EUR");
//		Assertions.assertEquals(BigDecimal.TEN, shouldBeTen);
//	}
}
