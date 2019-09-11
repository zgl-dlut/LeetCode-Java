package com.zgl.leetcode.java.linkedlist;

/**
 * LeetCode 02
 *
 * @author zgl
 * @date 2018/11/25 下午3:04
 */

import java.util.Stack;

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

	/**
	 * (错误写法-转换成long型有位数限制)
	 * @param listNode
	 * @return
	 */
	public Long getIntNum(ListNode listNode){
		String s=new String();
		while(listNode!=null){
			s+=String.valueOf(listNode.val);
			listNode=listNode.next;
		}
		return Long.valueOf(s);
	}

		/*Long total=getIntNum(l1)+getIntNum(l2);
		String totalStr=String.valueOf(total);
		int[]part=new int[totalStr.length()];
		int i=0;
		while (total!=0){
			part[i]=total.intValue()%10;
			total/=10;
			i++;
		}
		ListNode result=new ListNode(part[0]);
		ListNode head=result;
		for (int j=1;j<part.length;j++){
			ListNode temp=new ListNode(part[j]);
			head.next=temp;
			head=temp;
		}
		return result;*/

	public static void main(String[] args) {
		new AddTwoNumbers().addTwoNumbers2(ListNodeUtil.getHead(), ListNodeUtil.getHead1());
	}

	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode head = result;
		/**
		 * 进位标识
		 */
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			head.next = new ListNode(sum % 10);
			head = head.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			head.next = new ListNode(carry);
		}
		return result.next;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverseList(l1);
		l2 = reverseList(l2);
		int carry = 0;
		ListNode result = new ListNode(0);
		ListNode cur = result;
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = x + y + carry;
			cur.next = new ListNode(sum % 10);
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (carry > 0) {
			cur.next = new ListNode(carry);
		}
		return reverseList(result.next);
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				s1.push(l1.val);
				l1 = l1.next;
			}
			if (l2 != null) {
				s2.push(l2.val);
				l2 = l2.next;
			}
		}
		int carry = 0;
		ListNode result = null;
		while (!s1.empty() || !s2.empty()) {
			int x = 0, y = 0;
			if (!s1.empty()) {
				x = s1.pop();
			}
			if (!s2.empty()) {
				y = s2.pop();
			}
			int sum = x + y + carry;
			carry = sum / 10;
			ListNode temp = new ListNode(sum % 10);
			temp.next = result;
			result = temp;
		}
		if (carry > 0) {
			ListNode temp = new ListNode(carry);
			temp.next = result;
			result = temp;
		}
		return result;
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
}

