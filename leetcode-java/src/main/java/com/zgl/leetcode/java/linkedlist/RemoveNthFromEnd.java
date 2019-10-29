package com.zgl.leetcode.java.linkedlist;

import com.zgl.leetcode.java.linkedlist.ListNode;

/**
 * 19. Remove Nth Node From End of List
 *
 * @author zgl
 * @date 2018/12/4 下午2:15
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast=head;
		int tag=1;
		while(tag<n){
			fast=fast.next;
			tag++;
		}
		ListNode newHead=new ListNode(0);
		newHead.next=head;
		ListNode pre=newHead;
		ListNode current=head;
		ListNode post=head.next;
		while(fast!=null){
			fast=fast.next;
			if(fast!=null){
				pre=current;
				current=post;
				post=post.next;
			}
		}
		pre.next=post;
		return newHead.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.getHead();
		new RemoveNthFromEnd().removeNthFromEnd1(head, 2);
	}

	public ListNode removeNthFromEnd1(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode pre = newHead;
		int start = 1;
		while (start < n) {
			fast = fast.next;
			start++;
		}
		while (fast.next != null) {
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}
		pre.next = slow.next;
		return newHead.next;
	}
}
