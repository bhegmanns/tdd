package de.hegmanns.tdd.manaca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Optional;

public class AccountService {

	private Map<String, String> accounts = new HashMap<>();
	private Map<String, Map<String, String>> players = new HashMap<>();
	private Map<String, Map<String[], String>> winners = new HashMap<>();
	private Map<String, Boolean> winnerDefiningModes = new HashMap<>();

	public void addAccount(String accountName, String password) {
		if (isEmpty(accountName) || isEmpty(password)) {
			throw new AccountException("account name and password may not be empty");
		}
		if (accounts.containsKey(accountName)) {
			throw new AccountException("account name already exists");
		}
		accounts.put(accountName, password);
		players.put(accountName, new HashMap<>());
		winnerDefiningModes.put(accountName, Boolean.FALSE);
		winners.put(accountName, new HashMap<>());
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
		winners.get(accountName).put(new String[] {firstPlayername, secondPlayername}, null);
		return true;
	}

	public void addPlayer(String otherAccountName, String password, String firstPlayername, String secondPlayername) {
		if (!isValidAccount(otherAccountName, password)) {
			throw new AccountException("unknown accountname / password combination");
		}
		if (Boolean.TRUE.equals(winnerDefiningModes.get(otherAccountName))){
			throw new AccountException("after defining first winner new player-pairs not allowed");
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
		Map<String, String> pairs = players.get(account);
		winnerDefiningModes.put(account, Boolean.TRUE);
		if (isEmpty(firstPlayer) || isEmpty(secondPlayer) || !containsPlayer(pairs, firstPlayer) || !containsPlayer(pairs, secondPlayer)) {
			throw new AccountException("unknown pair");
		}
		
		if (!firstPlayer.equals(winner) && !secondPlayer.equals(winner)) {
			throw new AccountException("winner must be a pair-player");
		}
		
		winners.get(account).entrySet().stream()
		.filter((e) -> (e.getKey()[0].equals(firstPlayer) && e.getKey()[1].equals(secondPlayer))
				     ||(e.getKey()[0].equals(secondPlayer) && e.getKey()[1].equals(firstPlayer))
				)
		.findFirst()
		.filter((e) -> e.getValue() == null)
		.orElseThrow(() -> new AccountException("winner already defined"))
		.setValue(winner);
	}

	public List<String> getWinners(String accountName, String password) {
		if (winners.get(accountName).entrySet().stream()
		.filter((e) -> e.getValue() == null)
		.findFirst().isPresent()) {
			throw new AccountException("not all pair-winer defined");
		}
		
		List<String> result = null;
		winners.get(accountName).entrySet().stream()
		.map((e) -> e.getValue())
		.collect(Collectors.toList());
		
		accounts.remove(accountName);
		players.remove(accountName);
		winnerDefiningModes.remove(accountName);
		winners.remove(accountName);
		return result;
	}
	

	
	

}
