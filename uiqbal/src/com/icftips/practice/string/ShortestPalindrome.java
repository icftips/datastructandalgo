
package com.icftips.practice.string;

/**
 *
 * @author Umair Iqbal
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome( "ab"));
        System.out.println(shortestPalindrome( "abc"));
        System.out.println(shortestPalindrome( "abca"));
        System.out.println(shortestPalindrome( "ceca"));
        System.out.println(shortestPalindrome( "aacecaaa"));
        System.out.println(shortestPalindrome( "ijklmn"));
        
    }
    
    static int shortestPalindrome(String s){
        return shortestPalindromeUtils(s,0,s.length()-1);
        
    }
    
    static int shortestPalindromeUtils(String s, int l, int r){
        if(l>r) return Integer.MAX_VALUE;
        if(l==r) return 0;
        if(l==r-1){
            return s.charAt(r)==s.charAt(l)?0:1;
        }
        if(s.charAt(r)==s.charAt(l)){
            return shortestPalindromeUtils(s, l+1, r-1);
        }
        return 1+Math.min(shortestPalindromeUtils(s, l+1, r),shortestPalindromeUtils(s, l, r-1));
    }
}
