package de.hegmanns.tdd.task04;

import java.math.BigDecimal;

/**
 * With the AddMashine can be build a sum of added numbers and calculate the average.
 *  
 * @author B. Hegmanns
 */
public class AddMashine {

	private Long value;
	private int addedNumbers;
	
	public AddMashine(Long initialValue) {
		this.value = initialValue;
		this.addedNumbers = 1;
	}
	
	public void add(Long value) {
		this.value += value;
		this.addedNumbers++;
	}
	
	public void sub(Long value) {
		this.value -= value;
		this.addedNumbers++;
	}
	
	public Long getSum() {
		return value;
	}
	
	public BigDecimal getAverage() {
		return new BigDecimal(addedNumbers).divide(new BigDecimal(value));
	}
}
