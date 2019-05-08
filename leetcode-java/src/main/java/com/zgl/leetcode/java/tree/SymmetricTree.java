package com.zgl.leetcode.java.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zgl
 * @date 2019/5/8 下午4:18
 */
public class SymmetricTree {

	/**
	 * 101. Symmetric Tree
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 * <p>
	 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	 * <p>
	 * 1
	 * / \
	 * 2   2
	 * / \ / \
	 * 3  4 4  3
	 * <p>
	 * <p>
	 * But the following [1,2,2,null,3,null,3] is not:
	 * <p>
	 * 1
	 * / \
	 * 2   2
	 * \   \
	 * 3    3
	 * <p>
	 * <p>
	 * Note:
	 * Bonus points if you could solve it both recursively and iteratively.
	 */
	public boolean isSymmetric1(TreeNode root) {

		/**
		 * 1- 如果两个点都是null，那么它们是相等的。返回true （这也是一种base case 表示结束了，走到树的最低端了，需要返回）
		 *
		 * 2- 如果一个点是null，另外一个不是null，那么它们不相等，返回false （ base case， 表示一边已经走到底了，需要返回）
		 *
		 * 3- 如果两个点都不是null，但是它们的值不相等， 返回false （判断条件，不相等，就返回）
		 *
		 * 4- 如果两个点相等，那么我们需要继续往下走，来判断接下去的点：
		 */
		if (root == null) {
			return true;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerFirst(root.left);
		deque.offerLast(root.right);
		TreeNode left, right;
		while (!deque.isEmpty()) {
			left = deque.pollFirst();
			right = deque.pollLast();
			if (left == null && right == null) {
				continue;
			}
			if (left == null || right == null) {
				return false;
			}
			if (left.val != right.val) {
				return false;
			}
			else {
				/**
				 * 右左左右
				 */
				deque.offerFirst(left.right);
				deque.offerFirst(left.left);
				deque.offerLast(right.left);
				deque.offerLast(right.right);
			}
		}
		return true;
	}

	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {

		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		else {
			return helper(left.left, right.right) && helper(left.right, right.left);
		}
	}
}