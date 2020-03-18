package com.iamvkohli.leetcode.easy;

import java.util.List;
import java.util.ArrayList;

public class FindCommonChars {

	public static List<String> commonChars(String[] A) {

		if(A==null || A.length==0)
			return null;
					
		int strArrLen = A.length;
		
		List result = new ArrayList<String>();

		// 2D array to store the frequency of each String
		int[][] arr = new int[strArrLen][26];

		// Filling arr
		int row = 0;
		for (String s : A) {
			for (char c : s.toCharArray()) {
				arr[row][c - 'a']++;
			}
			row++;
		}

		boolean skipLoop;;
		int min;
		int frequency;
		
		// Solution
		for (int alphabet = 0; alphabet < 26; alphabet++) {
			min = 101;
			frequency = 0;
			skipLoop=false;
			for (int srow = 0; srow < strArrLen; srow++) {
				if (arr[srow][alphabet] == 0) {
					skipLoop = true;
					break;
				}
				if (arr[srow][alphabet] < min) {
					min = arr[srow][alphabet];
				}
				frequency = min;
			}
			if (skipLoop) {
				continue;
			}

			for (int count = 0; count < min; count++) {
				char toAdd = (char)('a' + alphabet);
				result.add( String.valueOf(toAdd) );
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String[] strA1 = {"bella","label","roller"};
		String[] strA2 = {"cool","lock","cook"};
		
		commonChars(strA1).stream().forEach(System.out::println);;
	}

}
