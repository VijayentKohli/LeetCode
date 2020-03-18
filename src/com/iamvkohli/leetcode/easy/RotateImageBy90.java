package com.iamvkohli.leetcode.easy;

import com.iamvkohli.leetcode.commons.ArrayUtils;

public class RotateImageBy90 {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;

        int top=0;
        int bottom=len-1;
        int left=0;
        int right=len-1;
        int count=0;
        int temp=matrix[0][0];
        for(int i=0; i<len/2; i++){
            System.out.println();
            count=0;
            while(count+i < len-1-i){
            	System.out.println("\ni="+i+"\tcount="+count);
                temp = matrix[top+count+i][right-i];
                matrix[top+count+i][right-i] = matrix[top+i][left+count+i];
                matrix[top+i][left+count+i]=matrix[bottom-count-i][left+i];
                matrix[bottom-count-i][left+i]=matrix[bottom-i][right-count-i] ;
                matrix[bottom-i][right-i-count] = temp;
                count++;
                ArrayUtils.print2DArray(matrix);
            }
            
        }
    }
    
    public static void main(String[] args) {
		int [][] arr1 = {{1,2},{4,5}};
    	int [][] arr2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
    	
    	
//    	ArrayUtils.print2DArray(arr1);
//    	rotate(arr1);
    	
    	ArrayUtils.print2DArray(arr2);
    	System.out.println("\n");
    	rotate(arr2);
    	
	}
}
