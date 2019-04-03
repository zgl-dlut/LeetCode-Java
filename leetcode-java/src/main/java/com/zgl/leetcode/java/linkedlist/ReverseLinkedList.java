package com.zgl.leetcode.java.linkedlist;

import com.zgl.leetcode.java.linkedlist.ListNode;

/**
 * @author zgl
 * @date 2018/12/2 下午1:31
 */
public class ReverseLinkedList {
	/**
	 * 206 Reverse a singly linked list.
	 * Example:
	 * Input: 1->2->3->4->5->NULL
	 * Output: 5->4->3->2->1->NULL
	 */
	public ListNode reverseList(ListNode head) {
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

	/**
	 * 92. Reverse Linked List II
	 * Reverse a linked list from position m to n. Do it in one-pass.
	 * <p>
	 * Note: 1 ≤ m ≤ n ≤ length of list.
	 * <p>
	 * Example:
	 * <p>
	 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
	 * Output: 1->4->3->2->5->NULL
	 */

	public ListNode reverseBetween(ListNode head, int m, int n){
		if(m==n){
			return head;
		}
		int tag;
		ListNode newHead=new ListNode(0);
		newHead.next=head;
		ListNode current=head;
		ListNode pre=newHead;
		for(tag=1;tag<m;tag++){
			pre=current;
			current=current.next;
		}
		ListNode temp=current;
		ListNode subHead=current;
		ListNode post;
		for(tag=m;tag<=n;tag++){
			post=current.next;
			current.next=subHead;
			subHead=current;
			current=post;
		}
		post=current;
		pre.next=subHead;
		temp.next=post;
		return newHead.next;

	}
	/**
	 * 理解错了,题意是反转m-n之间的链表,我写的是交换m和n两个节点
	 */
	public ListNode reverseBetweenWrong(ListNode head, int m, int n) {
		if(m==n){
			return head;
		}
		int tag=1;
		ListNode newHead=new ListNode(0);
		newHead.next=head;
		ListNode pre=newHead;
		ListNode current=head;
		ListNode post=head.next;

		while (tag<m){
			pre=current;
			current=post;
			post=post.next;
			tag++;
		}
		ListNode nodeM=current;
		ListNode nodeMPre=pre;
		ListNode nodeMPost=post;
		while (tag<n){
			pre=current;
			current=post;
			post=post.next;
			tag++;
		}
		ListNode nodeN=current;
		ListNode nodeNPre=pre;
		ListNode nodeNPost=post;
		nodeMPre.next=nodeN;
		nodeN.next=nodeMPost;
		nodeMPost.next=nodeNPre;
		nodeNPre.next=nodeM;
		nodeM.next=nodeNPost;
		return newHead.next;
	}
}

