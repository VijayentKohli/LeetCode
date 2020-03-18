package com.iamvkohli.leetcode.easy;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToLowerCase {
	
	
	/*
	 * MY SOLUTION 
	 */
	public static String toLowerCase(String str) {

		if (str == null) {
			return null;
		}

		// int strLen = str.length();
		// char [] c_arr = new char[strLen];
		char[] c_arr = new char[str.length()];
		char c;
		// for(int i=0; i< strLen; i++){
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			c_arr[i] = c;
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				c_arr[i] = (char) (str.charAt(i) + 32);
			}
		}
		return new String(c_arr);

	}
	
	/*
	 * BEST SOLUTION ON LEETCODE 
	 */
	class Solution {
	    public String toLowerCase(String str) {
	        return Stream.of(str).map(String::toLowerCase).collect(Collectors.joining(""));

	    }
	}

	public static void main(String[] args) {
		System.out.println(toLowerCase("Hello"));
	}
	
}