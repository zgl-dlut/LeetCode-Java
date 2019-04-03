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
}
