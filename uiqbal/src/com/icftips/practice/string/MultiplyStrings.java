
package com.icftips.practice.string;

/**
 *
 * @author Umair Iqbal
 */

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("99","99"));
    }
    
    static String multiply(String a, String b){
        if(a==null||b==null||a.isEmpty()||b.isEmpty())
            return "";
        int[] result=new int[a.length()+b.length()];
        
        for(int i=a.length()-1;i>=0;i--){
            char ie = (char)(a.charAt(i)-'0');
            for(int j=b.length()-1;j>=0;j--){
                char je = (char)(a.charAt(j)-'0');
                
                int prod = ie*je + result[i+j+1];
                result[i+j+1]=(prod)%10;
                result[i+j]+=(prod )/10;
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
            result[i] = (char)(result[i]+'0');
            str.append((char)result[i]);
        }
        return str.toString();
    }

}

