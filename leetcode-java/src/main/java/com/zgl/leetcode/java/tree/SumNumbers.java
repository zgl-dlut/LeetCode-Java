package com.zgl.leetcode.java.tree;

import java.util.Stack;

/**
 * @author zgl
 * @date 2019/5/14 下午1:37
 */
public class SumNumbers {
	/**
	 * 129. Sum Root to Leaf Numbers
	 *
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	 *
	 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
	 *
	 * Find the total sum of all root-to-leaf numbers.
	 *
	 * Note: A leaf is a node with no children.
	 *
	 * Example:
	 *
	 * Input: [1,2,3]
	 *     1
	 *    / \
	 *   2   3
	 * Output: 25
	 * Explanation:
	 * The root-to-leaf path 1->2 represents the number 12.
	 * The root-to-leaf path 1->3 represents the number 13.
	 * Therefore, sum = 12 + 13 = 25.
	 * Example 2:
	 *
	 * Input: [4,9,0,5,1]
	 *     4
	 *    / \
	 *   9   0
	 *  / \
	 * 5   1
	 * Output: 1026
	 * Explanation:
	 * The root-to-leaf path 4->9->5 represents the number 495.
	 * The root-to-leaf path 4->9->1 represents the number 491.
	 * The root-to-leaf path 4->0 represents the number 40.
	 * Therefore, sum = 495 + 491 + 40 = 1026.
	 */
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helperDfs(root, 0);
	}

	private int helperDfs(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		}
		return helperDfs(root.left, sum) + helperDfs(root.right, sum);
	}

	public int sumNumbers1(TreeNode root) {
		int result = 0;
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode top = stack.pop();
			if (top.left == null && top.right == null) {
				result += top.val;
			}
			if (top.left != null) {
				top.left.val += top.val * 10;
				stack.push(top.left);
			}
			if (top.right != null) {
				top.right.val += top.val * 10;
				stack.push(top.right);
			}
		}
		return result;
	}
}