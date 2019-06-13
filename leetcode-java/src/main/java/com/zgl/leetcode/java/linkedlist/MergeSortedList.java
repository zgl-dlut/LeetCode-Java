package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2018/11/25 下午7:46
 */

import java.util.PriorityQueue;

/**
 * 21. Merge Two Sorted Lists
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeSortedList {
	public static void main(String[] args) {
		int start = 0, end = 4;
		while (start < end) {
			int mid = (start + end - 1) / 2;
			System.out.println(start + " " + mid);
			end = mid;
			System.out.println(end);
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode head = result;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		if (l1 != null) {
			head.next = l1;
		}
		if (l2 != null) {
			head.next = l2;
		}
		return result.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		int start = 0, end = lists.length - 1;
		while (start < end) {
			int mid = (start + end - 1) / 2;
			for (int i = 0; i <= mid; i++) {
				lists[i] = mergeTwoLists(lists[i], lists[end - i]);
			}
			end = (start + end) / 2;
		}
		return lists[0];
	}

	public ListNode mergeKLists1(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((listNode1, listNode2) -> listNode1.val - listNode2.val);
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				minHeap.offer(lists[i]);
			}
		}
		ListNode result = new ListNode(0), current = result;
		while (!minHeap.isEmpty()) {
			ListNode temp = minHeap.poll();
			current.next = temp;
			current = temp;
			if (temp.next != null) {
				minHeap.offer(temp.next);
			}
		}
		return result.next;
	}
}

