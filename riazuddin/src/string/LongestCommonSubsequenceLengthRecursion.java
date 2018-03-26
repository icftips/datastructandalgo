package string;

/*
 * https://www.geeksforgeeks.org/longest-common-subsequence/
 */
public class LongestCommonSubsequenceLengthRecursion {

	public static void main(String[] args) {
		String s1 = "ABCDGH", s2 = "AEDFHR";

		System.out.println(subsequenceLength(s1, s2, s1.length() - 1, s2.length() - 1, 0));
	}

	private static int subsequenceLength(String s1, String s2, int i, int j, int tab) {
//		printSpace(tab);
//		System.out.println(i+"("+s1.charAt(i)+"), "+j+"("+s2.charAt(j)+")");
		if (i < 0 || j < 0)
			return 0;

		if (s1.charAt(i) == s2.charAt(j))
			return 1 + subsequenceLength(s1, s2, i - 1, j - 1, tab+1);

		return Math.max(subsequenceLength(s1, s2, i, j - 1, tab+1), subsequenceLength(s1, s2, i - 1, j, tab+1));
	}

	private static void printSpace(int tab) {
		for (int k = 0; k < tab; k++) {
			System.out.print(" ");
		}
	}
}