package de.hegmanns.fun.overloadingconstructor;

public class ConfusingClass {

	private String initializedBy;
	
	public ConfusingClass(Object o) {
		this.initializedBy = "Object";
	}
	
	public ConfusingClass(double[] array) {
		this.initializedBy = "Array";
	}
	
	public String getInitializedBy() {
		return this.initializedBy;
	}
}
