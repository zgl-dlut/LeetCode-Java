package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2019/9/10 上午10:19
 */
public class ListNodeUtil {

	public static ListNode getHead() {
		ListNode listNode1=new ListNode(1);
		ListNode listNode2=new ListNode(2);
		ListNode listNode3=new ListNode(3);
		ListNode listNode4=new ListNode(4);
		ListNode listNode5=new ListNode(5);
		ListNode listNode6=new ListNode(5);
		ListNode listNode7=new ListNode(6);
		listNode1.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		listNode4.next=listNode5;
		return listNode1;
	}
}