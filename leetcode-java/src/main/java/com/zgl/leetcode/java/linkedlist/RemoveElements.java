package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2018/12/4 下午7:10
 */

public class RemoveElements {

	/**
	 * 203. Remove Linked List Elements
	 * <p>
	 * Remove all elements from a linked list of integers that have value val.
	 * <p>
	 * Example:
	 * <p>
	 * Input:  1->2->6->3->4->5->6, val = 6
	 * Output: 1->2->3->4->5
	 */
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode pre = newHead;
		while (head.next != null) {
			if (head.val == val) {
				pre.next = head.next;
			} else {
				pre = head;
			}
			head = head.next;
		}
		if (head.val == val) {
			pre.next = null;
		}
		return newHead.next;
	}
}
