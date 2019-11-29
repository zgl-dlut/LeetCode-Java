package com.zgl.leetcode.java.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zgl
 * @date 2019/11/29 下午2:53
 */
public class PopulatingNextRightPointers {
	/**
	 * 116. Populating Next Right Pointers in Each Node(满二叉树)
	 * ﻿和这个不太一样------------使每个链表的叶子节点的右指针指向下一个叶子节点。
	 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
	 */
	public Node connect1(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			root.left.next = root.right;
		}
		if (root.right != null) {
			root.right.next = root.next == null ? null : root.next.left;
		}
		connect1(root.left);
		connect1(root.right);
		return root;
	}

	public Node connect2(Node root) {
		if (root == null) {
			return root;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				Node before = queue.poll();
				before.next = size == 1 ? null : queue.peek();
				if (before.left != null) {
					queue.offer(before.left);
				}
				if (before.right != null) {
					queue.offer(before.right);
				}
				size--;
			}
		}
		return root;
	}

	/**
	 * 117. Populating Next Right Pointers in Each Node II
	 * @param root
	 * @return
	 */
	public Node connect(Node root) {
		if (root == null) {
			return root;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				Node before = queue.poll();
				before.next = size == 1 ? null : queue.peek();
				if (before.left != null) {
					queue.offer(before.left);
				}
				if (before.right != null) {
					queue.offer(before.right);
				}
				size--;
			}
		}
		return root;
	}

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
}