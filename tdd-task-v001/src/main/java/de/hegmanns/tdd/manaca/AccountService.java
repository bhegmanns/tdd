package de.hegmanns.tdd.manaca;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
	
	private Map<String, String> accounts = new HashMap<>();
	
	public void addAccount(String accountName, String password) {
		if (isEmpty(accountName) || isEmpty(password)) {
			throw new AccountException("account name and password may not be empty");
		}
		if (accounts.containsKey(accountName)) {
			throw new AccountException("account name already exists");
		}
		accounts.put(accountName, password);
	}
	
	private static boolean isEmpty(String string) {
		return string==null || "".equals(string);
	}

	public void addPlayer(String otherAccountName, String password, String object, String object2) {
		throw new AccountException("unknown accountname / password combination");
	}
}
