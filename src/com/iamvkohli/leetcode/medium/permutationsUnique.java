package com.iamvkohli.leetcode.medium;

//import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationsUnique {

	static List<List<Integer>> result = new ArrayList<>();

	public static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		helper(nums, new boolean[nums.length], new ArrayList<>());
		return result;
	}

	private static void helper(int[] nums, boolean[] used, List<Integer> temp) {
		if (temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || (i != 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
					continue;
				}
				used[i] = true;
				temp.add(nums[i]);
				helper(nums, used, temp);
				used[i] = false;
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums1 = {1,2,3};
		int[] nums2 = {1,2,2};
		
		result = permuteUnique(nums2);
//		result = permuteUnique(nums2);
		
	}

}
