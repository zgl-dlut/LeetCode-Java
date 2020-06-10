package com.zgl.leetcode.java.tree;

import com.zgl.leetcode.java.datastructure.BSTIterator;

import java.util.*;

/**
 * @author zgl
 * @date 2019/12/2 下午2:40
 */
public class TreeNodeUtil {
	public static TreeNode getTreeNode() {
		TreeNode root = new TreeNode(1);
		TreeNode treeNode1 = new TreeNode(2);
		TreeNode treeNode2 = new TreeNode(3);
		TreeNode treeNode3 = new TreeNode(4);
		TreeNode treeNode4 = new TreeNode(5);
		TreeNode treeNode5 = new TreeNode(6);
		root.left = treeNode1;
		root.right = treeNode2;
		treeNode1.left = treeNode3;
		treeNode1.right = treeNode4;
		treeNode2.left = treeNode5;
		treeNode2.right = null;
		return root;
	}

	/**
	 * 层次遍历序列构造二叉树
	 *     1
	 *    / \
	 *   2   3
	 *     / \
	 *     4   5
	 *
	 * as "[1,2,3,null,null,4,5]"
	 */
	public static TreeNode createBinaryTreeByArray(Integer[] nums, int index) {
		if (index < nums.length) {
			TreeNode root;
			Integer value = nums[index];
			if (null == value) {
				return null;
			}
			root = new TreeNode(value);
			root.left = createBinaryTreeByArray(nums, 2 * index + 1);
			root.right = createBinaryTreeByArray(nums, 2 * index + 2);
			return root;
		}
		return null;
	}

	/**
	 * 层次遍历序列构造二叉树
	 *     1
	 *    / \
	 *   2   3
	 *      / \
	 *     4   5
	 *
	 * as "[1,2,3,null,null,4,5,null,null,null,null]"
	 */
	public static TreeNode createBinaryTreeByLevelOrderArray(Integer[] values) {
		Queue<Integer> valueQueue = new LinkedList<>();
		for (Integer integer : values) {
			valueQueue.offer(integer);
		}
		Queue<TreeNode> treeQueue = new LinkedList<>();
		if (valueQueue.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(valueQueue.poll());
		treeQueue.offer(root);
		while (!valueQueue.isEmpty()) {
			TreeNode temp = treeQueue.poll();
			Integer leftValue = valueQueue.poll();
			if (null == leftValue) {
				temp.left = null;
			} else {
				temp.left = new TreeNode(leftValue);
				treeQueue.offer(temp.left);
			}
			Integer rightValue = valueQueue.poll();
			if (null == rightValue) {
				temp.right = null;
			} else {
				temp.right = new TreeNode(rightValue);
				treeQueue.offer(temp.right);
			}
		}
		return root;
	}

	/**
	 * 层次遍历序列构造二叉树
	 *     1
	 *    / \
	 *   2   3
	 *      / \
	 *     4   5
	 *
	 * as "[1,2,null,null,3,4,null,null,5,null,null]"
	 */
	public static TreeNode createBinaryTreeByPreOrderArray(Integer[] values) {
		LinkedList<Integer> valueList = new LinkedList<>(Arrays.asList(values));
		return createBinaryTreeByPreOrderArrayHelper(valueList);
	}

	private static TreeNode createBinaryTreeByPreOrderArrayHelper(LinkedList<Integer> valueList) {
		if(null == valueList.peek()){
			valueList.poll();
			return null;
		}
		TreeNode root = new TreeNode(valueList.poll());
		root.left = createBinaryTreeByPreOrderArrayHelper(valueList);
		root.right=createBinaryTreeByPreOrderArrayHelper(valueList);
		return root;
	}

	/**
	 * 前序遍历打印
	 * @param root
	 */
	public static void printPreOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				result.add(root.val);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				TreeNode top = stack.pop();
				root = top.right;
			}
		}
		System.out.println(result);
	}

	/**
	 * 中序遍历打印
	 * @param root
	 */
	public static void printInOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		BSTIterator.inorder(root, stack, result);
		System.out.println(result);
	}

	/**
	 * 后序遍历打印
	 * @param root
	 */
	public static void printPostOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				TreeNode top = stack.peek();
				if (top.right == null || top.right == pre) {
					result.add(top.val);
					pre = top;
					root = null;
					stack.pop();
				} else {
					root = top.right;
				}
			}
		}
		System.out.println(result);
	}

	/**
	 * 层次遍历打印
	 * @param root
	 */
	public static void printLevelOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode top = queue.poll();
			result.add(top.val);
			if (top.left != null) {
				queue.offer(top.left);
			}
			if (top.right != null) {
				queue.offer(top.right);
			}
		}
		System.out.println(result);
	}

	/**
	 * 创建平衡二叉树
	 * @param nums
	 * @return
	 */
	public static TreeNode createBST(int[] nums) {
		if (nums.length == 0 ) {
			return null;
		}
		return bstHelper(nums, 0, nums.length - 1);
	}

	private static TreeNode bstHelper (int[] nums, int left, int right) {
		if (left <= right) {
			int mid = (left + right) / 2;
			TreeNode newRoot = new TreeNode(nums[mid]);
			newRoot.left = bstHelper(nums, left, mid - 1);
			newRoot.right = bstHelper(nums, mid  + 1, right);
			return newRoot;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		Integer[] values = {1,2,null,null,3,4,null,null,5,null,null};
		TreeNode treeNode = TreeNodeUtil.createBinaryTreeByPreOrderArray(values);
		printPreOrder(treeNode);
		printInOrder(treeNode);
		printPostOrder(treeNode);
		printLevelOrder(treeNode);
		System.out.println(3|9);//11
		System.out.println(3&9);//1
		System.out.println(3^9);//10
	}
}