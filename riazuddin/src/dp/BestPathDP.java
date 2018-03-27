package dp;
/*
 * Given 2d m *n matrix, find the max path to reach from 0,0 to m,n. Each cell contains an integer value.
 * You can only go right or down.
 */
public class BestPathDP {

	public static void main(String[] args) {
		int[][] m = {{3, 2, 6, 9},
					{1, 2, 4, 5},
					{3, 9, 0, 5},
					{8, 2, 4, 7}};
		System.out.println(bestPath(m));
	}
	
	static int bestPath(int[][] m) {
		int[][] dp = new int[m.length][m[0].length];
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = m[i][j];
				} else if(i == 0) {
					dp[i][j] = dp[i][j-1] + m[i][j];
				} else if(j == 0) {
					dp[i][j] = dp[i-1][j] + m[i][j];
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + m[i][j];
				}
			}
		}
		
		int i = m.length - 1, j = m[0].length - 1;
		System.out.println("Max path (reverse): ");
		while(i >= 0 && j >= 0) {
			System.out.print(m[i][j]+" ");
			
			if(i == 0 || dp[i][j-1] > dp[i-1][j])
				j--;
			else
				i--;
		}

		return dp[m.length - 1][m[0].length - 1];
	}
}
