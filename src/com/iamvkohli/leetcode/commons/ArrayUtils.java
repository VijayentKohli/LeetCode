package com.iamvkohli.leetcode.commons;

public class ArrayUtils {

	public static void printArray(int [] arr) {
		for(int i:arr) {
			System.out.print(i+" --> ");
		}
		System.out.println();
	}
	
	public static void print2DArray(int [][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print( arr[i][j] + "- " );
			}
			System.out.println();
		}
	}
}
