package de.hegmanns.tdd.task03;

import java.math.BigDecimal;

public class AccountWithModifiedWithdraw01 {

	private String id;
	private BigDecimal amount;
	
	public boolean withdraw(BigDecimal money) {
		
		BigDecimal balance = amount.subtract(money);
		if (balance.compareTo(BigDecimal.ZERO) >= 0) {
			amount = balance;
			return false;
		}else {
			return false;
		}
	}
}
