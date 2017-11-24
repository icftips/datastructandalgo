import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int array[] = {15,	30,	20,	54,	85, 10,	46,	5,	13,	26};
		sort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void sort(int array[]) {
		sort(array, 0, array.length -1);
	}
	
	private static void sort(int array[], int start, int end) {
		if(start < end) {
			int partitionIndex = partition(array, start, end);
			sort(array, start, partitionIndex-1);
			sort(array, partitionIndex+1, end);
		}
	}
	
	private static int partition(int array[], int start, int end) {
		int pivot = array[end];
		int partitionIndex = start;
		
		for(int i = start; i<end-1; i++) {
			if(array[i] <= pivot ) {
				int t = array[i];
				array[i] = array[partitionIndex];
				array[partitionIndex] = t;
				partitionIndex++;
			}
		}
		
		int t = array[partitionIndex];
		array[partitionIndex] = pivot;
		array[end] = t;
		
		return partitionIndex;
	}
}
