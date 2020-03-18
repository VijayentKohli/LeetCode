package com.iamvkohli.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKPairWithSmallestSums {

	/*
	 * INITAL CODE - WRONG
	 */
//	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//
//		if (k <= 0)
//			return null;
//
//		int length1 = nums1.length;
//		int length2 = nums2.length;
//		int i = 0, j = 0, min1 = 0, min2 = 0;
//		int count = 1;
//
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		List<Integer> list = new ArrayList<Integer>();
//
//		list.add(nums1[0]);
//		list.add(nums2[0]);
//
//		result.add(list);
//
//		while (i < length1 && j < length2 && count != k) {
//
//			list = new ArrayList<Integer>();
//			min1 = 0;
//			min2 = 0;
//
//			if (1 + 1 < length1) {
//				min1 = nums1[i + 1] + nums2[j];
//			}
//			if (j + 1 < length2) {
//				min2 = nums1[i] + nums2[j + 1];
//			}
//
//			if (min1 < min2) {
//				list.add(nums1[i + 1]);
//				list.add(nums2[j]);
//				i++;
//			} else {
//				list.add(nums1[i]);
//				list.add(nums2[j + 1]);
//				j++;
//			}
//
//			result.add(list);
//			count++;
//		}
//		
//		return result;
//
//	}

	/*
	 * SUBMITTED CODE - Inspired from G4G
	 */
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		if (k <= 0)
			return null;

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list;

		int length1 = nums1.length;
		int length2 = nums2.length;

		if (length1 == 0 || length2 == 0) {
			return result;
		}
		int[] index_arr = new int[length1];
		int count = 0;
		while (k > 0) {

			if (count == length1 * length2) {
				break;
			}
			int minSum = Integer.MAX_VALUE;
			int minIndex = 0;
			list = new ArrayList<Integer>();

			// Traversing all the elements of array1
			for (int i = 0; i < length1; i++) {

				if ((index_arr[i] < length2)) {
					int curSum = nums1[i] + nums2[index_arr[i]];
					if (curSum < minSum) {
						minSum = curSum;
						minIndex = i;
					}
				}

			}

			list.add(nums1[minIndex]);
			list.add(nums2[index_arr[minIndex]]);
			result.add(list);
			index_arr[minIndex]++;
			k--;
			count++;
		}

		return result;

	}

	/*
	 * BEST SOLUTION - from LeetCode
	 */
	public static List<int[]> kSmallestPairsBest(int[] nums1, int[] nums2, int k) {
		
		List<int[]> res = new ArrayList<>();
		
		//Corner Condition check
		if (nums1.length == 0 || nums2.length == 0 || k <= 0)
			return res;
		
		//If k is greater or equal to all possible solutions
		if (nums1.length <= k / nums2.length) {
			for (int n1 : nums1) {
				for (int n2 : nums2) {
					res.add(new int[] { n1, n2 });
				}
			}
			return res;
		}
		
		//Binary Search Method
		int lo = nums1[0] + nums2[0];
		int hi = nums1[nums1.length - 1] + nums2[nums2.length - 1];

		while (lo < hi) {
			int mid = lo + ((hi - lo) >> 1);
			int count = 0;
			for (int i = 0; i < nums1.length && count < k; i++) {
				System.out.println();
				System.out.println("i = "+ i);
				
				count += binarySearch(nums2, 0, nums2.length, mid - nums1[i]);
				
				System.out.println("Count = "+ count);
			}
			if (count >= k)
				hi = mid;
			else
				lo = mid + 1;
		}

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length && nums1[i] + nums2[j] < lo; j++) {
				res.add(new int[] { nums1[i], nums2[j] });
			}
		}
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length && nums1[i] + nums2[j] <= lo; j++) {
				if (nums1[i] + nums2[j] == lo) {
					res.add(new int[] { nums1[i], nums2[j] });
				}
				if (res.size() == k) {
					return res;
				}
			}
		}
		return res;
	}

	static int binarySearch(int[] nums, int left, int right, int target) {
		System.out.println("Left = "+ left+ "  Right = "+ right+ "  Target = "+ target);
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
	/*
	 * BEST SOLUTION - from LeetCode - ENDS
	 */

	public static void main(String[] args) {
//		int [] arr1 = {1,7,11};
//		int [] arr2 = {2,4,6};
//		int k1 = 3;
//		
//		kSmallestPairs(arr1, arr2, k1);
//		System.out.println(kSmallestPairs(arr1, arr2, k1));

		int[] arr3 = { 1, 1, 2 };
		int[] arr4 = { 1, 2, 3 };
		int k2 = 5;
//		System.out.println(kSmallestPairs(arr3, arr4, k2));
//		kSmallestPairs(arr3, arr4, 10);

		int[] arr31 = { 1, 2, 4, 5, 6 };
		int[] arr41 = { 3, 5, 7, 9 };
//		kSmallestPairs(arr31, arr41, 20);
		kSmallestPairsBest(arr31, arr41, 15);
//		
//		int [] arr5 = {1,2};
//		int [] arr6 = {3};
//		int k3 = 2;
//		System.out.println(kSmallestPairs(arr5, arr6, k3));
	}

}
