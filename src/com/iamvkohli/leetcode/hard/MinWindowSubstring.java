package com.iamvkohli.leetcode.hard;

import java.util.HashMap;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/902/

public class MinWindowSubstring {

	public int sumValues(HashMap<Character, Integer> hm) {
		int result = 0;
		for (int i : hm.values()) {
			result += i;
		}
		return result;
	}
	
	public boolean allFound(HashMap<Character, Integer> hm) {
		for (int i : hm.values()) {
			if(i>0) return false;
		}
		return true;
	}

	public String minWindow(String s, String t) {
        int n = s.length();
        int start =0;
        int end = 0;
        String result="";
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c:t.toCharArray()){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        
        int tCount=t.length();
        int curCount = 0;
        boolean allFound = false;
        
        char c;
        for(int i=0; i<n; i++){
            c = s.charAt(i);
            if(!hm.containsKey(c)) continue;
            
            
            if(curCount==0){
                start=i;
                curCount++;
            }
            if(curCount>= tCount) {
            	if(allFound) {
            		end = i;
            		result = s.substring(start, end);
            	}
            }
            
            
            hm.put(c, hm.get(c)-1);
            
            
        }
        return result;
    }
	
	public static void main(String[] args) {
		MinWindowSubstring mws = new MinWindowSubstring();
		String s1 = mws.minWindow("aabbacab", "abc");
		System.out.println(s1);
	}
}