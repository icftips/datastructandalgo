package dp;

/*
 * https://algorithms.tutorialhorizon.com/dynamic-programming-coin-in-a-line-game-problem/
 */
public class CoinPlayOptimalStrategyDP {
	public static void main(String[] args) {
		int[] coins = {8, 15, 3, 7};
		System.out.println(move(coins));
	}
	
	static int move(int[] coins) {
		int[][] dp = new int[coins.length][coins.length];
		
		for (int interval = 0; interval < dp.length; interval++) {
			for (int i = 0, j = interval; j < dp.length; i++, j++) {
				// Alice chooses i and Bob chooses i+1,
				//		then Alice chooses a = MV(i+2,j)
				// Alice chooses i , Bob chooses j OR Alice chooses j , Bob chooses i
				//		then Alice chooses b = MV(i+1,j-1)
				// Alice chooses j , Bob chooses j-1
				//		then Alice chooses c = MV(i,j-2)
				int a = (i + 2 <= j)?dp[i+2][j]:0, b = (i + 1 <= j - 1)?dp[i+1][j-1]:0, c = (i <= j - 2)?dp[i][j-2]:0;
				
				dp[i][j] = Math.max(coins[i] + Math.min(a, b), coins[j] + Math.min(b, c));
				
			}
		}
		
		return dp[0][coins.length - 1];
	}
}
