package com.zgl.leetcode.java.tree;

import java.util.*;

/**
 * @author zgl
 * @date 2019/1/17 下午2:31
 */
public class Traversal {

	/**
	 * 144. Binary Tree Preorder Traversal
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		while (root != null || !stack.empty()) {
			while (root != null) {
				result.add(root.val);
				stack.push(root);
				root = root.left;
			}
			if (!stack.empty()) {
				TreeNode top = stack.pop();
				root = top.right;
			}
		}
		return result;
	}

	/**
	 * 94. Binary Tree Inorder Traversal
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		while (root != null || !stack.empty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.empty()) {
				TreeNode top = stack.pop();
				result.add(top.val);
				root = top.right;
			}
		}
		return result;
	}

	/**
	 * 145. Binary Tree Postorder Traversal
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		TreeNode pre = null;
		stack.push(root);
		while (!stack.empty()) {
			root = stack.peek();
			if ((root.left == null && root.right == null) || (pre != null && (root.left == pre || root.right == pre))) {
				TreeNode top = stack.pop();
				result.add(top.val);
				pre = top;
			} else {
				if (root.right != null) {
					stack.push(root.right);
				}
				if (root.left != null) {
					stack.push(root.left);
				}
			}
		}
		return result;
	}

	/**
	 * 102. Binary Tree Level Order Traversal
	 * 分层打印二叉树
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue1 = new LinkedList<>();
		queue1.offer(root);
		while (!queue1.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			Queue<TreeNode> queue2 = new LinkedList<>();
			for (TreeNode child : queue1) {
				if (child.left != null) {
					queue2.offer(child.left);
				}
				if (child.right != null) {
					queue2.offer(child.right);
				}
				temp.add(child.val);
			}
			result.add(temp);
			queue1 = queue2;
		}
		return result;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		levelRecursion(root, result, 0);

		return result;
	}

	/**
	 * 递归方法
	 */
	private void levelRecursion(TreeNode node, List<List<Integer>> result,
	                            int level) {
		if (node == null) {
			return;
		}
		/**
		 * 说明还需要添加一行
		 */
		if (result.size() < level + 1) {
			result.add(new ArrayList<>());
		}
		result.get(level).add(node.val);

		levelRecursion(node.left, result, level + 1);
		levelRecursion(node.right, result, level + 1);
	}

	/**
	 * 103. Binary Tree Zigzag Level Order Traversal
	 * For example:
	 * Given binary tree [3,9,20,null,null,15,7],
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * return its zigzag level order traversal as:
	 * [
	 *   [3],
	 *   [20,9],
	 *   [15,7]
	 * ]
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()){
			count++;
			List<Integer> temp = new ArrayList<>();
			int n = queue.size();
			for (int i = 0; i < n; i++){
				TreeNode front = queue.poll();
				temp.add(front.val);
				if (front.left != null){
					queue.offer(front.left);
				}
				if (front.right != null){
					queue.offer(front.right);
				}
			}
			if (count % 2 == 0){
				Collections.reverse(temp);
			}
			result.add(temp);
		}
		return result;
	}

	/**
	 * 107. Binary Tree Level Order Traversal II
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
	 * (ie, from left to right, level by level from leaf to root).
	 *
	 * For example:
	 * Given binary tree [3,9,20,null,null,15,7],
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * return its bottom-up level order traversal as:
	 * [
	 *   [15,7],
	 *   [9,20],
	 *   [3]
	 * ]
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null){
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int n = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < n; i++){
				TreeNode front = queue.poll();
				temp.add(front.val);
				if (front.left != null){
					queue.offer(front.left);
				}
				if (front.right != null){
					queue.offer(front.right);
				}
			}
			result.add(temp);
		}
		Collections.reverse(result);
		return result;
	}
}
