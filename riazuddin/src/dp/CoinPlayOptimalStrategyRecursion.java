package dp;
/*
 * https://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
 * https://stackoverflow.com/questions/22195300/understanding-solution-to-finding-optimal-strategy-for-game-involving-picking-po
 * https://algorithms.tutorialhorizon.com/dynamic-programming-coin-in-a-line-game-problem/
 */
public class CoinPlayOptimalStrategyRecursion {
	public static void main(String[] args) {
		int[] coins = {8, 15, 3, 7};
		System.out.println(coinPlay(coins, 0, coins.length - 1));
	}
	
	static int coinPlay(int[] coins, int start, int end) {
		if(start >= end) return 0;
		
		//if I pick start, in next move my options are 
		//		(start+1, end - 1) - if opponent picked from end
		// or 	(start + 2, end) - if he picks from start
		// Math.min because opponent will try to leave me with minimum value.
		int a = coins[start] + Math.min(coinPlay(coins, start+1, end - 1), coinPlay(coins, start+2, end));
		//if I pick end, in next move my options are 
		//		(start + 1, end - 1) - if opponent picked from start
		// or 	(start, end - 2) - if he picks from end
		int b = coins[end] + Math.min(coinPlay(coins, start+1, end - 1), coinPlay(coins, start, end - 2));
		
		return Math.max(a, b);
	}
}
