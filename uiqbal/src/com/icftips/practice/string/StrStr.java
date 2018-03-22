
package com.icftips.practice.string;

/**
 *
 * @author Umair Iqbal
 */
public class StrStr {
    
    public static void main(String args[]){
        System.err.println("cda Found :"+strStr("abcdab", "cba"));
        System.err.println("cba Found :"+strStr("abcdab", "cba"));
    }

    /**
     * Considering all characters are lowercase
     * @param input
     * @param pattern
     * @return 
     */
    public static boolean strStr(String input, String pattern){
        int n=input.length();
        int k=pattern.length();
        int hash=hash(pattern);
        int rhash = 0;//
        
        for(int i=0;i<n-k;i++){
           if(i==0){
               rhash = hash(input.substring(0,pattern.length()) );
           }else{
               rhash = hash - hash(input.charAt(i-1)+"") + hash(input.charAt(i+k)+"");
           }
           if(hash == rhash){
               boolean isBreak=false;
               for(int j=0;j< k;j++){
                   if(pattern.charAt(j) != input.charAt(i+j)){
                       isBreak=true;
                       break;
                   }
               }
               if(!isBreak){
                   return true;
               }
           }
        }
        return false;
    }
    
    public static int hash(String str){
        int hash=0;
        for(Character c:str.toCharArray()){
            hash+=c-'a';
        }
        return hash;
    }
}


