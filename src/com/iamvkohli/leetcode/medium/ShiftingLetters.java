package com.iamvkohli.leetcode.medium;

import java.util.Arrays;

//https://leetcode.com/problems/shifting-letters/
public class ShiftingLetters {
	
	public static void main(String[] args) {
		String s1 = "abz";
		int[] a = {3,5,28};
		
		System.out.println(shiftingLetters(s1, a));
	}


    public static String shiftingLetters(String S, int[] shifts) {
        if(S== null ||S.length()==0){ return S;}
        
        int n=shifts.length;
        if(n != S.length()){
            System.out.println("Ab kya Karun");
        }
        
        int []addn = new int[n];
        addn[n-1]=shifts[n-1];
        
        char result[] = new char[n];
        // result[n-1] = (char)((S.charAt(n-1) + addn[n-1] -'a')%26);  
        
        
        for(int i=n-2; i>=0; i--){
            addn[i] = addn[i+1]+shifts[i];
            // result[i] = (char)((S.charAt(i) + addn[i] -'a')%26);  
        }
        Arrays.stream(addn).forEach(x -> System.out.print(x +" - "));
        System.out.println();
        
        for(int i=0; i<n; i++){
            int cA = (S.charAt(i)+addn[i] -'a')%26;
            cA = cA+'a';
            char c = (char) cA;
            System.out.print(c);
            result[i] = c;
        }
        return S;
    }
    
    
}