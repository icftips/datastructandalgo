
package com.icftips.practice.string;

import java.util.HashMap;
import java.util.Map;

/**
 *  Find the longest substring with k unique characters in a given string.
 * where k is +ve and in is not null
 * 
"aabbcc", k = 1
Max substring can be any one from {"aa" , "bb" , "cc"}.

"aabbcc", k = 2
Max substring can be any one from {"aabb" , "bbcc"}.

"aabbcc", k = 3
There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
Max is "aabbcc" with length 6.

"aaabbb", k = 3
There are only two unique characters, thus show error message. 



 */
public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        System.out.println(longesSubstringKUniqueCharacters("a", 2));
        System.out.println(longesSubstringKUniqueCharacters("aaabbcc", 2));
        System.out.println(longesSubstringKUniqueCharacters("aabbccc", 2));
        System.out.println(longesSubstringKUniqueCharacters("aaabbcc", 3));

    }

    static String longesSubstringKUniqueCharacters(String in, int k){
        
        if(! checkKElementsExists(in, k)){
            return "";
        }
        
        Map<Character,Integer> map=new HashMap();
        int start_idx=0,end_idx=0;
        int maxLen=Integer.MIN_VALUE;
        String maxString="";
        
        for(int i=0;i<in.length();i++){
            char ch=in.charAt(i);
            map.putIfAbsent(ch, 0);
            map.put(ch,map.get(ch)+1);
            end_idx++;
            
            while( isMoreKElements(map,k)){
                char sch=in.charAt(start_idx);
                map.putIfAbsent(sch, 0);
                map.put(sch, map.get(sch)-1);
                if(map.get(sch)==0){
                    map.remove(sch);
                }
                start_idx++;
            }
            
            
            if((end_idx-start_idx) > maxLen){
                
                maxString=in.substring(start_idx, end_idx);
                maxLen=(end_idx-start_idx);
            }
        }
        
                
        return maxString;
        
    }
    
    static boolean isMoreKElements(Map<Character,Integer> map, int k){
        return map.size()>k;
    }
    static boolean checkKElementsExists(String in, int k ){
        //optional validation part starts 
        int unique=0;
        int[] map=new int[26];
        for (int i=0;i<in.length();i++){
            if(map[in.charAt(i)-'a']==0){
                unique++;
            }
            map[in.charAt(i)-'a']++;
        }
        //check atleast k elements exists
        return k<=unique;
        
        // optional validation part end
    }
}
