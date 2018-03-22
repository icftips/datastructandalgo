package string;

/*
 * 
 * 	Given a 2D grid of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said be found in a direction if all characters match in this direction (not in zig-zag form).

	The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up and 4 Diagonal directions.
	
	Example:
		Input: grid[][] = {"GEEKSFORGEEKS", "GEEKSQUIZGEEK", "IDEQAPRACTICE"};
		word = "GEEKS"
	
		Output: pattern found at 0, 0
		pattern found at 0, 8
		pattern found at 1, 0
	
		Input: grid[][] = {"GEEKSFORGEEKS", "GEEKSQUIZGEEK", "IDEQAPRACTICE"};
		word = "EEE"

 */
public class SearchWordIn2dArray {

	private static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		String[] input = { "GEEKSFORGEEKS", "GEEKSQUIZGEEK", "IDEQAPRACTICE" };
		// find(input, "GEEK");
		find(input, "EEE");
	}

	static void find(String[] input, String word) {
		char[][] ch = { input[0].toCharArray(), input[1].toCharArray(), input[2].toCharArray() };

		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				find(ch, i, j, word);
			}
		}
	}

	static boolean find(char[][] input, int row, int col, String word) {

		if (input[row][col] != word.charAt(0))
			return false;

		for (int i = 0; i < 8; i++) {
			int pos, r = row + x[i], c = col + y[i];
			for (pos = 1; pos < word.length(); pos++) {
				if (r < 0 || r >= input.length || c < 0 || c >= input[0].length)
					break;
				if (input[r][c] != word.charAt(pos))
					break;
				// System.out.println(word.charAt(pos)+"("+pos+") :(r) "+r+" ,(c) "+c+" ,(i)
				// "+i+" ,(row) "+row+" ,(col) "+col);
				r += x[i];
				c += y[i];
			}
			if (pos == word.length()) {
				System.out.println("Found at (" + row + ", " + col + ") to (" + (r - x[i]) + " ," + (c - y[i]) + ")");
				return true;
			}
		}

		return false;
	}

}
