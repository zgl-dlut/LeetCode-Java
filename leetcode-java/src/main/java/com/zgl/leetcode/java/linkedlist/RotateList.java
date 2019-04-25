package com.zgl.leetcode.java.linkedlist;

import java.util.List;

/**
 * @author zgl
 * @date 2019/4/25 下午2:55
 */
public class RotateList {

	/**
	 * 61. Rotate List
	 * <p>
	 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
	 * <p>
	 * Example 1:
	 * <p>
	 * Input: 1->2->3->4->5->NULL, k = 2
	 * Output: 4->5->1->2->3->NULL
	 * Explanation:
	 * rotate 1 steps to the right: 5->1->2->3->4->NULL
	 * rotate 2 steps to the right: 4->5->1->2->3->NULL
	 * Example 2:
	 * <p>
	 * Input: 0->1->2->NULL, k = 4
	 * Output: 2->0->1->NULL
	 * Explanation:
	 * rotate 1 steps to the right: 2->0->1->NULL
	 * rotate 2 steps to the right: 1->2->0->NULL
	 * rotate 3 steps to the right: 0->1->2->NULL
	 * rotate 4 steps to the right: 2->0->1->NULL
	 */
	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode last = null;
		ListNode first = head;
		int length = 0, tag = 0;
		while (head != null) {
			last = head;
			head = head.next;
			length++;
		}
		k %= length;
		head = first;
		while (head != null) {
			if (++tag == length - k) {
				break;
			}
			head = head.next;
		}
		last.next = first;
		first = head.next;
		head.next = null;
		return first;
	}

}