package string;

import java.util.HashMap;
import java.util.Map;

//Given string and pattern find min. length string that matches the pattern
//or, find smallest window in string containing all characters in another string

public class MinWindowSubstring {
	
	public static void main(String[] args) {
		String input = "this is a test string", pattern = "ttis";
		System.out.println(findMinLengthSubstring(input, pattern));
	}

	public static String findMinLengthSubstring(String input, String pattern) {
		
		Map<Character, Integer> patternMap = new HashMap<>();
		//Count characters in pattern
		for(int i = 0; i<pattern.length(); i++) {
			Character c = pattern.charAt(i);
			if(patternMap.containsKey(c))
				patternMap.put(c, patternMap.get(c) + 1);
			else
				patternMap.put(c, 1);
		}
		
		int patternSize = pattern.length();
		
		Map<Character, Integer> windowMap = new HashMap<>();
		
		//count chars in input until all chars in pattern are found, i.e. windowMap.size() == patternMap.size()
		int lowIdx = 0, endIdx = 0, highIdx = 0, count = 0, minLength = Integer.MAX_VALUE;
		while(highIdx < input.length()) {
			Character initCh = input.charAt(lowIdx);
			Character c = input.charAt(highIdx);
			
			updateWindowChars(patternMap, windowMap, c);
			
			highIdx++;
			if(patternMap.containsKey(c))
				endIdx = highIdx;
			
			System.out.println(patternMap);
			System.out.println(windowMap);
			if(count < patternSize && patternMap.containsKey(c) && windowMap.get(c) <= patternMap.get(c))
				count++;
			
			if(count == patternSize) {
				while(!patternMap.containsKey(initCh) || windowMap.get(initCh) > patternMap.get(initCh)) {
					if(windowMap.containsKey(initCh) && windowMap.get(initCh) > patternMap.get(initCh)) {
						windowMap.put(initCh, windowMap.get(initCh) - 1);
					}
					initCh = input.charAt(++lowIdx);
				}
				if(minLength > (endIdx - lowIdx + 1))
					minLength = endIdx - lowIdx + 1;
			}
		}
		
		return input.substring(lowIdx, endIdx);
	}

	private static void updateWindowChars(Map<Character, Integer> patternMap, Map<Character, Integer> windowMap,
			Character c) {
		if(patternMap.containsKey(c)) {
			if(windowMap.containsKey(c))
				windowMap.put(c, windowMap.get(c) + 1);
			else
				windowMap.put(c, 1);
		}
	}
}
