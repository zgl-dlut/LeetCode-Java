package com.zgl.leetcode.java.linkedlist;

import com.zgl.leetcode.java.linkedlist.ListNode;

import java.util.*;

/**
 * @author zgl
 * @date 2018/12/3 下午3:57
 * <p>
 * 83. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class DeleteDuplicatedNode {

	/**
	 * 原题是给出排序好的链表
	 */
	public ListNode deleteDuplicates1(ListNode head) {
		Map<Integer, ListNode> map = new LinkedHashMap<>();
		while (head != null) {
			map.put(head.val, head);
			head = head.next;
		}
		ListNode newHead = new ListNode(0);
		ListNode moveHead = newHead;
		Set<Map.Entry<Integer, ListNode>> entrySet = map.entrySet();
		Iterator<Map.Entry<Integer, ListNode>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, ListNode> entry = iterator.next();
			moveHead.next = entry.getValue();
			moveHead = moveHead.next;
		}
		return newHead.next;
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

	/**
	 * 82. Remove Duplicates from Sorted List II
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	 * <p>
	 * Example 1:
	 * <p>
	 * Input: 1->2->3->3->4->4->5
	 * Output: 1->2->5
	 * Example 2:
	 * <p>
	 * Input: 1->1->1->2->3
	 * Output: 2->3
	 */
	public ListNode deleteCompleteDuplicateds(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode pre = newHead;
		ListNode middle = head;
		ListNode post = middle.next;
		boolean tag = false;
		while (middle != null && post != null) {
			if (middle.val == post.val) {
				tag = true;
				post = post.next;
				if (post == null) {
					pre.next = null;
				}
			} else {
				if (tag) {
					pre.next = post;
					tag = false;
				} else {
					pre = middle;
				}
				middle = post;
				post = post.next;
			}
		}
		return newHead.next;
	}
}
