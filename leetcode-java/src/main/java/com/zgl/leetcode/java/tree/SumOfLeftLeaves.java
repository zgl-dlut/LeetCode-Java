package com.zgl.leetcode.java.tree;

import java.util.Stack;

/**
 * @author zgl
 * @date 2019/12/8 下午5:47
 */
public class SumOfLeftLeaves {
	public static void main(String[] args) {
		Integer[] sums = {3,9,20,null,null,15,7};
		TreeNode root = TreeNodeUtil.createBinaryTreeByArray(sums, 0);
		System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(root));
	}

	/**
	 * 404. Sum of Left Leaves
	 * Find the sum of all left leaves in a given binary tree.
	 *
	 * Example:
	 *
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 *
	 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.left.left == null && root.left.right == null) {
			return root.left.val + sumOfLeftLeaves(root.right);
		}
		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
}