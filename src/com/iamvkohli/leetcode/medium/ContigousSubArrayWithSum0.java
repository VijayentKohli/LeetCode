package com.iamvkohli.leetcode.medium;

import java.util.Arrays;

public class ContigousSubArrayWithSum0 {

    public static int findMaxLength(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
        System.out.println();
        arr[nums.length] = -1;
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
        System.out.println();
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
        	System.out.println();
            count = count + (nums[i] == 0 ? -1 : 1);
            System.out.println("i="+i+"\tcount="+count+"\tcount+nums.length="+(count+nums.length)+"\tval"+arr[count + nums.length]);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }
            Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
            System.out.println();
        }
        return maxlen;
    }
    
    public static void main(String[] args) {
		int[] arr1 = {0,0,0,0,1,0,1,1,1,1};
		System.out.println(findMaxLength(arr1));
	}
}

