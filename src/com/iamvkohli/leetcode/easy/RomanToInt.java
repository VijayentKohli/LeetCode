package com.iamvkohli.leetcode.easy;

import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class RomanToInt {
	
	static HashMap<String, Integer> hm = new HashMap<>();
	
	public static void populateMap() {
		hm.put( "I",1);
		hm.put( "V",5);
		hm.put( "X",10);
		hm.put( "L",50);
		hm.put( "C",100);
		hm.put( "D",500);
		hm.put( "M",1000);
		
		hm.put( "IV",4);
		hm.put( "IX",9);
		hm.put( "XL",40);
		hm.put( "XC",90);
		hm.put( "CD",400);
		hm.put( "CM",900);
	}
	

	
	public static int convert(String s){
		if(s == null || s.length()==0)
			return 0;
		
		populateMap();
		char[] sArr = s.toCharArray();
		char toAdd = 0;
		int result=0;
		for(int i=0;i<s.length(); i++) {
			if( (i<(s.length()-1))  && hm.containsKey(String.valueOf(sArr[i])+sArr[i+1])) {
				result += hm.get(String.valueOf(sArr[i])+sArr[i+1]);
				++i;
			}else {
				result += hm.get(String.valueOf(sArr[i]));
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		String s1 = "MCMXCIV";
		String s2 = "CIV";
		
		System.out.println(convert(s2));

	}
}
