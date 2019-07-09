package de.hegmanns.tdd.task01;

/**
 * 
 * @author B. Hegmanns
 *
 */
public class CheckerFunctions {

	/**
	 * prevents creating instances
	 */
	private CheckerFunctions() {
	}
	
	public static boolean isOdd(int i) {
		return !(i%2 == 0);
	}
	
}
