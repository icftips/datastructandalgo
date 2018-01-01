package com.icftips.strings;

public class StringCombination {
		
	public static void main(String[] args) {
		printStringCombinations("123");
	}
	
	/**
	 * This method with print all possible combinations of given string
	 * @param str
	 */
	public static void printStringCombinations(String str) {
		printStringCombinations("", str);
	}
	
	private static void printStringCombinations(String prefix, String str) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				printStringCombinations(prefix + str.charAt(i), 
											str.substring(0, i) + str.substring(i+1, str.length()));
			}

		}
	}
}

