package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2019/9/10 上午10:08
 */
public class OddEven {
	public static void main(String[] args) {
		new OddEven().oddEvenList(ListNodeUtil.getHead());
	}

	/**
	 * 328. Odd Even Linked List
	 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
	 *
	 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
	 *
	 * Example 1:
	 *
	 * Input: 1->2->3->4->5->NULL
	 * Output: 1->3->5->2->4->NULL
	 * Example 2:
	 *
	 * Input: 2->1->3->5->6->4->7->NULL
	 * Output: 2->3->6->7->1->5->4->NULL
	 */
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head, cur = head.next;
		while (cur != null && cur.next != null) {
			ListNode temp = pre.next;
			pre.next = cur.next;
			cur.next = cur.next.next;
			pre.next.next = temp;
			pre = pre.next;
			cur = cur.next;
		}
		return head;
	}
}