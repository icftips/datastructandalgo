/**
 * 
 */
package sm.code.ds.recursion.classwork;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Bonus Question: Palindromic Decomposition A “Palindromic Decomposition” of string S, 
 * is a decomposition of the string into substrings, such that all those substrings are valid palindromes. 
 * A single character is considered a valid palindrome for this problem. 
 * Print out all possible palindromic decompositions of a given string. 
 * 
 * e.g. 
 * Input: abracadabra 
 * Output: 
 * a|b|r|a|c|a|d|a|b|r|a| 
 * a|b|r|a|c|ada|b|r|a| 
 * a|b|r|aca|d|a|b|r|a|
 * 
 * 
 * @author smughal
 *
 */
public class PalindromicDecomposition {
	
	public static List<String> pd(String input) {
		List<String> result = new ArrayList<>();
		pdHelper(input, new ArrayList<>(), result);
		return result;
	}

	
	public static void pdHelper(String input, List<String> choosen, List<String> result) {
		if(input.length()==0) {
			System.out.println(choosen);
			result.add(choosen.toString());
		}
		for(int i = 1; i<=input.length(); i++) {
			String ch = input.substring(0, i);
			if(isPalindrome(ch)) {
				choosen.add(ch);
				pdHelper(input.substring(i, input.length()), choosen, result);
				choosen.remove(choosen.size()-1);
			}
		}
		
	}
	
	
	/**
	 * Some how not working !!! but logic is correct
	 * @param str
	 * @param index
	 * @param result
	 */
	public static void pd_CW(String str, int index, List<String> result) {
		System.out.println("'"+str+"', '"+index+"', "+result);
		if(index>=str.length()) {
			System.out.println(result);
		}
		
		for(int end = index+1; end<=str.length(); end++) {
			String sub = str.substring(index,  end);
			if(isPalindrome(sub)) {
				result.add(sub);
				pd_CW(str, index+1, result);
				result.remove(result.size()-1);
			}
		}
	}
	
	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		return s.equals(sb.reverse().toString());
	}
	
	public static void main(String[] args) {
		List<String> result;
//		result = pd("apple");
//		result = DebugSolution.pd("abba");
//		System.out.println("result="+result);
		
		
//		result = pd("abba");
		result = DebugSolution.pd("abba");
		System.out.println("result="+result);

	}
	
}

class DebugSolution {
	static String indent = "";
	
	public static void debug(Object msg) {
		System.out.println("DEBUG "+indent+msg);
	}
	
	public static List<String> pd(String input) {
		List<String> result = new ArrayList<>();
		pdHelper(input, new ArrayList<>(), result);
		return result;
	}

	
	public static void pdHelper(String input, List<String> choosen, List<String> result) {
		debug("input=["+input+"], choosen="+choosen);
		if(input.length()==0) {
			debug(choosen);
			result.add(choosen.toString());
		}
		for(int i = 1; i<=input.length(); i++) {
			String ch = input.substring(0, i);
			if(PalindromicDecomposition.isPalindrome(ch)) {
				debug("ch="+ch+" -- Y");
				choosen.add(ch);
				String indentActual = indent;
				indent = indent+"\t";
				pdHelper(input.substring(i, input.length()), choosen, result);
				choosen.remove(choosen.size()-1);
				indent = indentActual;
			}
			debug("ch="+ch+" -- N");
		}
		
	}
	
}
