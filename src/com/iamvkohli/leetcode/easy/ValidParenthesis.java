package com.iamvkohli.leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
	public static boolean isValid(String s) {
		if(s==null || s.length()==0)
			return false;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(char c: s.toCharArray()) {
			if(c=='(' || c=='{' || c=='[') {
				stack.push(c);
			}
			else if(c==')') {
				// || c=='}' || c==']') {
				if(!stack.isEmpty() && stack.peek()==('(')) {
					stack.pop();
				}
				else
					return false;
			}
			else if(c=='}') {
				// || c=='}' || c==']') {
				if(!stack.isEmpty() && stack.peek()==('{')) {
					stack.pop();
				}
				else
					return false;
			}
			else if(c==']') {
				// || c=='}' || c==']') {
				if(!stack.isEmpty() && stack.peek()==('[')) {
					stack.pop();
				}
				else
					return false;
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		
		return false;
				
	}
	
	
	public static void main(String[] args) {
		String input1 = "lets () h[ave a { drink }]";
		String input2 = "lets () h[{{ave a { drink }]";
		String input3 = "lets () h[ave a ]{ drink }]";
		String input4 = "lets )( h[ave a { drink }]";
//		
//		System.out.println(isValid(input1));
//		System.out.println(isValid(input2));
		System.out.println(isValid(input3));
		System.out.println(isValid(input4));
		isValid(input2);
		isValid(input3);
		isValid(input4);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
	}
}
