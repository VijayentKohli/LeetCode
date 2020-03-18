package com.iamvkohli.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/jewels-and-stones/
public class JewelsAndStones {

    public static int numJewelsInStones(String J, String S) {
        if( (J == null) || (S==null))
            return 0;
        
        
        int result = 0;
        HashSet<Character> jewelSet = new HashSet<Character>();
        char[] jCharArray = J.toCharArray();
        char[] sCharArray = S.toCharArray();
        
        for (char c : jCharArray) {
        	jewelSet.add(c);
        }
        
        for (char c : sCharArray) {
        	if(jewelSet.contains(c)) {
        		result++;
        	}
        }
        
        
        return result;
    }
    
    
    /*
     * LEETCODE BEST
     */
//    public int numJewelsInStones(String J, String S) {
//        int[] j = new int[60];
//        int res = 0;
//        for (char x : S.toCharArray()) j[x-'A']++;
//        for (char x : J.toCharArray()) res+=j[x-'A'];
//        return res;
//    }
	
	public static void main (String [] args) {
		
//		String J = "aA", S = "aAAbbbb";
		String J = "a", S = "AA";
		System.out.println(numJewelsInStones(J,S));
	}
}
