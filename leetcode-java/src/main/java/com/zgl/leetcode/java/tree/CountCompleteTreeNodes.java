package com.zgl.leetcode.java.tree;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2019/12/2 下午4:46
 */
public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		Integer[] nums = {1,2,3,4,5,6,7,8};
		TreeNode treeNode = TreeNodeUtil.createBinaryTreeByArray(nums, 0);
		System.out.println(new CountCompleteTreeNodes().countNodes(treeNode));
	}

	/**
	 * 222.Count Complete Tree Nodes
	 * Given a complete binary tree, count the number of nodes.
	 *
	 * Note:
	 *
	 * Definition of a complete binary tree from Wikipedia:
	 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
	 * It can have between 1 and 2h nodes inclusive at the last level h.
	 *
	 * Example:
	 *
	 * Input:
	 *     1
	 *    / \
	 *   2   3
	 *  / \  /
	 * 4  5 6
	 *
	 * Output: 6
	 */
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		//如果左右子树高度相等,则说明左子树是满二叉树,反正,右子树是满二叉树
		if (leftHeight ==  rightHeight) {
			return (1 << leftHeight) + countNodes(root.right);
		} else {
			return (1 << rightHeight) + countNodes(root.left);
		}
	}

	private int height(TreeNode root) {
		return root == null ? 0 : 1 + height(root.left);
	}
}