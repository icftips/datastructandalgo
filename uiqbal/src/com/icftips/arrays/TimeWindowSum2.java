package com.icftips.arrays;



public class TimeWindowSum2 {

    int[] dequeue;

    long startTime;
    int lastIndex;
    int sum=0;

    long mocktime=-1;


    TimeWindowSum2(int capacity){
        dequeue = new int[capacity+1];
        startTime=System.currentTimeMillis();
        lastIndex =-1;
    }

    public void hit(){
//        long instant = mocktime!=-1?mocktime:System.currentTimeMillis();
        long instant =System.currentTimeMillis();
        int diff = (int)(instant - startTime);
        int index =diff%dequeue.length;

        if(index != lastIndex){

            if(diff <= dequeue.length-1){
                if(lastIndex!=-1) {
                    sum =1;
                }
            }else{

                sum += 1 - this.dequeue[index];
                this.dequeue[index]=0;
            }
            lastIndex =index;
        }
        this.dequeue[index]++;
    }



    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        int current;
        for(int count=0; count < dequeue.length;count++){
            current = ( lastIndex +count)%dequeue.length;
            sb.append("(").append(current).append(" , ").append(dequeue[current]).append(") ");

        }
        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {
        TimeWindowSum2 t = new TimeWindowSum2(5);

//        t.mocktime=t.startTime;
        t.hit();
        t.hit();
        t.hit();

//        t.mocktime=t.startTime+2;
        t.hit();
        t.hit();
//        t.mocktime=t.startTime+4;
        t.hit();
//        t.mocktime=t.startTime+5;
        t.hit();

//        t.mocktime=t.startTime+6;
        t.hit();

        System.out.println(t.toString());
    }
}
