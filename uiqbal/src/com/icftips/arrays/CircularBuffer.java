
package com.icftips.arrays



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircularBuffer {

    private final Integer[] buffer;
    private int read =0;
    private int write=0;

    public CircularBuffer(int capacity){
        this.buffer = new Integer[capacity+1];
    }


    public void enqueue(Integer value){
        if( isFull()){
            throw new IllegalStateException("Queue is full");
        }
        this.buffer[this.write] = value;
        this.write = (this.write+1) % this.buffer.length;
    }

    public Integer dequeue(){
        if( hasNext()){
            throw new IllegalStateException("Queue is empty!");
        }
        Integer val = this.buffer[this.read];
        this.read = (this.read+1) % this.buffer.length;
        return val;
    }

    public boolean hasNext(){
        return this.write == this.read;
    }

    public boolean isFull(){
        return (write+1)%this.buffer.length == this.read;
    }

    public static void main(String[] args) {

        CircularBuffer cb = new CircularBuffer(3);
        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        System.out.println(cb.dequeue());
        System.out.println(cb.dequeue());
        System.out.println(cb.dequeue());
        try{
            cb.dequeue();
        }catch(IllegalStateException ise){
            System.out.println(ise.getMessage());
        }
        try {
            cb.enqueue(1);
            cb.enqueue(1);
            cb.enqueue(2);
            cb.enqueue(3);
        }catch (IllegalStateException ise){
            System.out.println(ise.getMessage());
        }
    }
}
