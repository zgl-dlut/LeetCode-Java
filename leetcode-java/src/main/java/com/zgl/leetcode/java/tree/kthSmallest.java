package com.zgl.leetcode.java.tree;

import java.util.Stack;

/**
 * @author zgl
 * @date 2019/12/2 下午9:04
 */
public class kthSmallest {
	public static void main(String[] args) {
		Integer[] nums = {3,1,4,null,2};
		TreeNode root = TreeNodeUtil.createBinaryTreeByArray(nums, 0);
		System.out.println(new kthSmallest().kthSmallest(root, 1));
	}

	/**
	 * 230. Kth Smallest Element in a BST
	 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
	 *
	 * Note:
	 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	 *
	 * Example 1:
	 *
	 * Input: root = [3,1,4,null,2], k = 1
	 *    3
	 *   / \
	 *  1   4
	 *   \
	 *    2
	 * Output: 1
	 * Example 2:
	 *
	 * Input: root = [5,3,6,2,4,null,null,1], k = 3
	 *        5
	 *       / \
	 *      3   6
	 *     / \
	 *    2   4
	 *   /
	 *  1
	 * Output: 3
	 */
	public int kthSmallest(TreeNode root, int k) {
		int start = 1;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				TreeNode top = stack.pop();
				if (start == k) {
					return top.val;
				}
				start++;
				root = top.right;
			}
		}
		return -1;
	}
}