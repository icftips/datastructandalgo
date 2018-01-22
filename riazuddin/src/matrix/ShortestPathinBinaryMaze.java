package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMaze {

	public static void main(String[] args) {
		int m[][] = new int[][] { 
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
			{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
			{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

		System.out.println(shortestPath(m, 0, 0, 3, 4));
	}

	public static int shortestPath(int[][] m, int sourceRow, int sourceCol, int destRow, int destCol) {
		// track if cell is visited
		boolean[][] visited = new boolean[m.length][m[0].length];

		// rows and cols are indexes of neighbor 8 cells, to check if a cell is within
		// boundary
		int[] rows = { 1, 0, -1, 0 };
		int[] cols = { 0, 1, 0, -1 };

		Queue<Point> path = new LinkedList<>();
		// begin with source cell;
		path.add(new Point(sourceRow, sourceCol));
		visited[sourceRow][sourceCol] = true;
		int shortestPath = 0;
		while (!path.isEmpty()) {
			Point p = path.remove();
//			System.out.println("p["+p.i+"]["+p.j+"]");
			for (int i = 0; i < 4; i++) {
				int newRow = p.i + rows[i];
				int newCol = p.j + cols[i];

				if (newRow == destRow && newCol == destCol)
					return shortestPath;
				
				if (isSafe(m, newRow, newCol) && !visited[newRow][newCol]) {
//					System.out.println("m["+newRow+"]["+newCol+"] ");
					visited[newRow][newCol] = true;
					path.add(new Point(newRow, newCol));
					shortestPath++;
				}
			}
		}

		return shortestPath;
	}

	public static boolean isSafe(int[][] m, int row, int col) {
		if (row >= 0 && row < m.length && col >= 0 && col < m[0].length && m[row][col] == 1)
				return true;

		return false;
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
