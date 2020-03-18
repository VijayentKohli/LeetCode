package com.iamvkohli.leetcode.easy;

public class ImplementStrStr {

	/*
	 * MY SOLUTION - STARTS
	 */
	public static  int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return 0;
		}

		int h_Length = haystack.length();
		int n_Length = needle.length();

		if (needle.length() >= haystack.length()) {
			return -1;
		}

		if (haystack.compareTo(needle) == 0) {
			return 0;
		}

		int j=0;
		int resultIndex = -1;
		for (int i = 1; i <= h_Length - n_Length; i++) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				if (haystack.substring(i, i + n_Length).compareTo(needle) == 0)
					resultIndex = i;
			}
		}

		return resultIndex;
	}
	/*
	 * MY SOLUTION - ENDS
	 */
	
	
	
	public static void main(String[] args) {
		String str1 = "Hellp";
		String str2 = "lel";
		
		System.out.println(strStr(str1, str2));
	}

}
