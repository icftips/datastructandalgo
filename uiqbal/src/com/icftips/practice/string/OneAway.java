
package com.icftips.practice.string;

/**
 *
 * @author Umair Iqbal
 */
public class OneAway {
    
    public static void main(String[] args) {
        System.out.println(oneAway("pale", "pale") == true);
        System.out.println(oneAway("pale", "ple")==true);
        System.out.println(oneAway("pales", "pale")==true);
        System.out.println(oneAway("pale", "bale")==true);
        System.out.println(oneAway("pale", "bake")==false);
        // fixed this test case 4/10
        System.out.println(oneAway("pales", "pade")==false);
        
        System.out.println(oneAway("", "")==true);
        System.out.println(oneAway("", " ")==true);
        System.out.println(oneAway(" ", "")==true);
        System.out.println(oneAway("", "  ")==false);
    }
    static boolean oneAway(String one,String two){
        int l1 = one.length();
        int l2 = two.length();
        if(Math.abs(l1-l2) > 1){
            return false;
        }
        int x=0,y=0,diff=0;
        while(diff<=1 && x<l1 && y<l2){
            if(one.charAt(x)!=two.charAt(y)){
                diff++;
                if(one.charAt(x+1)==two.charAt(y)){
                    x++;
                }else if(one.charAt(x)==two.charAt(y+1)){
                    y++;
                }
            }
            x++;y++;
            
        }
        
        return (l1-x) + (l2-y) + diff < 2;
    }
}
