package de.hegmanns.tdd.stringconverter;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

public class StringTest {

	//a) An empty String ("") results 0
	@Test
	public void emptyStringResultZero() {
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.calculate("");
		assertThat(result, is(0));
	}
	
	//b) A String containing only one number returns this number
	@Test
	public void StringHasOneNumberTest() {
		StringCalculator sut = new StringCalculator();
		String anystringwithonenumber = "1";
		int result = sut.calculate(anystringwithonenumber);
		assertThat(result,is(1));
	}
	
//	c) A String with two comma separated numbers returns the sum of these numbers
	@Test 
	public void twocommaseparatednumbersreturnsumm() {
		StringCalculator sut = new StringCalculator();
		String anystringwithonenumber = "1,1000";
		int result = sut.calculate(anystringwithonenumber);
		assertThat(result,is(1001));
	}
	
//	d) A String with two numbers, one number in each line, returns the sum of these numbers
	@Test
	public void twolineseparatedNumbersReturnTheSum() {
		StringCalculator sut = new StringCalculator();
		String anyStringWithLinebreak = "1000\n500";
		int expectedResult = 1500;
		int result = sut.calculate(anyStringWithLinebreak);
		assertThat(result, is(expectedResult));
	}
	
//	e) A String with three numbers, separated like c and d returns the sum of these numbers
	@Test
	public void threNumberseparedWithCommaAndLinebreakReturnsSum() {
		StringCalculator sut = new StringCalculator();
		String anyStringWithLinebreak = "1000,1000\n500";
		int expectedResult = 2500;
		int result = sut.calculate(anyStringWithLinebreak);
		assertThat(result, is(expectedResult));
	}
	
//	f) A String which represented a negative number throws an Exception
	@Test
	public void negativeNumberResultsInException(){
		StringCalculator sut = new StringCalculator();
		String anyStringWithLinebreak = "-100";
		try{
			sut.calculate(anyStringWithLinebreak);
			throw new RuntimeException("Exception is exepted");
		}catch(NumberFormatException e) {}
		
	}
	
//	g) Represented numbers greater than 1000 will be dropped
	@Test
	public void numbersGreaterThan1000WillBeDropped() {
		StringCalculator sut = new StringCalculator();
		String anyStringWithLinebreak = "1000,2000\n500";
		int expectedResult = 1500;
		int result = sut.calculate(anyStringWithLinebreak);
		assertThat(result, is(expectedResult));
	}
	
	@Test
	public void numbersGreaterContains1001WillBeDropped() {
		StringCalculator sut = new StringCalculator();
		String anyStringWithLinebreak = "1000,1001\n500";
		int expectedResult = 1500;
		int result = sut.calculate(anyStringWithLinebreak);
		assertThat(result, is(expectedResult));
	}
	
	@Test
	public void numbersGreaterContains9990WillBeNotDropped() {
		StringCalculator sut = new StringCalculator();
		String anyStringWithLinebreak = "1000,999\n500";
		int expectedResult = 2499;
		int result = sut.calculate(anyStringWithLinebreak);
		assertThat(result, is(expectedResult));
	}
}


