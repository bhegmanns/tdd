package de.hegmanns.tdd.task10;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class ExchangeRate implements Serializable{
	private static final long serialVersionUID = 1L;
	private LocalDateTime time;
	private String from;
	private String to;
	private BigDecimal exchangeRate;
	
	public ExchangeRate() {}
	
	public ExchangeRate(ExchangeRate exchangeRate, BigDecimal diff) {
		this.exchangeRate = exchangeRate.exchangeRate.add(diff.setScale(4, RoundingMode.HALF_DOWN)).setScale(4, RoundingMode.HALF_DOWN);
		this.from = exchangeRate.from;
		this.to   = exchangeRate.to;
		this.time = LocalDateTime.now();
	}
	
	public ExchangeRate(String from, String to, BigDecimal rate) {
		this.time = LocalDateTime.now();
		this.from = from;
		this.to   = to;
		this.exchangeRate = rate.setScale(4, RoundingMode.HALF_DOWN);
	}

	public LocalDateTime getTime() {
		return time;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}
	
	
}
