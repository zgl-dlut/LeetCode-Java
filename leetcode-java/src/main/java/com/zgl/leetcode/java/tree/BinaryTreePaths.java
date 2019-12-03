package com.zgl.leetcode.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/12/2 下午9:17
 */
public class BinaryTreePaths {
	public static void main(String[] args) {
		Integer[] nums = {1,2,3,null,5};
		TreeNode root = TreeNodeUtil.createBinaryTreeByArray(nums, 0);
		System.out.println(new BinaryTreePaths().binaryTreePaths(root));
	}

	/**
	 * 257. Binary Tree Paths
	 * Given a binary tree, return all root-to-leaf paths.
	 *
	 * Note: A leaf is a node with no children.
	 *
	 * Example:
	 *
	 * Input:
	 *
	 *    1
	 *  /   \
	 * 2     3
	 *  \
	 *   5
	 *
	 * Output: ["1->2->5", "1->3"]
	 *
	 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		dfs(root, root.val + "", result);
		return result;
	}

	private void dfs(TreeNode root, String path, List<String> result) {
		if (root.left == null && root.right == null) {
			result.add(path);
		}
		if (root.left != null) {
			dfs(root.left, path + "->" + root.left.val, result);
		}
		if (root.right != null) {
			dfs(root.right, path + "->" + root.right.val, result);
		}
	}
}