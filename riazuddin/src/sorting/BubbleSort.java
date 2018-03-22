package sorting;

public class BubbleSort {
	public static void main(String[] args) {
        int[] a = {9, 3, 10, 4, 1, 44, 12, 2, 90, 0};
        bubbleSort(a);
    }

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
		System.out.println();
	}
	
	private static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length - 1; j++) {
				if(a[j] > a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					System.out.println("i: "+i+", j: "+j);
					printArray(a);
				}
			}
		}
	}
}
