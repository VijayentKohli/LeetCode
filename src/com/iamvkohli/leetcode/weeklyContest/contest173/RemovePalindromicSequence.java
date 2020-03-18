package com.iamvkohli.leetcode.weeklyContest.contest173;

import java.util.List;
import java.util.TreeMap;

//https://leetcode.com/contest/weekly-contest-173/problems/remove-palindromic-subsequences/

public class RemovePalindromicSequence {

    
    public static String longestPalSubstr(String str) { 
    	if(str.length()<=1) {
    		return str;
    	}
        int maxLength = 1; // The result (length of LPS) 
  
        int start = 0; 
        int len = str.length(); 
  
        int low, high; 
  
        // One by one consider every character as center 
        // point of even and length palindromes 
        for (int i = 1; i < len; ++i)  
        { 
            // Find the longest even length palindrome with  
            // center points as i-1 and i. 
            low = i - 1; 
            high = i; 
            while (low >= 0 && high < len 
                    && str.charAt(low) == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
  
            // Find the longest odd length palindrome with  
            // center point as i 
            low = i - 1; 
            high = i + 1; 
            while (low >= 0 && high < len 
                    && str.charAt(low) == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
        } 
  
        System.out.print("Longest palindrome substring is: "+str.substring(start,   start+maxLength)) ; 
        return str.substring(start,   start+maxLength);
    } 
    
    
    public static int removePalindromeSub(String s) {
    	if(s.length()<=1) {
    		return s.length();
    	}
        
        StringBuilder sb = new StringBuilder(s);
        int step = 0;
        
        while(sb.length() !=0){
            String largestSubstring = longestPalSubstr(sb.toString());
            sb.delete( sb.indexOf(largestSubstring), sb.indexOf(largestSubstring)+largestSubstring.length() );
            step++;
        }
       return step;
    }
    
    public static void main(String[] args) {
//    	removePalindromeSub("ababa");
//    	removePalindromeSub("abb");
//    	removePalindromeSub("baabb");
    	removePalindromeSub("bbaabaaa");
	}
}