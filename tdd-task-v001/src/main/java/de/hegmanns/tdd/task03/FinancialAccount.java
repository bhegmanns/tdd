package de.hegmanns.tdd.task03;

public class FinancialAccount {

	private Long amount;
	
	public boolean widthdraw(Long money) {
		long balance = amount - money;
		if (balance >= 0) {
			amount = balance;
			return true;
		}else {
			return false;
		}
	}
	
	public int calculateInterestDays(
			Long startYear,
			Long startMonth,
			Long startDay,
			int finalYear,
			int finalMonth,
			int finalDay) {
		
		return 0; // that isn't correct ;)
	}
}

