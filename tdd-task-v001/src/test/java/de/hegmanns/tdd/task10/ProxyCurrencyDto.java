package de.hegmanns.tdd.task10;

import java.math.BigDecimal;

public class ProxyCurrencyDto extends CurrencyDto{

	@Override
	public BigDecimal getExchangeRate(String currencyFrom, String currencyTo) {
		return BigDecimal.TEN;
	}

}
