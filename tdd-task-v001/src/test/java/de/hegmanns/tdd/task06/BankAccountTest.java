package de.hegmanns.tdd.task06;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;

public class BankAccountTest {

	@Test
	public void withdrawMoreMoneyThanAmountFails() {
		BankAccount anyAccount = new BankAccount(1);
		
		boolean withdrawOk = anyAccount.withdraw(10L);
		assertThat(withdrawOk, is(true));
	}
	
	@Test
	public void withdrawCompleteAmountPasses() {
		BankAccount anyAccount = new BankAccount(1);
		boolean withdrawOk = anyAccount.withdraw(1L);
		assertThat(withdrawOk, is(true));
	}
	
	
}
