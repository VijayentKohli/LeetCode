package com.iamvkohli.leetcode.easy;

public class PlusOne {

	
    public static int[] plusOneSolution(int[] digits) {
        
        int len = digits.length;
        int carry = 0;
        for(int i=len-1; i>=0; i--){
            if( (digits[i]+1) > 9){
                if(i==0){
                    int [] result = new int[len+1];
                    result[0]=1;
                    return result;
                }

                carry = 1;
                digits[i] = 0;
                continue;
            }
            else{
                digits[i]= digits[i]+1;
                return digits;
            }
        }
        
        return digits;
    }
    
    public static void main(String[] args) {
		int [] nums = {8,9,9,9};
		
		plusOneSolution(nums);
	}
}
