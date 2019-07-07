package de.hegmanns.tdd.task03;

import java.math.BigDecimal;

public class AccountWithError {

	private String id;
	private BigDecimal amount;
	private long goodWithdraws = 0;
	private long badWithdraws = 0;
	
	public AccountWithError(BigDecimal amount) {
		this.amount = amount;
	}
	
	public void withdraw(BigDecimal money) {
		if (amount.compareTo(BigDecimal.ZERO) >= 0) {
			amount = amount.subtract(money);
			if (amount.compareTo(BigDecimal.ZERO) < 0) {
				badWithdraws++;
				throw new RuntimeException("account is now empty ...");
			}
			goodWithdraws++;
		}else {
			badWithdraws++;
			throw new RuntimeException("account is empty");
		}
	}
}
