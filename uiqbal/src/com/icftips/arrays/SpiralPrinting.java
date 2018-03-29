
package com.icftips.arrays;

/**
 *
 * @author Umair Iqbal
 */
public class SpiralPrinting {
    public static void main(String[] args) {
        int data[][] = new int[][]{
            {1  ,2  ,3  ,4},
            {12 ,13 ,14 ,5},
            {11 ,16 ,15 ,6},
            {10 ,9  ,8  ,7},
        };
        
        print(data);
    }
    
    static void print(int data[][]){
        if(data==null || data.length==0) return;
        int t=0, l=0, r=data[0].length-1,b=data.length-1;
        
        while(l<=r && t<=b){
            for(int x=l;x<=r;x++){
                System.out.println(data[t][x]+" ");
            }t++;
            for(int x=t;x<=b;x++){
                System.out.println(data[x][r]+" ");
            }r--;
            for(int x=r;x>=l;x--){
                System.out.println(data[b][x]+" ");
            }b--;
            for(int x=b;x>=t;x--){
                System.out.println(data[x][l]+" ");
            }l++;
        }
        
    }

}
