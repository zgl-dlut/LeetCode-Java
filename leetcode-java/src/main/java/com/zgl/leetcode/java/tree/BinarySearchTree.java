package com.zgl.leetcode.java.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zgl
 * @date 2019/5/8 下午1:57
 */
public class BinarySearchTree {

	/**
	 * 98. Validate Binary Search Tree
	 *
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 *
	 * Assume a BST is defined as follows:
	 *
	 * The left subtree of a node contains only nodes with keys less than the node's key.
	 * The right subtree of a node contains only nodes with keys greater than the node's key.
	 * Both the left and right subtrees must also be binary search trees.
	 *
	 *
	 * Example 1:
	 *
	 *     2
	 *    / \
	 *   1   3
	 *
	 * Input: [2,1,3]
	 * Output: true
	 * Example 2:
	 *
	 *     5
	 *    / \
	 *   1   4
	 *      / \
	 *     3   6
	 *
	 * Input: [5,1,4,null,null,3,6]
	 * Output: false
	 * Explanation: The root node's value is 5 but its right child's value is 4.
	 */
	public boolean isValidBST(TreeNode root) {
		List<Integer> inOrder = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.empty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.empty()) {
				TreeNode top = stack.pop();
				inOrder.add(top.val);
				root = top.right;
			}
		}
		for (int i = 1; i < inOrder.size(); i++) {
			if (inOrder.get(i) <= inOrder.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 99. Recover Binary Search Tree
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 *
	 * Recover the tree without changing its structure.
	 *
	 * Example 1:
	 *
	 * Input: [1,3,null,null,2]
	 *
	 *    1
	 *   /
	 *  3
	 *   \
	 *    2
	 *
	 * Output: [3,1,null,null,2]
	 *
	 *    3
	 *   /
	 *  1
	 *   \
	 *    2
	 * Example 2:
	 *
	 * Input: [3,1,4,null,null,2]
	 *
	 *   3
	 *  / \
	 * 1   4
	 *    /
	 *   2
	 *
	 * Output: [2,1,4,null,null,3]
	 *
	 *   2
	 *  / \
	 * 1   4
	 *    /
	 *   3
	 */
	public void recoverTree(TreeNode root) {
		List<Integer> inOrder = new ArrayList<>();
		List<TreeNode> nodeList = new ArrayList<>();
		inOrder(root, inOrder, nodeList);
		inOrder.sort((a, b) -> a - b);
		for (int i = 0; i < nodeList.size(); i++){
			nodeList.get(i).val = inOrder.get(i);
		}
	}
	private void inOrder(TreeNode root, List<Integer> inOrder, List<TreeNode> nodeList){
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.empty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.empty()) {
				TreeNode top = stack.pop();
				inOrder.add(top.val);
				nodeList.add(top);
				root = top.right;
			}
		}
	}
}