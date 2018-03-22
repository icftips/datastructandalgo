
package com.icftips.practice.string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yh04661
 */
public class RomanToInt {
    static Map<Character,Integer> MAP=new HashMap<>();
    static{
        MAP.put('I', 1);
        MAP.put('V', 5);
        MAP.put('X', 10);
        MAP.put('L', 50);
        MAP.put('C', 100);
        MAP.put('D', 500);
        MAP.put('M', 1000);
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMIV"));
    }
    
    static int romanToInt(String input){
        int value=0;
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            int current=MAP.get(ch);
            
            //check this is the last element
            if(i+1 == input.length()){
                value+=current;
            }else{
                int nextVal=MAP.get(input.charAt(i+1));
                // checking next element if greater subtract val
                if(nextVal <= current){
                    value += current;
                }else{
                    value-=current;
                }
            }
            
        }
        return value;
    }

}
