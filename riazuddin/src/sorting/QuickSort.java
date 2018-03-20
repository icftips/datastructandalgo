package sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] A = {9, 3, 10, 4, 1, 44, 12, 2, 90, 0};
        int l = 0;
        int r = A.length-1;
        QuickSort(A, l, r);
        printArray(A);
    }

	private static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++){
            System.out.print(A[i] + " ");
        }
		System.out.println();
	}

    private static void QuickSort(int[] a, int l, int r) {
        int i;
        if (r > l){
            i = partition(a, l, r);
            QuickSort(a, l, i-1);
            QuickSort(a, i+1, r);
        }
    }

    private static int partition(int[] a, int l, int r) {
        int v = a[r];
        int i = l;
        int j = r;
        int temp;
        while (i < j){
            while (a[i] < v){
                i = i + 1;
            }
            while ((i < j) && (a[j] >= v)){
                j = j - 1;
            }
            temp = a[i];
            if (i < j){
                a[i] = a[j];
                a[j] = temp;
                printArray(a);
            }else{
                a[i] = a[r];
                a[r] = temp;
                printArray(a);
            }
        }
        return i;
    }
}