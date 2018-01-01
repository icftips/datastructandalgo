package com.icftips.strings;

import java.util.HashMap;

public class StringDialpadProblem {

	private static HashMap<Character, char[]> dialpad = null;

	private static void initializeDialpad() {
		dialpad = new HashMap<>();
		dialpad.put('1', new char[0]);
		dialpad.put('2', new char[] { 'A', 'B', 'C' });
		dialpad.put('3', new char[] { 'D', 'E', 'F' });
		dialpad.put('4', new char[] { 'G', 'H', 'I' });
		dialpad.put('5', new char[] { 'J', 'K', 'L' });
		dialpad.put('6', new char[] { 'M', 'N', 'O' });
		dialpad.put('7', new char[] { 'P', 'Q', 'R', 'S' });
		dialpad.put('8', new char[] { 'T', 'U', 'V' });
		dialpad.put('9', new char[] { 'W', 'X', 'Y', 'Z' });
		dialpad.put('0', new char[0]);
	}

	private static char[] getNumberChars(char number) {
		return dialpad.get(number);
	}
	
	private static void printDialpad(String prefix, String str) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			char[] chars = getNumberChars(str.charAt(0));
			if (chars.length > 0) {
				for (char c : chars) {
					printDialpad(prefix + c, str.substring(1));
				}
			} else {
				printDialpad(prefix, str.substring(1));
			}
		}
	}
	
	public static void printDialpad(long val) {
		printDialpad("", String.valueOf(val));
	}
	
	public static void main(String[] args) {
		initializeDialpad();
		// String input = "23";
		printDialpad(23);
		// printStrings(input, 0, "");
	}

}

