package com.zgl.leetcode.java.tree;

/**
 * @author zgl
 * @date 2019/5/20 下午2:54
 */
public class InvertBinaryTree {

	/**
	 * 226. Invert Binary Tree
	 * Invert a binary tree.
	 *
	 * Example:
	 *
	 * Input:
	 *
	 *      4
	 *    /   \
	 *   2     7
	 *  / \   / \
	 * 1   3 6   9
	 * Output:
	 *
	 *      4
	 *    /   \
	 *   7     2
	 *  / \   / \
	 * 9   6 3   1
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}