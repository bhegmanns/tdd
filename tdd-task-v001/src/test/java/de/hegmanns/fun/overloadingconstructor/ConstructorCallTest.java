package de.hegmanns.fun.overloadingconstructor;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

public class ConstructorCallTest {

	public void callConstructorWithNull() {
		ConfusingClass instance = new ConfusingClass(null);
		
		assertThat(instance.getInitializedBy(), is("WHAT"));
	}
}
