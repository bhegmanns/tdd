package de.hegmanns.tdd.task04;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;

public class AddMashineTest {

	@Test
	public void sumAfterAddingOneNumberResultInSumTheSameNumbertest() {
		AddMashine addMashine = new AddMashine(0L);
		long anyNumber = 2L;
		addMashine.add(anyNumber);
		
		assertThat(addMashine.getSum(), is(anyNumber));
	}
	
	@Test
	public void averageAfterAddingOneNumberResultInAverageTheSameNumbertest() {
		AddMashine addMashine = new AddMashine(0L);
		addMashine.add(2L);
		
		assertThat(addMashine.getAverage(), 
				comparesEqualTo(new BigDecimal("2.0")));
	}
	
	@Test
	public void initalValuueIsSameAsInputTest() {
		long anyInput = 1000;
		AddMashine sut = new AddMashine(anyInput);
		assertThat(sut.getSum(),is(anyInput));
	}
	
	@Test
	public void addTest() {
	    AddMashine sut = new AddMashine(1L);
	    sut.add(1L);
	    sut.add(2L);
	    
	    assertThat(sut.getSum(), is(4L));
	}
	
	@Test
	public void addNumberest(){
		long anyInput = 1000;
		long expectedSum = 2000;
		AddMashine sut = new AddMashine(anyInput);
		
		sut.add(anyInput);
		assertThat(sut.getSum(),is(expectedSum));
	}
	@Test
	public void TenSubOneIsNineTest() {
		long initalInput = 10L;
		long anotherInput = 1L;
		long expectedResult = 9L;
		AddMashine sut = new AddMashine(initalInput);
		
		sut.sub(anotherInput);
		
		assertThat(sut.getSum(),is(expectedResult));
	}
	
	@Test
	public void addNullExpectedNullPointerException() {
		AddMashine sut = new AddMashine(0L);
		
		try {
		sut.add(null);
		throw new RuntimeException("An exception is expected");
		}catch(NullPointerException e) {
			
		}
	}
	
	@Test
	public void initalNumberIsNotZeroAverageTest() {
		long initalInput = 10L;
		long anotherInput = 2L;
		long expectedResult = 2L;
		AddMashine sut = new AddMashine(initalInput);
		sut.add(anotherInput);
		assertThat(sut.getAverage(),comparesEqualTo(new BigDecimal("12.0")));
	}
}
