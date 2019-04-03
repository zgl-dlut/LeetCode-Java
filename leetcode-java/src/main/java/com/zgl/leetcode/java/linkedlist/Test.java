package com.zgl.leetcode.java.linkedlist;

/**
 * @author zgl
 * @date 2018/12/6 上午10:56
 */
public class Test {
	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers=new AddTwoNumbers();
		ReverseLinkedList reverseLinkedList=new ReverseLinkedList();
		RemoveElements removeElements=new RemoveElements();
		SwapNodeInPairs swapNodeInPairs=new SwapNodeInPairs();
		ListNode listNode1=new ListNode(1);
		ListNode listNode2=new ListNode(2);
		ListNode listNode3=new ListNode(3);
		ListNode listNode4=new ListNode(4);
		ListNode listNode5=new ListNode(4);
		ListNode listNode6=new ListNode(5);
		ListNode listNode7=new ListNode(6);
		listNode1.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		/*listNode4.next=listNode5;
		listNode5.next=listNode6;*/
		//listNode6.next=listNode7;
		/*ListNode result=addTwoNumbers.addTwoNumbers(listNode1,listNode5);
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}*/
		//ListNode result=reverseLinkedList.reverseBetween(listNode1,2,4);
		//ListNode result=removeElements.removeElements(listNode1,6);
		ListNode result=swapNodeInPairs.swapPairs(listNode1);
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}
	}
}
