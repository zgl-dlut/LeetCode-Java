package com.zgl.leetcode.java.datastructure;

import com.zgl.leetcode.java.tree.TreeNode;
import com.zgl.leetcode.java.tree.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zgl
 * @date 2019/12/2 上午11:46
 */
public class BSTIterator {
	/**
	 * 173. Binary Search Tree Iterator
	 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
	 *
	 * Calling next() will return the next smallest number in the BST.
	 */
	private List<Integer> inorder = new ArrayList<>();

	private int size;

	private int cur;

	public BSTIterator(TreeNode root) {
		inOrder(root);
		size = inorder.size();
		cur = 0;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNodeUtil.getTreeNode();
		BSTIterator iterator = new BSTIterator(root);
	}

	/** @return the next smallest number */
	public int next() {
		return inorder.get(cur++);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return cur < size;
	}

	public static void inorder(TreeNode root, Stack<TreeNode> stack, List<Integer> inorder) {
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				TreeNode top = stack.pop();
				inorder.add(top.val);
				root = top.right;
			}
		}
	}

	private void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		inorder(root, stack, inorder);
	}
}
