package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2019/9/5 下午4:04
 */
public class ReorderList {
	public static void main(String[] args) {
		ListNode listNode1=new ListNode(1);
		ListNode listNode2=new ListNode(2);
		ListNode listNode3=new ListNode(3);
		ListNode listNode4=new ListNode(4);
		ListNode listNode5=new ListNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		new ReorderList().reorderList(listNode1);
	}

	/**
	 * 143. Reorder List
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	 *
	 * You may not modify the values in the list's nodes, only nodes itself may be changed.
	 *
	 * Example 1:
	 *
	 * Given 1->2->3->4, reorder it to 1->4->2->3.
	 * Example 2:
	 *
	 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode slow = head, fast = head, pre = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode right;
		//fast == null 偶数个节点
		if (fast == null) {
			pre.next = null;
			right = reverseList(slow);

		} else {
			right = reverseList(slow.next);
			slow.next = null;
		}
		ListNode cur = head;
		while (right != null) {
			ListNode temp = cur.next;
			cur.next = right;
			right = right.next;
			cur.next.next = temp;
			cur = temp;
		}
	}

	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}

	private void printVal(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}