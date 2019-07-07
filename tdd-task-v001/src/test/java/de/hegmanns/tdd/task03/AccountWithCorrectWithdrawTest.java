package de.hegmanns.tdd.task03;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountWithCorrectWithdrawTest {

	@Test
	public void testInstructionCoverage1() {
		AccountWithError account = new AccountWithError(BigDecimal.ONE);
		RuntimeException throwedException = Assertions.assertThrows(RuntimeException.class,
				() -> account.withdraw(BigDecimal.TEN));
		Assertions.assertEquals("account is now empty ...", throwedException.getMessage());
	}
	
	@Test
	public void testInstructionCoverage2() {
		AccountWithError account = new AccountWithError(BigDecimal.ONE.negate());
		RuntimeException throwedException = Assertions.assertThrows(RuntimeException.class,
				() -> account.withdraw(BigDecimal.ONE));
		Assertions.assertEquals("account is empty", throwedException.getMessage());
	}
	
	@Test
	public void testBranchCoverage1() {
		AccountWithError account = new AccountWithError(BigDecimal.TEN);
		account.withdraw(BigDecimal.ONE);
	}
}
