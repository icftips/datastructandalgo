/**
 * 
 */
package sm.coding.algo.practice.recursion;

import java.io.Console;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author shahzad-mughal
 *
 * Calculate a sum on natural numbers up to n
 *
 */
public class SumOfNaturalNumbers {

	/**
	 * Brute force implementation using loop/iterative approach
	 * 
	 * T=O(n)
	 * S=O(n)
	 */
	public static int sum_Iterative(int n) {
		int sum = 0;
		for(int i =0;i<=n;i++) {
			sum += i;
		}
		return sum;
	}
	
	public static int sum_IterativeJava8(int n) {
		return IntStream.range(1, n+1).sum();
	}
	
	/**
	 * Brute force implementation using recursive approach
	 * 
	 * T=O(n)
	 * S=O(n)
	 */
	public static int sum_Recursive(int n) {
		if(n==0) {
			return 0;
		}else {
			return n+sum_Recursive(n-1);
		}
	}
	
	
	/**
	 * Best solution
	 * 
	 * T=O(1)
	 * S=O(1)
	 */
	public static int sum_Formula(int n) {
		return n*(n+1)/2;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please provide value of n");
		int n = scanner.nextInt();
		System.out.printf("n=%s and sum_Iterative=%d", n, sum_Iterative(n));
		System.out.println();
		System.out.printf("n=%s and sum_IterativeJava8=%d", n, sum_IterativeJava8(n));
		System.out.println();
		System.out.printf("n=%s and sum_Recursive=%d", n, sum_Recursive(n));
		System.out.println();
		System.out.printf("n=%s and sum_Formula=%d", n, sum_Formula(n));
	}

}
