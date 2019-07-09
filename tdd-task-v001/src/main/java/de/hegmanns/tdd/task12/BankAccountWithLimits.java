package de.hegmanns.tdd.task12;

/**
 * BankAccountWithLimis is a special BankAccount.
 * In case of sufficient amount withdraws less than 1000 are possible every time.
 * Withdraws above (or equal) than 1000 are only possible for 10 times. After that, the account  
 * have to be unlocked for those withdraws.
 * 
 * @author B. Hegmanns
 *
 */
public class BankAccountWithLimits {

	public boolean withdraw(int money) {
		return false;
	}
	
	public void unlock() {
		
	}
}
