package de.hegmanns.tdd.task11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

public class CoreListSpyTest {

	@Test
	public void exampeSpy() {
		List<String> strings = new ArrayList<>();
		
		List<String> spyStrings = Mockito.spy(strings);
		
		spyStrings.addAll(Arrays.asList("a", "b", "c"));
		spyStrings.add("d");
		spyStrings.add("d");
		
		int countElements = spyStrings.size();
		
		assertThat(countElements, is(5));
		//better:
		//assertThat(spyStrings, hasSize(5));
		
		Mockito.verify(spyStrings).size();
		Mockito.verify(spyStrings, never()).add("a");
		Mockito.verify(spyStrings, never()).add("b");
		Mockito.verify(spyStrings, times(2)).add("d");
	}
}
