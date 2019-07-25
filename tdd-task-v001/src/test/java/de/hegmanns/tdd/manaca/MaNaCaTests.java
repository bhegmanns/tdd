package de.hegmanns.tdd.manaca;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

public class MaNaCaTests {

//	01 Define at least one empty string for new accountname/password-combination throws exception
//	   with message "account name and password may not be empty"
	@Test
	public void nullAsAccountNameThrowsException() {
		AccountService sut = new AccountService();
		String accountName = null;
		String password    = "anypassword";
		try {
			sut.addAccount(accountName, password);
			throw new AssertionError("exception AccountException expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("account name and password may not be empty"));
		}
	}
	
	@Test
	public void nullAsPasswordThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password    = null;
		try {
			sut.addAccount(accountName, password);
			throw new AssertionError("exception AccountException expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("account name and password may not be empty"));
		}
	}
	
	@Test
	public void nullAsPasswordAndAccountnameThrowsException() {
		AccountService sut = new AccountService();
		String accountName = null;
		String password    = null;
		try {
			sut.addAccount(accountName, password);
			throw new AssertionError("exception AccountException expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("account name and password may not be empty"));
		}
	}
	
	@Test
	public void emptyPasswordAndNullAccountNameThrowsException() {
		AccountService sut = new AccountService();
		String accountName = null;
		String password    = "";
		try {
			sut.addAccount(accountName, password);
			throw new AssertionError("exception AccountException expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("account name and password may not be empty"));
		}
	}
	
	@Test
	public void nullPasswordAndEmptyAccountNameThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "";
		String password    = null;
		try {
			sut.addAccount(accountName, password);
			throw new AssertionError("exception AccountException expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("account name and password may not be empty"));
		}
	}
	
	@Test
	public void emptyPasswordAndEmptyAccountNameThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "";
		String password    = "";
		try {
			sut.addAccount(accountName, password);
			throw new AssertionError("exception AccountException expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("account name and password may not be empty"));
		}
	}
	
	@Test
	public void emptyPasswordThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountName";
		String password    = "";
		try {
			sut.addAccount(accountName, password);
			throw new AssertionError("exception AccountException expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("account name and password may not be empty"));
		}
	}
	
	@Test
	public void emptyAccountNameThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "";
		String password    = "anyPassword";
		try {
			sut.addAccount(accountName, password);
			throw new AssertionError("exception AccountException expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("account name and password may not be empty"));
		}
	}
	
//	02 Define twice time non empty strings for new accountname/password with same accountname
//	   trows exception "account name already exists"
	@Test
	public void twiceTimeSameAccountnameOtherPasswordThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String firstPassword    = "anyFirstPassword";
		String secondPassword   = "anySecondPassword";
		sut.addAccount(accountName, firstPassword);
		try {
			sut.addAccount(accountName, secondPassword);
			throw new AssertionError("exception AccountException expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("account name already exists"));
		}
	}
	
	@Test
	public void twiceTimeSameAccountnameSamePasswordThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password    = "anyPassword";
		sut.addAccount(accountName, password);
		try {
			sut.addAccount(accountName, password);
			throw new AssertionError("exception AccountException expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("account name already exists"));
		}
	}
	
//	03 Define player pair for unknown account (=unknown accountname/password-combination) throws
//	   exception with message "unknown accountname / password combination"
	
	@Test
	public void addPlayerpairForUnknownAccountNameThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String otherAccountName = "otherAccountname";
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(otherAccountName, password, null, null);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown accountname / password combination"));
		}
	}
	
	@Test
	public void addPlayerpairForKnownAccountNameWrongPasswordThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String wrongPassword = "wrongPassword";
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, wrongPassword, null, null);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown accountname / password combination"));
		}
	}
	
	@Test
	public void addPlayerpairForNullAccountNameThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String nullAccountName = null;
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(nullAccountName, password, null, null);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown accountname / password combination"));
		}
	}
	
	@Test
	public void addPlayerpairForNullPasswordThrowsExceptio() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String nullPassword = null;
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, nullPassword, null, null);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown accountname / password combination"));
		}
	}
	
//	04 Define at least one player with empty name of the player pair for known account 
//	   (=known accountname/password-combination) throws exception with message 
//	   "players name must not be empty"
	
	@Test
	public void addFirstEmptyPlayerThowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "";
		String secondPlayername = "anySecondPlayername";
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("players name must not be empty"));
		}
	}
	
	@Test
	public void addFirstNullPlayerThowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = null;
		String secondPlayername = "anySecondPlayername";
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("players name must not be empty"));
		}
	}
	
	@Test
	public void addSecondNullPlayerThowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "anyFirstPlayername";
		String secondPlayername = null;
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("players name must not be empty"));
		}
	}
	
	@Test
	public void addSecondEmptyPlayerThowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "anyFirstPlayername";
		String secondPlayername = "";
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("players name must not be empty"));
		}
	}
	
	@Test
	public void addFirstEmptyPlayerSecondEmptyPlayerThowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "";
		String secondPlayername = "";
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("players name must not be empty"));
		}
	}
	
	@Test
	public void addFirstNullPlayerSecondNullPlayerThowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = null;
		String secondPlayername = null;
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("players name must not be empty"));
		}
	}
	
	@Test
	public void addFirstEmptyPlayerSecondNullPlayerThowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "";
		String secondPlayername = null;
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("players name must not be empty"));
		}
	}
	
	@Test
	public void addFirstNullPlayerSecondEmptyPlayerThowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = null;
		String secondPlayername = "";
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("players name must not be empty"));
		}
	}
	
//	05 Define both player with equal names of the player pair for known account throws exception
//	   with message "player name must not be equal"
	
	@Test
	public void bothPlayerNullThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "anyPlayername";
		String secondPlayername = "anyPlayername";
		sut.addAccount(accountName, password);
		
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("player name must not be equal"));
		}
	}
	
//	06 Define at least one player with a name which have been defined before for a player pair
//	   for the same known account throws exception with message "player name ist already defined"
	
	@Test
	public void addEqualsPairThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "anyFirstPlayername";
		String secondPlayername = "anySecondPlayername";
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("player name ist already defined"));
		}
	}
	
	@Test
	public void addEqualFirstPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "anyFirstPlayername";
		String secondPlayername = "anySecondPlayername";
		String secondPlayernameSecondTime = "anySecondPlayernameSecondTime";
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
		try {
			sut.addPlayer(accountName, password, firstPlayername, secondPlayernameSecondTime);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("player name ist already defined"));
		}
	}
	
	@Test
	public void addEqualSecondPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "anyFirstPlayername";
		String secondPlayername = "anySecondPlayername";
		String firstPlayernameSecondTime = "anyFirstPlayernameSecondTime";
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
		try {
			sut.addPlayer(accountName, password, firstPlayernameSecondTime, secondPlayername);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("player name ist already defined"));
		}
	}
	
	@Test
	public void addEqualSecondPlayerAsFirstPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "anyFirstPlayername";
		String secondPlayername = "anySecondPlayername";
		String firstPlayernameSecondTime = "anyFirstPlayernameSecondTime";
		String secondPlayernameSecondTime = firstPlayername;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
		try {
			sut.addPlayer(accountName, password, firstPlayernameSecondTime, secondPlayernameSecondTime);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("player name ist already defined"));
		}
	}
	
	@Test
	public void addEqualFirstPlayerAsSecondPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayername = "anyFirstPlayername";
		String secondPlayername = "anySecondPlayername";
		String firstPlayernameSecondTime = secondPlayername;
		String secondPlayernameSecondTime = "anySecondPlayernameSecondTime";
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayername, secondPlayername);
		try {
			sut.addPlayer(accountName, password, firstPlayernameSecondTime, secondPlayernameSecondTime);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("player name ist already defined"));
		}
	}
	
//	07 Define pair-winner for unkonwn account throws exception with message 
//	   "unknown accountname / password combination"
	
	@Test
	public void defineWinnerForWrongPasswordThowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String wrongPassword = "wrongPassword";
		String firstPlayer = null;
		String secondPlayer = null;
		String winner = null;
		sut.addAccount(accountName, password);
		try {
			sut.setWinner(accountName, wrongPassword, firstPlayer, secondPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown accountname / password combination"));
		}
	}
	
	@Test
	public void defineWinnerForUnknownAccountThowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String unknownAccount = "unknownAccount";
		String firstPlayer = null;
		String secondPlayer = null;
		String winner = null;
		sut.addAccount(accountName, password);
		try {
			sut.setWinner(unknownAccount, password, firstPlayer, secondPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown accountname / password combination"));
		}
	}
	
//	08 Define pair-winner for known account but unknown pair throws exception with message
//	   "unknown pair"
	
	@Test
	public void setWinnerWithNullFirstPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String firstUnknownPlayer = null;
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstUnknownPlayer, secondPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	
	@Test
	public void setWinnerWithEmptyFirstPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String firstUnknownPlayer = "";
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstUnknownPlayer, secondPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	
	@Test
	public void setWinnerWithNullSecondtPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String secondUnknownPlayer = null;
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstPlayer, secondUnknownPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	
	@Test
	public void setWinnerWithEmptySecondPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String secondUnknownPlayer = "";
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstPlayer, secondUnknownPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	
	@Test
	public void setWinnerWithEmptyPlayersThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String firstUnknownPlayer = "";
		String secondUnknownPlayer = "";
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstUnknownPlayer, secondUnknownPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	
	@Test
	public void setWinnerWithNullPlayersThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String firstUnknownPlayer = null;
		String secondUnknownPlayer = null;
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstUnknownPlayer, secondUnknownPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	
	@Test
	public void setWinnerWithEmptyFirstPlayerAndNullSecondPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String firstUnknownPlayer = "";
		String secondUnknownPlayer = null;
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstUnknownPlayer, secondUnknownPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	
	@Test
	public void setWinnerWithNullFirstPlayerAndEmptySecondPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String firstUnknownPlayer = null;
		String secondUnknownPlayer = "";
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstUnknownPlayer, secondUnknownPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	@Test
	public void setWinnerWithUnknownFirstPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String firstUnknownPlayer = "anyFirstUnknownPlayer";
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstUnknownPlayer, secondPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	
	@Test
	public void setWinnerWithUnknownSecondPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String secondUnknownPlayer = "anySecondUnknownPlayer";
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstPlayer, secondUnknownPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	
	@Test
	public void setWinnerWithUnknownBothPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String firstUnknownPlayer = "anyFirstUnknownPlayer";
		String secondUnknownPlayer = "anySecondUnknownPlayer";
		String winner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstUnknownPlayer, secondUnknownPlayer, winner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("unknown pair"));
		}
	}
	
//	09 Define pair-winner for known account and known pair not containing a pair-players name throws 
//	   exception with message "winner must be a pair-player"
	
	@Test
	public void setWinnerForNotContainingPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String unknownWinner = "unknownWinner";
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstPlayer, secondPlayer, unknownWinner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("winner must be a pair-player"));
		}
	}
	
	@Test
	public void setWinnerForNullPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String nullWinner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstPlayer, secondPlayer, nullWinner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("winner must be a pair-player"));
		}
	}
	
	@Test
	public void setWinnerForEmptyPlayerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String emptyWinner = "";
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		try {
			sut.setWinner(accountName, password, firstPlayer, secondPlayer, emptyWinner);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("winner must be a pair-player"));
		}
	}
	
//	10 Define player pair after first defining pair-winner for known account throws exception 
//	   with message "after defining first winner new player-pairs not allowed"
	
	@Test
	public void addPairAfterDefiningPairWinnerThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String winner = firstPlayer;
		String firstPlayerSecondPair = "anyFirstPlayerSecondPair";
		String secondPlayerSecondPair = "anySecondPlayerSecondPair";
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		sut.setWinner(accountName, password, firstPlayer, secondPlayer, winner);
		try {
			sut.addPlayer(accountName, password, firstPlayerSecondPair, secondPlayerSecondPair);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("after defining first winner new player-pairs not allowed"));
		}
	}
	
	@Test
	public void addPairAfterDefiningPairWinnerWithOtherOrderThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String winner = firstPlayer;
		String firstPlayerSecondPair = "anyFirstPlayerSecondPair";
		String secondPlayerSecondPair = "anySecondPlayerSecondPair";
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		sut.setWinner(accountName, password, secondPlayer, firstPlayer, winner);
		try {
			sut.addPlayer(accountName, password, firstPlayerSecondPair, secondPlayerSecondPair);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("after defining first winner new player-pairs not allowed"));
		}
	}
	
//	11 Define pair-winner for known account and known pair twice or more than one time
//	   throws exception with message "winner already defined"
	
	@Test
	public void defineWinnerForSamePairTwiceTimesThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayer = "anyFirstPlayer";
		String secondPlayer = "anySecondPlayer";
		String winner = firstPlayer;
		String secondWinner = null;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayer, secondPlayer);
		sut.setWinner(accountName, password, firstPlayer, secondPlayer, winner);
		try {
			sut.setWinner(accountName, password, firstPlayer, secondPlayer, secondPlayer);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("winner already defined"));
		}
	}
	
//	12 Asking for winnerlist for known account before defined all pair-winner
//	   throws exception with message "not all pair-winer defined"
	
	@Test
	public void askWinnerListAfterSettingOneWinnerByTwoPairsThrowsException() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayerFirstPair = "anyFirstPlayer";
		String secondPlayerFirstPair = "anySecondPlayer";
		String firstPlayerSecondPair = "anyFirstPlayerSecondPair";
		String secondPlayerSecondPair = "anySecondPlayerSecondPair";
		String winner = firstPlayerFirstPair;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayerFirstPair, secondPlayerFirstPair);
		sut.addPlayer(accountName, password, firstPlayerSecondPair, secondPlayerSecondPair);
		sut.setWinner(accountName, password, firstPlayerFirstPair, secondPlayerFirstPair, winner);
		try {
			sut.getWinners(accountName, password);
			throw new AssertionError("Exception AccountExcepion expected");
		}catch(AccountException e) {
			assertThat(e.getMessage(), is("not all pair-winer defined"));
		}
	}
	
//	13 After output winner for account the account will be closed and can be defined new.
	
	@Test
	public void afterAskingWinnerlistNewAccountWithSameNameIsPossible() {
		AccountService sut = new AccountService();
		String accountName = "anyAccountname";
		String password     = "anyPassword";
		String firstPlayerFirstPair = "anyFirstPlayer";
		String secondPlayerFirstPair = "anySecondPlayer";
		String winner = firstPlayerFirstPair;
		sut.addAccount(accountName, password);
		sut.addPlayer(accountName, password, firstPlayerFirstPair, secondPlayerFirstPair);
		sut.setWinner(accountName, password, firstPlayerFirstPair, secondPlayerFirstPair, winner);
		sut.getWinners(accountName, password);
		
		sut.addAccount(accountName, password);
	}
}
