package com.zgl.leetcode.java.linkedlist;

/**
 *
 * @author zgl
 * @date 2018/11/25 下午7:46
 */

import com.zgl.leetcode.java.linkedlist.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result =new ListNode(0);
		ListNode head=result;
		while (l1!=null&&l2!=null){
			if(l1.val<l2.val){
				head.next=l1;
				l1=l1.next;
			}else {
				head.next=l2;
				l2=l2.next;
			}
			head=head.next;
		}
		if(l1!=null){
			head.next=l1;
		}
		if (l2!=null){
			head.next=l2;
		}
		return result.next;
	}
}

