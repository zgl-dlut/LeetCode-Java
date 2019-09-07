package com.zgl.leetcode.java.linkedlist;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2018/12/6 上午10:53
 */
public class Sort {
	/**
	 * 148. Sort List
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 * <p>
	 * Example 1:
	 * <p>
	 * Input: 4->2->1->3
	 * Output: 1->2->3->4
	 * Example 2:
	 * <p>
	 * Input: -1->5->3->4->0
	 * Output: -1->0->3->4->5
	 */
	public ListNode sortListConvertToArray(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		int length = 0;
		ListNode current = head;
		while (current != null) {
			current = current.next;
			length++;
		}
		int[] nums = new int[length];
		int tag = 0;
		current = head;
		while (current != null) {
			nums[tag++] = current.val;
			current = current.next;
		}
		Arrays.sort(nums);
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		for (tag = 0; tag < length; tag++) {
			head.val = nums[tag];
			head = head.next;
		}
		return newHead.next;
	}

	/**
	 * 归并排序
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(0);
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		return mergeTwoSortedList(l1, l2);

	}

	public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode current = result;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		if (l1 != null) {
			current.next = l1;
		}
		if (l2 != null) {
			current.next = l2;
		}
		return result.next;
	}

	/**
	 * 插入排序
	 * @param head
	 * @return
	 */
	public ListNode insertSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode pre = head, cur = head.next;
		while (cur != null) {
			if (cur.val < pre.val) {
				pre.next = cur.next;
				//从头部判断
				ListNode temp1 = newHead;
				ListNode temp2 = newHead.next;
				while (cur.val >= temp2.val) {
					temp1 = temp2;
					temp2 = temp2.next;
				}

				temp1.next = cur;
				cur.next = temp2;
				cur = pre.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return newHead.next;
	}
}
