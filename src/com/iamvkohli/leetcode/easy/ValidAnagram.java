package com.iamvkohli.leetcode.easy;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		int sLen = s.length();
		int tLen = t.length();
		
		int [] frequencyArray = new int[26];
		char c;
		
		for(int i=0;i< sLen;i++) {
			c = s.charAt(i);
			frequencyArray[ c - 97 ]++;
		}
		
		for(int i=0;i< tLen;i++) {
			c = t.charAt(i);
			
			if(frequencyArray[ c - 97 ] == 0) {
				return false;
			}
			
			frequencyArray[ c - 97 ]--;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		String s = "anqasgram", t = "nagsarqam";
		
		System.out.println(isAnagram(s,t));
		System.out.println(isAnagram("a","b"));
		
	}
}
