package arrays;
/*
 * https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 * 
 */
public class SearchWordIn2dArrayBoggleSolver {

	private static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		String[] dict = {"QUIZ", "GEEKS", "FOR", "RIAZ"};
		char[][] m = {{'G', 'I', 'Z', 'F'}, {'U', 'E', 'K', 'O'}, {'Q', 'S', 'E', 'R'}};
		
		for (int d = 0; d < dict.length; d++) {
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[0].length; j++) {
					boolean[][] visited = new boolean[m.length][m[0].length];
					if(find(m, i, j, dict[d], 0, visited))
						System.out.println("Found "+dict[d]);
				}
			}
		}
	}
	
	static boolean find(char[][] m, int row, int col, String word, int idx, boolean[][] visited) {
//		System.out.println("row: "+row+",col: "+col+", word: "+word+", idx: "+idx+", "+m[row][col]);
		if(idx+1 == word.length())
			return true;
		
		if (m[row][col] != word.charAt(idx))
			return false;
		
		visited[row][col] = true;
		for(int i = 0; i < 8; i++) {
			int r = row + x[i], c = col + y[i];
			if(r < 0 || r >= m.length || c < 0 || c >= m[0].length || visited[r][c] || m[r][c] != word.charAt(idx+1))
				continue;

			return find(m, r, c, word, idx+1, visited);
		}
		
		return false;
	}
}
