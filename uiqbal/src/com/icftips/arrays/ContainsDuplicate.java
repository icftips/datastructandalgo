package com.icttips.arrays;


import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] values=new int[]{1,2,3,5,4,6,7,2};
        System.out.println(containsDuplicate(values));
        System.out.println(containsDuplicate_CodeOptimized(values));


        int[] values2=new int[]{1,2,3,5,4,6,7};
        System.out.println(containsDuplicate(values2));
        System.out.println(containsDuplicate_CodeOptimized(values2));

    }

    public static boolean containsDuplicate(int [] values){
        Set<Integer> set = new HashSet<>(values.length);
        for(int value:values){
            set.add(value);
        }
        return set.size()!=values.length;
    }

    public static boolean containsDuplicate_CodeOptimized(int [] values){
        Set<Integer> set = new HashSet<>(values.length);
        for(int value:values){
            if(set.add(value) == false){
                return true;
            }
        }
        return false;
    }
}
