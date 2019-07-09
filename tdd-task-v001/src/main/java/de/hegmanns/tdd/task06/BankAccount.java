package de.hegmanns.tdd.task06;

public class BankAccount {

	private long amount;
	
	public BankAccount(long amount) {
		this.amount = amount;
	}
	
	public boolean withdraw(Long money) {
		
		long balance = amount - money;
		if (balance > 0 || balance == 0) {
			amount = balance;
			return true;
		}else {
			return false;
		}
	}
	
}
