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
	
}
