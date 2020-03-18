package com.iamvkohli.leetcode.easy;

import com.iamvkohli.leetcode.commons.ArrayUtils;

public class MoveZeroes {

	public static void moveZeroesSolution(int[] nums) {

		for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
			if (nums[cur] != 0) {
				System.out.println("cur=" + cur);
				System.out.println("lastNonZeroFoundAt=" + lastNonZeroFoundAt);

				nums[lastNonZeroFoundAt] = nums[lastNonZeroFoundAt] ^ nums[cur];
				nums[cur] = nums[lastNonZeroFoundAt] ^ nums[cur];
				nums[lastNonZeroFoundAt] = nums[lastNonZeroFoundAt] ^ nums[cur];
				lastNonZeroFoundAt++;
			}
			ArrayUtils.printArray(nums);
		}
	}
	
	public static void main(String[] args) {
		int [] arr1 = {0,1,0,3,12};
		moveZeroesSolution(arr1);
	}
}
