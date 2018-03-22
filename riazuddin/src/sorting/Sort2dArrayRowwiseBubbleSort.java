package sorting;

public class Sort2dArrayRowwiseBubbleSort {

	public static void main(String[] args) {
		int m[][] = { 	{ 9, 8, 7, 1 },
		                { 7, 3, 0, 2 },
		                { 9, 5, 3, 2 },
		                { 6, 3, 1, 2 } };
		
		sort(m);
		print(m);
	}
	
	static void sort(int m[][]) {
		for(int i = 0; i<m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				for(int k = 0; k < m[i].length - j -1; k++) {
					if(m[i][k] > m[i][k + 1]) {
						int t = m[i][k];
						m[i][k] = m[i][k+1];
						m[i][k+1] = t;
					}
				}
			}
		}
	}
	
	static void print(int m[][]) {
		for(int i = 0; i<m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]+"  ");
			}
			System.out.println();
		}
	}
}
