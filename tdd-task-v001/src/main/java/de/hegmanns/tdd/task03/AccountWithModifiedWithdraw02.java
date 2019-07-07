package de.hegmanns.tdd.task03;

import java.math.BigDecimal;

public class AccountWithModifiedWithdraw02 {

	private String id;
	private BigDecimal amount;
	
	public boolean withdraw(BigDecimal money) {
		
		BigDecimal balance = amount.subtract(money);
		if (balance.compareTo(BigDecimal.ZERO) >= 0) {
			amount = balance;
			return true;
		}else if (balance.compareTo(BigDecimal.ZERO) < 0){
			return false;
		}else {
			amount = balance;
			return true;
		}
	}
}
