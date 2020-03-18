package com.iamvkohli.leetcode.easy;

public class NonDecreasingArray {

	public static boolean checkPossibility(int[] nums) {
        
		int length = nums.length;
		if(length < 1 )
			return true;
		
		int faultCount = 0;
		int min = nums[length-1];
		for(int i=length-1; i>=0; i-- ) {
			
			if(nums[i]< min) {
				min = nums[i];
			}
			if(nums[i] > min) {
				faultCount++;
				if(faultCount > 1) {
					return false;
				}
			}
		}
		
		return true;
		
    }
	
	
	public static void main(String[] args) {
		int [] arr = {4,2,3};
		System.out.println(checkPossibility(arr));
		int [] arr1 = {4,2,1};
		System.out.println(checkPossibility(arr1));
		int [] arr2 = {4,4,4,4,2,2,2,2,2};
		System.out.println(checkPossibility(arr2));
	}
}
