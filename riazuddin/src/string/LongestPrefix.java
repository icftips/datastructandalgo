package string;
/*
 * Given strings, find the longest common prefix
 * 
 */
public class LongestPrefix {

	// Time complexity = O(n * m)
	// n = size of smallest string
	// m = size of input array
	public static void main(String[] args) {
//		String[] strings = {"apple", "ape", "april"};
		String[] strings = {"geeksforgeeks", "geeks", "geek", "geezer"};
		System.out.println(longestPrefix(strings));
	}
	
	public static String longestPrefix(String[] input) {
		String str = input[0];
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			for(int j = 1; j < input.length; j++) {
				if(i == input[j].length() || ch != input[j].charAt(i))
					return str.substring(0, j+1);
			}
		}
		
		return str;
	}
}
