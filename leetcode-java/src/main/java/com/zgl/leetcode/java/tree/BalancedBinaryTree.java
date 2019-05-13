package com.zgl.leetcode.java.tree;

/**
 * @author zgl
 * @date 2019/5/12 下午9:35
 */
public class BalancedBinaryTree {
	/**
	 * 110. Balanced Binary Tree
	 * Given a binary tree, determine if it is height-balanced.
	 *
	 * For this problem, a height-balanced binary tree is defined as:
	 *
	 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	 *
	 * Example 1:
	 *
	 * Given the following tree [3,9,20,null,null,15,7]:
	 *
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * Return true.
	 *
	 * Example 2:
	 *
	 * Given the following tree [1,2,2,3,3,null,null,4,4]:
	 *
	 *        1
	 *       / \
	 *      2   2
	 *     / \
	 *    3   3
	 *   / \
	 *  4   4
	 * Return false.
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null){
			return true;
		}
		return helper(root) != -1;
	}
	private int helper(TreeNode root){
		if (root == null){
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1){
			return -1;
		}else {
			return Math.max(left, right) + 1;
		}
	}
}