package de.hegmanns.tdd.task10;

import java.math.BigDecimal;

public class HegiCurrencyDTO extends CurrencyDto {

	private boolean methodCalled = false;
	
	@Override
	public BigDecimal getExchangeRate(String currencyFrom, String currencyTo) {
		methodCalled = true;
		return BigDecimal.TEN;
	}
	
	public boolean isMethodCalled() {
		return methodCalled;
	}

}
