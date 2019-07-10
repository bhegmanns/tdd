package de.hegmanns.tdd.stringconverter;

import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {

	public int calculate(String string) {
		// TODO Auto-generated method stub
		int res = 0;
		if (string.equals("")) {
			return 0;
		}
		else 
		{
			ArrayList<String> addedElement = new ArrayList<>();
			
			String[] strarr = string.split(",");
			
			for (String element : strarr) {
				String[] restArray = element.split("\n");
				addedElement.addAll(Arrays.asList(restArray));
			}
			
			for(String str:addedElement)
			{
				int parsedInteger = Integer.parseInt(str);
				if (parsedInteger < 0) {
					throw new NumberFormatException("negative numbers are bad numbers");
				}
			res += parsedInteger;
		    }
			return res;
		}
		
	}

}
