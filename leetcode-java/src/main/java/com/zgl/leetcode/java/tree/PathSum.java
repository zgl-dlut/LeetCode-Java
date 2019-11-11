package com.zgl.leetcode.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/5/12 下午10:47
 */
public class PathSum {

	/**
	 * 112. Path Sum
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
	 * such that adding up all the values along the path equals the given sum.
	 *
	 * Note: A leaf is a node with no children.
	 *
	 * Example:
	 *
	 * Given the below binary tree and sum = 22,
	 *
	 *       5
	 *      / \
	 *     4   8
	 *    /   / \
	 *   11  13  4
	 *  /  \      \
	 * 7    2      1
	 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return root.val == sum;
		}
		return hasPathSum(root.left, sum - root.val) ||
				hasPathSum(root.right, sum - root.val);
	}

	/**
	 * 113. Path Sum II
	 *
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	 *
	 * Note: A leaf is a node with no children.
	 *
	 * Example:
	 *
	 * Given the below binary tree and sum = 22,
	 *
	 *       5
	 *      / \
	 *     4   8
	 *    /   / \
	 *   11  13  4
	 *  /  \    / \
	 * 7    2  5   1
	 * Return:
	 *
	 * [
	 *    [5,4,11,2],
	 *    [5,8,4,5]
	 * ]
	 *
	 */
	public List<List<Integer>> pathSum1(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		List<Integer> answer = new ArrayList<>();
		dfs(root, sum, answer, result);
		return result;
	}

	private void dfs(TreeNode root, int sum, List<Integer> answer, List<List<Integer>> result) {
		if (root == null) {
			return;
		}
		answer.add(root.val);
		sum -= root.val;
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				result.add(new ArrayList<>(answer));
			}
		} else {
			dfs(root.left, sum, answer, result);
			dfs(root.right, sum, answer, result);
		}
		answer.remove(answer.size() - 1);
	}

	/**
	 * 124. Binary Tree Maximum Path Sum
	 * Given a non-empty binary tree, find the maximum path sum.
	 *
	 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
	 * The path must contain at least one node and does not need to go through the root.
	 *
	 * Example 1:
	 *
	 * Input: [1,2,3]
	 *
	 *        1
	 *       / \
	 *      2   3
	 *
	 * Output: 6
	 * Example 2:
	 *
	 * Input: [-10,9,20,null,null,15,7]
	 *
	 *    -10
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 *
	 * Output: 42
	 */
	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMax = helper(root.left);
		int rightMax = helper(root.right);
		/**
		 * 当前节点连接其父节点的最大值(只是一条路径)
		 */
		int current = Math.max(Math.max(leftMax + root.val, rightMax + root.val), root.val);
		/**
		 * 当前节点路径最大值(包括上面和以当前为根的情况)
		 */
		int sum = Math.max(current, leftMax + rightMax + root.val);
		max = Math.max(sum, max);
		/**
		 * 返回一条路径的最大值
		 */
		return current;
	}

	/**
	 * 437. Path Sum III
	 * You are given a binary tree in which each node contains an integer value.
	 *
	 * Find the number of paths that sum to a given value.
	 *
	 * The path does not need to start or end at the root or a leaf,
	 * but it must go downwards (traveling only from parent nodes to child nodes).
	 *
	 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
	 *
	 * Example:
	 *
	 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
	 *
	 *       10
	 *      /  \
	 *     5   -3
	 *    / \    \
	 *   3   2   11
	 *  / \   \
	 * 3  -2   1
	 *
	 * Return 3. The paths that sum to 8 are:
	 *
	 * 1.  5 -> 3
	 * 2.  5 -> 2 -> 1
	 * 3. -3 -> 11
	 */
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		return pathSum(root.left, sum) + pathSum(root.right, sum) + dfs(root, sum);
	}
	private int dfs(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		int result = 0;
		if (root.val == sum) {
			result += 1;
		}
		result = result + dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
		return result;
	}
}