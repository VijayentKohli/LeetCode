package com.iamvkohli.leetcode.easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public int lastStoneWeightSolution(int[] stones) {
		if (stones.length == 0)
			return 0;
		if (stones.length == 1)
			return stones[0];

		PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i : stones) {
			que.offer(i);
		}

		while (que.size() != 1) {
			int temp1 = que.poll();
//			
			
			if(que.isEmpty()) break;
			int temp2 = que.poll();
			
//			if(que.size()==1) {
//				break;
//			}else {
//				temp2 = que.isEmpty() ? 0 : que.poll();
//			}

			if (temp1 == temp2)
				continue;
			if (temp1 > temp2) {
				que.offer(temp1 - temp2);
			} else {
				que.offer(temp2 - temp1);
			}
		}

		if (que.size() == 1) {
			return que.poll();
		} else
			return 0;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {5,6,3,8,9};
		int[] arr2 = new int[] {4,4,2,2};
		
		LastStoneWeight lsw = new LastStoneWeight();
//		lsw.lastStoneWeightSolution(arr);
		lsw.lastStoneWeightSolution(arr2);
	}
}
