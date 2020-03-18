package com.iamvkohli.leetcode.medium;

import java.util.ArrayList;

import com.iamvkohli.leetcode.commons.ListNode;

public class OddEvenLinkedList {

	public static ListNode oddEvenListSolution(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		int i = 2;
		ListNode prev = head;
		ListNode cur = head.next;
		ListNode oddPtr = head;
		ListNode temp;
		while (cur != null) {
			if (i < 3) {
				i++;
				cur = cur.next;
				prev = prev.next;
				continue;
			}

			if (i % 2 == 1) {
				temp = cur.next;
				prev.next = temp;
				cur.next = oddPtr.next;
				oddPtr.next = cur;

				cur = temp;
				while (prev.next != cur) {
					prev = prev.next;
				}
				oddPtr = oddPtr.next;
			} else {
				cur = cur.next;
				prev = prev.next;
			}
			i++;
		}
		return head;
	}

	static void printList(ListNode root) {
		while (root.next != null) {
			System.out.print(root.val + "-->");
			root = root.next;
		}
		System.out.print(root.val);
		System.out.println();
	}

	/*
	 * BEST SOLUTION
	 */
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode eventail = head;
		ListNode oddhead = head.next;
		ListNode nxt = head.next;
		while (nxt != null && eventail != null) {
			if (eventail.next != null)
				eventail.next = eventail.next.next;
			if (nxt.next != null)
				nxt.next = nxt.next.next;
			if (eventail.next != null)
				eventail = eventail.next;
			nxt = nxt.next;
		}
		eventail.next = oddhead;
		return head;
	}

	public static void main(String[] args) {
		ListNode List1 = new ListNode(1);
		ListNode List2 = new ListNode(2);
		ListNode List3 = new ListNode(3);
		ListNode List4 = new ListNode(4);
		ListNode List5 = new ListNode(5);
		ListNode List6 = new ListNode(6);
		ListNode List7 = new ListNode(7);
		ListNode List8 = new ListNode(8);
		ListNode List9 = new ListNode(9);

		List1.next = List2;
		List2.next = List3;
		List3.next = List4;
		List4.next = List5;
		List5.next = List6;
		List6.next = List7;
		List7.next = List8;
		List8.next = List9;

		printList(List1);

		oddEvenListSolution(List1);

	}
}
