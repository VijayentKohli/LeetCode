package com.iamvkohli.leetcode.easy;

//https://leetcode.com/problems/defanging-an-ip-address/

public class DefangIPAddress {

	public static String defangIPaddr(String address) {
		if (address == null) {
			return null;
		}

		char[] input = address.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : input) {
			if (c == '.') {
				sb.append("[.]");
				continue;
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		
		String address = "255.100.50.0";
		System.out.println(defangIPaddr(address));
	}

}
