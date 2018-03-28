package dp;

import util.Matrix;
/*
 * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaxSizeSubarrayDP {
	public static void main(String[] args) {
		int[][] m = {{0, 1, 1, 1, 1, 0},
					{1, 1, 1, 1, 1, 1},
					{0, 1, 1, 1, 1, 1},
					{1, 1, 0, 1, 1, 1}};
		maxSubMatrix(m);
	}
	
	static void maxSubMatrix(int[][] m) {
		int[][] s = new int[m.length][m[0].length];
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				if(i == 0 || j == 0 || m[i][j] == 0)
					s[i][j] = m[i][j];
				else // if(m[i][j] == 1)
					s[i][j] = 1 + Math.min(s[i-1][j], Math.min(s[i][j-1], s[i-1][j-1]));
			}
		}
		
		Matrix.print(s);
		int max = 0, max_i = 0, max_j = 0;
		for(int i = 0; i < s.length; i++) {
			for(int j = 0; j < s[0].length; j++) {
				if(s[i][j] > max) {
					max = s[i][j];
					max_i = i; max_j = j;
				}
			}
		}
		System.out.println();
		for(int i = max_i; i > max_i - max; i--) {
			for(int j = max_j; j > max_j - max; j--) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
}
