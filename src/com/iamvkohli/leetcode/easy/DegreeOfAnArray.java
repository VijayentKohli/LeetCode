package com.iamvkohli.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class DegreeOfAnArray {
	public static int findShortestSubArray(int[] nums) {
		//Corner checks
		if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
		
		// Find Degree
		HashMap<Integer, Integer> hm = new HashMap();
		int maxKey=nums[0];
		int degree=1;
		int value;
		for(int i:nums) {
			if(!hm.containsKey(i)) {
				hm.put(i, 1);
			}
			else {
				value = hm.get(i)+1;
				if(value > degree) {
					degree = value;
					maxKey = i;		
				}
				hm.put(i , hm.get(i)+1 );
			}
		}

		//Traverse through the hashmap
		ArrayList<Integer> list = new ArrayList<>();
		for(int x : hm.keySet()) {
			if(hm.get(x) == degree) {
				list.add(x);
			}
		}
		
		// Find shortest legnth
		int [] firstOccurence = new int[list.size()];
		int [] lastOccurence = new int[list.size()];
		
		for(int x=0; x<list.size();x++) {
			boolean flag = true;
			for(int y=0; y<nums.length; y++	) {
				if(flag && nums[y]==list.get(x)) {
					firstOccurence[x]=y;
					lastOccurence[x]=y;
					flag = false;
				}
				if(nums[y]==list.get(x)) {
					lastOccurence[x]=y;
				}
			}
		}
		
		//Find shortest length
		int shortest = nums.length;
		int curShortest = 0;
		for(int x=0; x<list.size();x++) {
			curShortest = lastOccurence[x] - firstOccurence[x];
			if(shortest > curShortest) {
				shortest = curShortest;
			}
		}
		
		
		return shortest+1;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,3,1,4,2};
		int[] nums2 = {1,2,2,3,1};
		int[] nums3 = {2,1};
		
		System.out.println(findShortestSubArray(nums1));
		System.out.println(findShortestSubArray(nums2));
		System.out.println(findShortestSubArray(nums3));
	}

}
