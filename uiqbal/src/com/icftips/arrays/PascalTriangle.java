
import java.util.ArrayList;
import java.util.Collections;

public class PascalTriangle {
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> result = pascalTriangle(5);

        for (ArrayList<Integer> r: result){
            System.out.println(r);
        }
    }

    public static ArrayList<ArrayList<Integer>> pascalTriangle(int numRows){
        if(numRows <= 0) return new ArrayList(Collections.EMPTY_LIST);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>(numRows);

        ArrayList<Integer> row = new ArrayList<>(1);
        row.add(1);
        result.add(row);

        for( int i=1;i < numRows ;i++){
            row = new ArrayList<>(i+1);
            for(int j=0;j < i+1;j++){
                if(j==0){
                    row.add(1);
                }else{
                    int prev = result.get(i-1).get(j-1);
                    int next = (j<i? result.get(i-1).get(j) :0);
                    row.add(prev+next);
                }
            }
            result.add(row);
        }
        return result;
    }
}
