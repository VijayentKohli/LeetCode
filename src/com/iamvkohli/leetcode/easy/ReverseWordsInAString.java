package com.iamvkohli.leetcode.easy;

public class ReverseWordsInAString {
	
	
	public static String reverse(String str) {
//		str = "the sky is blue";
		String [] result = str.split(" ");
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=result.length-1; i>0 ; i--) {
			sb.append(result[i]+" ");
		}
		sb.append(result[0]);
		
		char [] arr =  str.toCharArray();
//		arr.length
		
		
		return sb.toString();
	}
	
    public static String reverseWords(String s) {
        if(s==null || s.length()==0)
        	return null;
        
        int strLen = s.length();
        String [] temp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        char c;
        
        for(String str : temp){

            char[] arr = str.toCharArray();
            int j = arr.length-1;
            int i=0;
            while(i<j){
                c = arr[i];
                arr[i]=arr[j];
                arr[j]=c;
                i++;
                j--;
            }
            sb.append(String.valueOf(arr)+" ");
        }
        System.out.println(sb.toString());
		return sb.toString().trim();
        
    }
	
	public static void main(String[] args) {
//		System.out.println(reverse("the sky is blue"));
		reverseWords("Anything");
		reverseWords("the sky is blue");
	}
}
