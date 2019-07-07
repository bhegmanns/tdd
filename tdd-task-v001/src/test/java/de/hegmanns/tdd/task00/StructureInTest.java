package de.hegmanns.tdd.task00;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class StructureInTest {

	@Test
	public void aTest() {
		//given
		List<String> anyList = new ArrayList<>();
		
		//when
		anyList.add("A");
		
		//then
		assertThat(anyList.size(), is(1));
		assertThat(anyList, hasSize(1)); // that is better readable ...
	}
	
	/**
	 * Adding the same object more than one time, a set would not add this object again.
	 * (1) Put in the comments (given, when, then).
	 * (2) write the rest code
	 */
	@Test
	public void checkFunctionOfASet() {
		Set<String> anySet = new HashSet<>();
		
	}
}
