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
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>>result=new ArrayList<>();
		if(root==null){
			return result;
		}
		Queue<TreeNode>queue1=new LinkedList<>();
		queue1.offer(root);
		while (!queue1.isEmpty()){
			List<Integer>temp=new ArrayList<>();
			Queue<TreeNode>queue2=new LinkedList<>();
			for(TreeNode child:queue1){
				if(child.left!=null){
					queue2.offer(child.left);
				}
				if(child.right!=null){
					queue2.offer(child.right);
				}
				temp.add(child.val);
			}
			result.add(temp);
			queue1=queue2;
		}
		return result;
	}

}
