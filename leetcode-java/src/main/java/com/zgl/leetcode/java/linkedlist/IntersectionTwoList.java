package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2018/12/16 下午3:35
 */
public class IntersectionTwoList {
	/**
	 * 160. Intersection of Two Linked Lists
	 *
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int length = getLength(headA) - getLength(headB);
		int tag = 1;
		if (length > 0) {
			while (tag <= length) {
				headA = headA.next;
				tag++;
			}
		} else {
			while (tag <= -length) {
				headB = headB.next;
				tag++;
			}
		}
		ListNode result = null;
		while (headA != null & headB != null) {
			if (headA != headB) {
				headA = headA.next;
				headB = headB.next;
			} else {
				result = headA;
				while (headA != null && headA == headB) {
					headA = headA.next;
					headB = headB.next;
				}
			}
		}
		return result;

	}

	public int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	/**
	 * 设 A 的长度为 a + c， B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
	 * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；
	 * 同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNodeCircle(ListNode headA, ListNode headB) {
		ListNode tempA=headA;
		ListNode tempB=headB;
		while (tempA!=tempB){
			if(tempA==null){
				tempA=headB;
			}else {
				tempA=tempA.next;
			}
			if(tempB==null){
				tempB=headA;
			}else {
				tempB=tempB.next;
			}
		}
		return tempA;
	}

}
