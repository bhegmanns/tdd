package de.hegmanns.tdd.task10;

import java.math.BigDecimal;

public class CurrencyConverter {

	public BigDecimal convert(BigDecimal amount, String currencyFrom, String currencyTo) {
		
		CurrencyDto dto = new CurrencyDto();
		BigDecimal exchangeRate = dto.getExchangeRate(currencyFrom, currencyTo);
		
		return amount.multiply(exchangeRate);
	}
}
