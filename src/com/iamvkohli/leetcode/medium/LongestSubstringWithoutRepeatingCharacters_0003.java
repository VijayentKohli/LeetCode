package com.iamvkohli.leetcode.medium;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters_0003 {

	public static int lengthOfLongestSubstring(String s) {
        
        int l = s.length();
        if(l<=1) return l;
        
        int result = 0;
        //Map to store char and last know index
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for(int left=0, right=0; right<l; right++){
            char c = s.charAt(right);
            if(hm.containsKey(c)){
                /*  Update left - Max of 1. and 2.
                * 1. next of prev occurence of repetitive char i.e hm.get(c)
                * 2. current position of start pointer
                */
                left = Math.max(hm.get(c)+1, left);
            }
            hm.put(c, right);
            
            //Update result
            result = Math.max(result, right-left+1);
        }
        return result;
	}
	
	 public static void main(String[] args) {
		String s1 = "abcabcd";
		lengthOfLongestSubstring(s1);
	}

}
