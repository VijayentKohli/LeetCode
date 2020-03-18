package com.iamvkohli.leetcode.medium;

public class CompareVersionNumbers {

	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i = 0, j = 0;

		while (i < v1.length && j < v2.length) {
			int i1 = Integer.parseInt(v1[i]);
			while (i < v1.length && i1 == 0) {
				i++;
				if (i == v1.length) {
					break;
				}
				i1 = Integer.parseInt(v1[i]);
			}

			int i2 = Integer.parseInt(v2[j]);
			while (j < v2.length && i2 == 0) {
				j++;
				if (j== v2.length) {
					break;
				}
				i2 = Integer.parseInt(v2[j]);
			}

//			System.out.println("S1 = " + v1[i] + "\tS2=" + v1[i]);

			if (i1 > i2) {
				return 1;
			}
			if (i1 < i2) {
				return -1;
			}
			i++;
			j++;
		}

		if (j == v2.length && i == v1.length) {
			return 0;
		}
		if (j == v2.length)
			return 1;
		if (i == v1.length)
			return -1;

		return 0;
	}

	public static void main(String[] args) {
//		System.out.println("RESULT "+compareVersion("0.1", "1.1"));
//		System.out.println("RESULT "+compareVersion("1.0.1", "1"));
//		System.out.println("RESULT "+compareVersion("1.1.1", "1.1.2"));
//		System.out.println("RESULT "+compareVersion("1.01", "1.001"));
		System.out.println("RESULT " + compareVersion("0.1", "0.0.1"));

	}
}