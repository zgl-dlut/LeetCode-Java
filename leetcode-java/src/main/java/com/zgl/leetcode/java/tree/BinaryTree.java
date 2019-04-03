package com.zgl.leetcode.java.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zgl
 * @date 2019/1/15 上午11:12
 */
public class BinaryTree {

	/**
	 * 二叉树高度
	 */
	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left = height(root.left);
			int right = height(root.right);
			return (left < right) ? (right + 1) : (left + 1);
		}
	}

	/**
	 * 节点个数
	 */
	public int size(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + size(root.left) + size(root.right);
		}
	}

	/**
	 * 返回双亲节点
	 */
	public TreeNode parent(TreeNode root, TreeNode element) {
		if (root == null) {
			return null;
		}
		if (root.left == element || root.right == element) {
			return root;
		}
		TreeNode tag;
		if ((tag = parent(root.left, element)) != null) {
			return tag;
		} else {
			return parent(root.right, element);
		}
	}

	/**
	 * 删除根为subTree的子树
	 */
	public void destroy(TreeNode subTree) {
		if (subTree != null) {
			destroy(subTree.left);
			destroy(subTree.right);
			subTree = null;
		}
	}

	/**
	 * 访问某个节点
	 */
	public void visit(TreeNode element) {
		System.out.println(element.val);
		System.out.println("  ");
	}

	/**
	 * 先序递归遍历
	 */
	public void preOrder(TreeNode root) {
		if (root != null) {
			visit(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void preOrder1(TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
		while(root!=null||!stack.empty()){
			while (root!=null){
				visit(root);
				stack.push(root);
				root=root.left;
			}if(!stack.empty()){
				TreeNode top=stack.pop();
				root=top.right;
			}
		}
	}

	/**
	 * 中序递归遍历
	 */
	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			visit(root);
			inOrder(root.right);
		}
	}

	public void inOrder1(TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
		while(root!=null||!stack.empty()){
			while (root!=null){
				stack.push(root);
				root=root.left;
			}if (!stack.empty()){
				TreeNode top=stack.pop();
				visit(top);
				root=root.right;
			}
		}
	}
	/**
	 * 后序递归遍历
	 */
	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			visit(root);
		}
	}
	public void postOrder1(TreeNode root){
		Stack<TreeNode>stack1=new Stack<>();
		Stack<TreeNode>stack2=new Stack<>();
		while(root!=null||!stack1.empty()){
			while (root!=null){
				stack1.push(root);
				stack2.push(root);
				root=root.right;
			}if(!stack1.empty()){
				TreeNode top=stack1.pop();
				root=top.left;
			}
		}
		while (!stack2.empty()){
			TreeNode top=stack1.pop();
			visit(top);
		}
	}
	public void postOrder2(TreeNode root){
		Stack<TreeNode>stack=new Stack<>();
		TreeNode pre=null;
		stack.push(root);
		while(!stack.empty()){
			root=stack.peek();
			if((root.left==null&&root.right==null)||(pre!=null&&(root.left==pre||root.right==pre))){
				TreeNode top=stack.pop();
				visit(top);
				pre=top;
			}else {
				if(root.right!=null){
					stack.push(root.right);
				}
				if(root.left!=null){
					stack.push(root.left);
				}
			}
		}
	}

	/**
	 * 层次遍历
	 */
	public void levelOrder(TreeNode root){
		Queue<TreeNode>queue=new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			TreeNode top=queue.poll();
			visit(top);
			if(root.left!=null){
				queue.offer(root.left);
			}
			if(root.right!=null){
				queue.offer(root.right);
			}
		}
	}
}
