package dp;
/*
 * https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 * 
 */
public class LongestCommonSubsequenceDP {

	public static void main(String[] args) {
		String s1 = "ABCDGH", s2 = "AEDFHR";

		System.out.println(lcsDP(s1, s2));
	}
	
	static int lcsDP(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		
		int[][] dp = new int[l1+1][l2+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				} else if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[l1][l2];
	}
}
