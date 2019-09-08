package com.zgl.leetcode.java.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zgl
 * @date 2019/9/8 下午2:49
 */
public class CopyRandomList {

	/**
	 * 138. Copy List with Random Pointer
	 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
	 *
	 * Return a deep copy of the list.
	 */
	public Node copyRandomList(Node head) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		//第一圈遍历时，我们可以将复制的节点插入至被复制的节点的后面。这样我们就可以通过旧节点的next值找到新节点
		while (cur != null) {
			Node temp = new Node(cur.val, null, null);
			temp.next = cur.next;
			cur.next = temp;
			cur = cur.next.next;
		}
		cur = head;
		//第二圈遍历的时候，我们可以依次更新复制节点的random指针，将其指向新的复制节点。
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		cur = head;
		Node newHead = head.next;
		Node newCur = newHead;
		//最后一圈遍历，我们调整next指针，恢复原链表和塑造新链表。
		while (cur != null) {
			cur.next = cur.next.next;
			if (newCur.next != null) {
				newCur.next = newCur.next.next;
			}
			cur = cur.next;
			newCur = newCur.next;
		}
		return newHead;
	}
	
	//map存储,key是原先的node,val是复制的node,两次遍历
	public Node copyRandomList1(Node head) {
		if (head == null) {
			return head;
		}
		Map<Node, Node> nodeMap = new HashMap<>();
		Node cur = head;
		while (cur != null) {
			nodeMap.put(cur, new Node(cur.val, null, null));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			Node temp = nodeMap.get(cur);
			temp.next = nodeMap.get(cur.next);
			temp.random = nodeMap.get(cur.random);
			cur = cur.next;
		}
		return nodeMap.get(head);
	}

	class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {
		}

		public Node(int _val, Node _next, Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	}
}