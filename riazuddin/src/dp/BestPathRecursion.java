package dp;

import java.util.ArrayList;
import java.util.List;

/*
 * Given 2d m *n matrix, find the max path to reach from 0,0 to m,n. Each cell contains an integer value.
 * You can only go right or down.
 */
public class BestPathRecursion {
	
	public static void main(String[] args) {
		int[][] m = {{3, 2, 6, 9},
					{1, 2, 4, 5},
					{3, 9, 0, 5},
					{8, 2, 4, 7}};
		System.out.println(bestPath(m, 0, 0, m.length - 1, m[0].length - 1, new ArrayList<>()));
	}

	static int bestPath(int[][] m, int sR, int sC, int dR, int dC, List<Integer> path) {
		if(!isValid(m, sR, sC)) return 0;
		
		path.add(m[sR][sC]);
		
		if(sR == dR && sC == dC) {
			int sum = path.stream().mapToInt(Integer::intValue).sum();
			System.out.println(path+" : "+sum);
			return sum;
		}
		
		List<Integer> p1 = new ArrayList<>(), p2 = new ArrayList<>();
		p1.addAll(path); p2.addAll(path);
		return Math.max(bestPath(m, sR, sC+1, dR, dC, p1), bestPath(m, sR+1, sC, dR, dC, p2));
	}
	
	static boolean isValid(int[][] m, int r, int c) {
		if(r < 0 || r > m.length - 1 || c < 0 || c > m[0].length - 1)
			return false;
		
		return true;
	}
}
