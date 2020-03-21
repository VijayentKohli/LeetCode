package com.iamvkohli.leetcode.medium;

public class CountPalindromicSubstrings {
	
	public int countSubstrings(String s) {
		int len = s.length();
		int count = 0;

		for (int mid = 0; mid <= 2 * len - 1; mid++) {

			int left = mid / 2;
			int right = left + mid % 2;

			while (left >= 0 && right < len && (s.charAt(left) == s.charAt(right))) {
				count++;
				left--;
				right++;
			}

		}
		return count;
	}
	
	public static void main(String[] args) {
		String s1 = "apppa";
		String s2 = "xxdxx";
		
		CountPalindromicSubstrings cps = new CountPalindromicSubstrings();
		System.out.println(cps.countSubstrings(s1));
		System.out.println(cps.countSubstrings(s2));
	}

}
