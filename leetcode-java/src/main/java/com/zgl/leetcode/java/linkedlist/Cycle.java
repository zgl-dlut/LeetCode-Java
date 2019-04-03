package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2018/12/5 下午1:52
 */
public class Cycle {

	/**
	 * 141. Linked List Cycle
	 *
	 * Given a linked list, determine if it has a cycle in it.
	 *
	 * Follow up:
	 * Can you solve it without using extra space?
	 */
	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null||head.next.next==null){
			return false;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				return true;
			}
		}
		return false;
	}

	/**
	 * 142. Linked List Cycle II
	 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	 *
	 * Note: Do not modify the linked list.
	 *
	 * Follow up:
	 * Can you solve it without using extra space?
	 */
	public ListNode detectCycle(ListNode head) {
		if(head==null||head.next==null||head.next.next==null){
			return null;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				ListNode result=head;
				while(result!=slow){
					result=result.next;
					slow=slow.next;
				}
				return result;
			}
		}
		return null;
	}
}
