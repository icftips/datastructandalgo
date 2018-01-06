package com.arrays;

import java.util.Arrays;

public class ArraySubMatrixSum {
    public static void main(String[] args) {
        
        int[][] matrix = {
                {1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4} 
                };

        printMatrix(matrix);
        
        for(int row=0; row<matrix.length; row++) {
            for(int col=1; col<matrix[0].length; col++) {
                matrix[row][col] +=  matrix[row][col-1];
            }
        }
        System.out.println("After row agg");
        printMatrix(matrix);
        
        for(int row=1; row<matrix.length; row++) {
            for(int col=0; col<matrix[0].length; col++) {
                matrix[row][col] += matrix[row-1][col];
            }
        }

        System.out.println("After row and col agg");
        printMatrix(matrix);

        printRangeSum(matrix, 2, 2, 3, 4);
        printRangeSum(matrix, 0, 0, 1, 1);
        printRangeSum(matrix, 1, 2, 3, 3);
        printRangeSum(matrix, 0, 1, 2, 2);
        
    }
    
    private static void printRangeSum(int[][] matrix, int leftRow, int leftCol, int rightRow, int rightCol) {

        int rightSum = matrix[rightRow][rightCol];
        if(leftRow > 0) {
            rightSum = rightSum - matrix[leftRow-1][rightCol];
        }
        
        int leftSum = 0;
        if(leftCol > 0) {
            leftSum = matrix[rightRow][leftCol-1];
        }
        if(leftRow > 0 && leftCol > 0) {
            leftSum = leftSum - matrix[leftRow-1][leftCol-1];
        }
        
        int sum = rightSum - leftSum;
        System.out.println("Sum for " + leftRow + "," + leftCol + " and " + rightRow + "," + rightCol + " is " + sum);
    }

    static void printMatrix(int[][] mat) {
        for(int[] ary : mat) {
            System.out.println(Arrays.toString(ary));
        }
        System.out.println();
    }
}
