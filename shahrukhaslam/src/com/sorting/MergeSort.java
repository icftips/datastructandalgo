package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int array[] = {15,	30,	20,	54,	85, 10,	46,	5,	13,	26};
		System.out.println(Arrays.toString(mergeSort(array)));
	}
	
	public static int[] mergeSort(int array[]) {
		if(array.length < 2)
			return array;
		
		int mid = array.length/2;
		int left[] = mergeSort(Arrays.copyOfRange(array, 0, mid));
		int right[] = mergeSort(Arrays.copyOfRange(array, mid, array.length));
		return merge(left, right, array);
	}
	
	public static int[] merge(int left[], int right[], int target[]) {
		int aL = left.length;
		int rL = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i<aL && j<rL) {
			if(left[i] < right[j]) {
				target[k] = left[i];
				i++;
			}
			else if(left[i] > right[j]) {
				target[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i<aL) {
			target[k] = left[i];
			i++;
			k++;
		}
		while(j<rL) {
			target[k] = right[j];
			j++;
			k++;
		}
		
		return target;
	}

}
