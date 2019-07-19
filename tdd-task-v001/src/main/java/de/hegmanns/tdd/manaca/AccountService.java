package de.hegmanns.tdd.manaca;

public class AccountService {
	

	public void addAccount(String accountName, String password) {
			throw new AccountException("account name and password may not be empty");
	}
	
}
