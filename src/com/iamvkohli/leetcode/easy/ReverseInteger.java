package com.iamvkohli.leetcode.easy;

public class ReverseInteger {

	public static int reverse(int x) {
		int result = 0;
		int backUp = x;
		int temp = 0;
//		boolean neg = x < 0;

		int i = 0;
		while (backUp != 0) {
			backUp = backUp / 10;
			i++;
		}
		 System.out.println("i="+i);
		backUp = x;

		while (backUp != 0) {
			temp = backUp % 10;
			// Multiple temp with Math.power(10, i)
			result += (int) (temp * Math.pow(10, --i));
			backUp = backUp / 10;
		}
		
//		if (neg) {
//			return 0 - result;
//		}
		return result;
	}

	public static void main(String[] args) {
		int i1 = 1534236469;
		int i2 = -234;
		System.out.println(reverse(i1));
//		System.out.println(reverse(i2));
	}

}
