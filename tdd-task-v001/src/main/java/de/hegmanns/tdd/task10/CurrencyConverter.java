package de.hegmanns.tdd.task10;

import java.math.BigDecimal;

public class CurrencyConverter {
	private CurrencyDto currencyDto;
	
	public static CurrencyConverter get() {
		return new CurrencyConverter(new CurrencyDto());
	}

	public CurrencyConverter(CurrencyDto currencyDto) {
		super();
		this.currencyDto = currencyDto;
	}


	public BigDecimal convert(BigDecimal amount, String currencyFrom, String currencyTo) {
		
		BigDecimal exchangeRate = currencyDto.getExchangeRate(currencyFrom, currencyTo);
		
		return amount.multiply(exchangeRate);
	}
}
