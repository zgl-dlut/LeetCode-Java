package com.zgl.leetcode.java.tree;

import java.util.Stack;

/**
 * @author zgl
 * @date 2019/5/14 下午2:22
 */
public class FlattenBinaryTree {

	/**
	 * 114. Flatten Binary Tree to Linked List
	 *
	 * Given a binary tree, flatten it to a linked list in-place.
	 *
	 * For example, given the following tree:
	 *
	 *     1
	 *    / \
	 *   2   5
	 *  / \   \
	 * 3   4   6
	 * The flattened tree should look like:
	 *
	 * 1
	 *  \
	 *   2
	 *    \
	 *     3
	 *      \
	 *       4
	 *        \
	 *         5
	 *          \
	 *           6
	 */
	public void flatten1(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode top = stack.pop();
			if (top.right != null) {
				stack.push(top.right);
			}
			if (top.left != null) {
				stack.push(top.left);
			}
			if (!stack.empty()) {
				top.right = stack.peek();
			}
			top.left = null;
		}
	}

	private TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
	public void flatten2(TreeNode root) {
		if (root == null) {
			return;
		}
		while(root != null) {
			if (root.left != null) {
				TreeNode current = root.left;
				while(current.right != null) {
					current = current.right;
				}
				current.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
}