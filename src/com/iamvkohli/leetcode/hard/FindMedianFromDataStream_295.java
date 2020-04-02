package com.iamvkohli.leetcode.hard;
import java.util.*;

public class FindMedianFromDataStream_295 {


    public PriorityQueue<Integer> minHeap;
    public PriorityQueue<Integer> maxHeap;
    int size;
    /** initialize your data structure here. */
    public FindMedianFromDataStream_295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        size = 0;
    }
    
    public void addNum(int num) {
        
        if(maxHeap.size()==0){
            maxHeap.add(num);
            this.size++;
            return;
        }
        maxHeap.add(num);
        
        minHeap.add(maxHeap.remove());
        
        if(maxHeap.size()<minHeap.size()){
            maxHeap.add(minHeap.remove());
        }
//        
//        if(num>=maxHeap.peek()){
//            maxHeap.add(num);
//            if(maxHeap.size()-1 > minHeap.size()){//Transfer to minHeap
//                minHeap.add( maxHeap.remove() );
//            }
//        }else{//number is smaller then maxHeap.peek();
//            minHeap.add(num);
//            if(minHeap.size() > maxHeap.size()){
//                 maxHeap.add(minHeap.remove());
//            }
//        }
        this.size++;  
    }
    
    
    public double findMedian() {
        double result;
        if(this.size==0){
            result =  (double)0;
        }else if(this.size==1){
            result =  (double)maxHeap.peek();
        }
        else if(this.size%2==1){
            result =  (double)( minHeap.size()>maxHeap.size()?maxHeap.peek():minHeap.peek() );
        }else{
            result = (double)(minHeap.peek()+maxHeap.peek())/2;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	FindMedianFromDataStream_295 ins1 = new FindMedianFromDataStream_295();
    	ins1.addNum(-1);
    	ins1.findMedian();
    	ins1.addNum(-2);
    	ins1.findMedian();
    	ins1.addNum(-3);
    	ins1.findMedian();
    	ins1.addNum(-4);
    	ins1.findMedian();
    	ins1.addNum(-5);
    	ins1.findMedian();
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */