
package com.icftips.practice.string;

/**
 *
 * @author yh04661
 */
public class JudgeRoute {
    
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD") );
        System.out.println(judgeCircle("LL") );
    }
    static boolean judgeCircle(String moves) {
        int h=0;
        int v=0;
        for(int i=0;i<moves.length();i++){
            switch(moves.charAt(i)){
                case 'U':
                    v++;
                    break;
                case 'D':
                    v--;
                    break;
                case 'L':
                    h--;
                    break;
                case 'R':
                    h++;
                    break;
                default:
            }
        }
        return h==0 && v==0;
    }
}
