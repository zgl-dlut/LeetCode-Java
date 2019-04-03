package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2018/12/5 下午4:26
 */
public class SwapNodeInPairs {
	/**
	 * 24. Swap Nodes in Pairs
	 *
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 *
	 * Example:
	 *
	 * Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * Note:
	 *
	 * Your algorithm should use only constant extra space.
	 * You may not modify the values in the list's nodes, only nodes itself may be changed.
	 */
	public ListNode swapPairs(ListNode head){
		ListNode newHead=new ListNode(0);
		newHead.next=head;
		ListNode pre=newHead;
		ListNode post;
		while(head!=null&&head.next!=null){
			post=head.next.next;
			head.next.next=head;
			pre.next=head.next;
			head.next=post;
			pre=head;
			head=post;
		}
		return newHead.next;
	}
}
