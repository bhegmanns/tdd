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
	
	private boolean isValidAccount(String accountname, String password) {
		if (accountname == null || !accounts.containsKey(accountname)) {
			return false;
		}
		String pw = accounts.get(accountname);
		return pw.equals(password);
	}

	public void addPlayer(String otherAccountName, String password, String firstPlayername, String secondPlayername) {
		if (!isValidAccount(otherAccountName, password)) {
			throw new AccountException("unknown accountname / password combination");
		}
//		if (isEmpty(firstPlayername) || isEmpty(secondPlayername)) {
			throw new AccountException("players name must not be empty");
//		}
		
	}
}
