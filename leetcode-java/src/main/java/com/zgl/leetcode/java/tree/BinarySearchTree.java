package com.zgl.leetcode.java.tree;

import com.sun.source.tree.Tree;

import java.util.*;

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
		inOrder.sort(Comparator.comparingInt(a -> a));
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
	private int maxCount = 0;

	/**
	 * 108. Convert Sorted Array to Binary Search Tree
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 *
	 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	 *
	 * Example:
	 *
	 * Given the sorted array: [-10,-3,0,5,9],
	 *
	 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
	 *
	 *       0
	 *      / \
	 *    -3   9
	 *    /   /
	 *  -10  5
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0 ) {
			return null;
		}
		return bstHelper(nums, 0, nums.length - 1);
	}

	private TreeNode bstHelper (int[] nums, int left, int right) {
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
	private int currentCount = 0;
	private int lastVal = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9};
		TreeNode root = new BinarySearchTree().sortedArrayToBST(nums);
		TreeNodeUtil.printInOrder(root);
		Integer[] nums1 = {1,null,2,2};
		TreeNode treeNode = TreeNodeUtil.createBinaryTreeByLevelOrderArray(nums1);
		new BinarySearchTree().findMode(root);
	}

	/**
	 * 501. Find Mode in Binary Search Tree
	 * For example:
	 * Given BST [1,null,2,2],
	 *
	 *    1
	 *     \
	 *      2
	 *     /
	 *    2
	 *
	 *
	 * return [2].
	 */
	public int[] findMode1(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		Map<Integer, Integer> map = new TreeMap<>();
		while (!queue.isEmpty()) {
			TreeNode top = queue.poll();
			map.put(top.val, map.getOrDefault(top.val, 0) + 1);
			if (top.left != null) {
				queue.offer(top.left);
			}
			if (top.right != null) {
				queue.offer(top.right);
			}
		}
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
		entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
		List<Integer> resultList = new ArrayList<>();
		resultList.add(entryList.get(0).getKey());
		int count = entryList.get(0).getValue();
		for (int i = 1; i < entryList.size(); i++) {
			if (entryList.get(i).getValue() == count) {
				resultList.add(entryList.get(i).getKey());
			} else {
				break;
			}
		}
		int[] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		return result;
	}

	public int[] findMode2(TreeNode root) {
		List<Integer> valueList = new ArrayList<>();
		int maxCount = 0;
		int currentCount = 0;
		int lastVal = Integer.MIN_VALUE;
		if (root == null) {
			return new int[0];
		}
		//中序遍历
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				TreeNode top = stack.pop();
				//和前一个数相等
				if (top.val == lastVal) {
					currentCount++;
				} else {
					currentCount = 1;
					lastVal = top.val;
				}
				//当前累积count和最大count相等,结果list添加当前val
				if (currentCount == maxCount) {
					valueList.add(top.val);
					//当前累积count大于最大count,清空list,结果list添加当前val,更新最大值
				} else if (currentCount > maxCount) {
					valueList.clear();
					maxCount = currentCount;
					valueList.add(top.val);
				}

				//继续非递归中序遍历
				root = top.right;
			}
		}
		int[] result = new int[valueList.size()];
		for (int i = 0; i < valueList.size(); i++) {
			result[i] = valueList.get(i);
		}
		return result;
	}

	public int[] findMode(TreeNode root) {
		List<Integer> valueList = new ArrayList<>();
		inorderHelper(root, valueList);
		int[] result = new int[valueList.size()];
		for (int i = 0; i < valueList.size(); i++) {
			result[i] = valueList.get(i);
		}
		return result;
	}

	private void inorderHelper(TreeNode root, List<Integer> valueList) {
		if (root == null) {
			return;
		}
		inorderHelper(root.left, valueList);
		if (root.val == lastVal) {
			currentCount++;
		} else {
			currentCount = 1;
			lastVal = root.val;
		}
		if (currentCount > maxCount) {
			maxCount = currentCount;
			valueList.clear();
			valueList.add(root.val);
		} else if (currentCount == maxCount) {
			valueList.add(root.val);
		}
		inorderHelper(root.right, valueList);
	}
}