package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2019/9/5 下午1:39
 */
public class PartitionList {

	/**
	 * 86. Partition List
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	 *
	 * You should preserve the original relative order of the nodes in each of the two partitions.
	 * 给一个链表，将小于值x的结点放到所有大于等于值x的结点的前面，不要改变结点之间的顺序
	 * Example:
	 *
	 * Input: head = 1->4->3->2->5->2, x = 3
	 * Output: 1->2->2->4->3->5
	 */
	public ListNode partition1(ListNode head, int x) {
		//小于x的分一组,大于等于x的分一组,最后合并
		ListNode less = new ListNode(0);
		ListNode lHead = less;
		ListNode more = new ListNode(0);
		ListNode mHead = more;
		while (head != null) {
			if (head.val < x) {
				lHead.next = head;
				lHead = lHead.next;
			} else {
				mHead.next = head;
				mHead = mHead.next;
			}
			head = head.next;
		}
		lHead.next = more.next;
		mHead.next = null;
		return less.next;
	}

	public ListNode partition(ListNode head, int x) {
		//找到第一个大于等于x的节点,然后依次插入
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode pre = newHead;
		ListNode first = null, cur = head;
		while (cur != null) {
			if (cur.val >= x && first == null) {
				first = pre;
			}
			if (cur.val < x && first != null) {
				//注意拼接
				pre.next = pre.next.next;
				cur.next = first.next;
				first.next = cur;
				first = first.next;
			}
			pre = cur;
			cur = cur.next;
		}
		return newHead.next;
	}
}