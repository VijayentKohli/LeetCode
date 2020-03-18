package com.iamvkohli.leetcode.easy;

import com.iamvkohli.leetcode.commons.ArrayUtils;

public class MinCostClimbingStairs {

	public static int minCostClimbingStairs(int[] cost) {

		int length = cost.length;
//		int[] dp = new int[length];

		int n1 = 0;
		int n2 = 0;
//
//		for (int i = length - 1; i >= 0; i--) {
//			dp[i] = cost[i] + Math.min(n1, n2);
//			n2=n1;
//			n1=dp[i];
//		}
//		ArrayUtils.printArray(dp);
//		
		n1 = 0;
		n2 = 0;
		int[] dp2 = new int[length];
		for (int i =0; i < length; i++) {
			dp2[i] = cost[i] + Math.min(n1, n2);
			n2=n1;
			n1=dp2[i];
		}
		ArrayUtils.printArray(dp2);
		System.out.println(  Math.min( dp2[length-1], dp2[length-2])   );
		

		 int f1 = 0, f2 = 0;
		 
		  for (int i = cost.length - 1; i >= 0; --i) {
	            int f0 = cost[i] + Math.min(f1, f2);
	            f2 = f1;
	            f1 = f0;
	        }
		  System.out.println(Math.min(f2, f1));
		  
		  return 0;

	}

	public static void main(String[] args) {
		int[] cost1 = { 10, 15, 20 ,3};
		int[] cost2 = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		int[] cost3 = { 0, 0, 1 ,1};
		int[] cost4 = { 0, 1, 1 ,0};

//		System.out.println(minCostClimbingStairs(cost3));
		System.out.println(minCostClimbingStairs(cost4));
	}
}
