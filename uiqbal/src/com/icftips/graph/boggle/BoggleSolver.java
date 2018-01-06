
package com.icftips.graph.boggle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Umair Iqbal
 */
public class BoggleSolver {
    
    static Set<String> dict = new HashSet<>();
    
    

    public static List<String> boggleSolver(Character[][] adjMat) {
        List<String> result = new ArrayList<>();
        boolean isvisited[][]=new boolean[adjMat.length][adjMat[0].length];
        for(int r=0;r<adjMat.length;r++ ){
            for(int c=0;c<adjMat.length;c++ ){
                StringBuilder prefix= new StringBuilder();
                boggleSolverUtil(adjMat,isvisited, r,c,prefix,result);
            }
        }
        return result;       
    }
    public static void boggleSolverUtil(Character[][] adjMat,boolean isvisited[][], int r,int c, StringBuilder prefix, List<String> result){
        isvisited[r][c]=true;
        prefix.append(adjMat[r][c]);
        if(dict.contains(prefix.toString())){
            result.add(prefix.toString());
        }
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i!=0&& j!=0){
                    int nr = r+i;
                    int nc = c+j;
                    if(isValidRow(adjMat,nr,nc) && ! isvisited[nr][nc]){
                        boggleSolverUtil(adjMat, isvisited, nr, nc, prefix, result);
                    }
                }
            }
        }
        //back track
        prefix.deleteCharAt(prefix.length()-1);
        isvisited[r][c]=false;
    }
    
    public static boolean isValidRow(Character[][] adjMat,int nr,int nc){
        return (nr>=0 && nr < adjMat.length && nc >=0 && nc <adjMat[nr].length);
    }
}
