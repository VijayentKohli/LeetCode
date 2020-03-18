package com.iamvkohli.leetcode.explore.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle_1 {

    public static void generatePascalTriangle(int numRows, int curRow, List<List<Integer>> aList){
        
        if(numRows < curRow){
            return;
        }
 
        
        if(curRow == 1){
            aList.add( new ArrayList<Integer>(Arrays.asList(1)) );
        }else if(curRow == 2){ 
            aList.add( new ArrayList<Integer>(Arrays.asList(1,1)) );
        }else{
            ArrayList<Integer> curList = new ArrayList<Integer>();
            for(int x=0; x<curRow; x++){
                
                if(x==0 || x==curRow-1){
                    curList.add(1);
                }
                else{
                    ArrayList<Integer> prevList = (ArrayList<Integer>) aList.get(curRow-2);
                    curList.add( prevList.get(x-1)+prevList.get(x) );
                }
            }
            aList.add(curList);
        }
        
        generatePascalTriangle(numRows, curRow+1, aList);
    }
    
    public static List<List<Integer>> generate(int numRows) {
        int count= 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        generatePascalTriangle(numRows, count, result);
        
        return result;
    }
    
    public static void main(String[] args) {
    	generate(5);
	}
}