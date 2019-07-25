package de.hegmanns.tdd.manaca;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

	private Map<String, String> accounts = new HashMap<>();
	private Map<String, Map<String, String>> players = new HashMap<>();

	public void addAccount(String accountName, String password) {
		if (isEmpty(accountName) || isEmpty(password)) {
			throw new AccountException("account name and password may not be empty");
		}
		if (accounts.containsKey(accountName)) {
			throw new AccountException("account name already exists");
		}
		accounts.put(accountName, password);
		players.put(accountName, new HashMap<>());
	}

	private static boolean isEmpty(String string) {
		return string == null || "".equals(string);
	}

	private boolean isValidAccount(String accountname, String password) {
		if (accountname == null || !accounts.containsKey(accountname)) {
			return false;
		}
		String pw = accounts.get(accountname);
		return pw.equals(password);
	}
	
	private boolean containsPlayer(Map<String, String> allPlayers, String playername) {
		return allPlayers.containsKey(playername) || allPlayers.containsValue(playername);
	}
	
	private boolean addPlayerpair(String accountName, String firstPlayername, String secondPlayername) {
		Map<String, String> allPlayers = players.get(accountName);
		if (containsPlayer(allPlayers, firstPlayername) || containsPlayer(allPlayers, secondPlayername)) {
			return false;
		}
		allPlayers.put(firstPlayername, secondPlayername);
		return true;
	}

	public void addPlayer(String otherAccountName, String password, String firstPlayername, String secondPlayername) {
		if (!isValidAccount(otherAccountName, password)) {
			throw new AccountException("unknown accountname / password combination");
		}
		if (isEmpty(firstPlayername) || isEmpty(secondPlayername)) {
			throw new AccountException("players name must not be empty");
		}
		if (firstPlayername.equals(secondPlayername)) {
			throw new AccountException("player name must not be equal");
		}
		
		if (!addPlayerpair(otherAccountName, firstPlayername, secondPlayername)) {
			throw new AccountException("player name ist already defined");
		}
	}

	public void setWinner(String account, String password, String firstPlayer, String secondPlayer,
			String winner) {
		if (!isValidAccount(account, password)) {
			throw new AccountException("unknown accountname / password combination");
		}
		throw new AccountException("unknown pair");
	}

}
