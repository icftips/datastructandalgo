
package com.icftips.sortinghw;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import javafx.util.Pair;

/**
 *
 * @author Umair Iqbal
 */
public class Sorted2DArrayToSingleArray {
    PriorityQueue<Pair<Integer,ArrayIterator>> queue;
    Comparator<Pair<Integer,ArrayIterator>> comparator=(a,b)->a.getKey()-b.getKey();
    int size;
    
    public Sorted2DArrayToSingleArray(Integer[][] data){
        init(data);
    }
    
    private void init(Integer[][] data){
        queue = new PriorityQueue<>(data.length, comparator);
        for(Integer []array : data){
            ArrayIterator iter=new ArrayIterator(array);
            if(iter.hasNext()){
                queue.add(new Pair<>(iter.next(),iter));
            }
            size+=array.length;
        }
    }
    
    public Integer[] sort(){
        Integer[] result = new Integer[size];
        int counter=0;
        while(!queue.isEmpty()){
            Pair<Integer,ArrayIterator> item = queue.poll();
            result[counter]=item.getKey();
            counter++;
            if(item.getValue().hasNext()){
                queue.add(new Pair(item.getValue().next(),item.getValue()));
            }
        }
        
        return result;
    }
    
    
    public static void main(String args[]){
        Integer data[][]=new Integer[][]{
            {1,4,8,12},
            {2,5,9},
            {10,11,13}
        };
        
        
        Integer[] array=new Sorted2DArrayToSingleArray(data).sort();
        for(Integer i:array){
            System.out.println(i);
        }
    }
     
}
class ArrayIterator implements Iterator<Integer>{
    
    Integer[] data;
    int index=0;
    
    public ArrayIterator(Integer[] data) {
        this.data = data;
    }
    

    @Override
    public boolean hasNext() {
        return index < this.data.length;

    }

    @Override
    public Integer next() {
        return this.data[index++];
    }
    
}
