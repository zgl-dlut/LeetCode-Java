package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2019/5/21 上午11:05
 */
public class PalindromeLinkedList {

	/**
	 * 234. Palindrome Linked List
	 * Given a singly linked list, determine if it is a palindrome.
	 *
	 * Example 1:
	 *
	 * Input: 1->2
	 * Output: false
	 * Example 2:
	 *
	 * Input: 1->2->2->1
	 * Output: true
	 * Follow up:
	 * Could you do it in O(n) time and O(1) space?
	 */
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		/**
		 * fast == null偶数个节点
		 */
		ListNode rightSide = fast != null ? reverse(slow.next) : reverse(slow);
		while (rightSide != null) {
			if (rightSide.val == head.val) {
				rightSide = rightSide.next;
				head = head.next;
			} else {
				return false;
			}
		}
		return true;
	}

	private ListNode reverse(ListNode head) {
		ListNode newHead = null;
		ListNode temp;
		while (head != null) {
			temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}
}