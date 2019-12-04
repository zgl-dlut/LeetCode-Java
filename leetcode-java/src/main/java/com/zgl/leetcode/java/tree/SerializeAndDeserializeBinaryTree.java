package com.zgl.leetcode.java.tree;

import com.sun.tools.javac.util.ListBuffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zgl
 * @date 2019/12/4 下午3:29
 */
public class SerializeAndDeserializeBinaryTree {
	public static void main(String[] args) {
		String data = "[1,2,3,null,null,4,5]";
		Integer[] nums = {1,2,3,null,null,4,5};
		TreeNode root = TreeNodeUtil.createBinaryTreeByArray(nums, 0);
		System.out.println(new SerializeAndDeserializeBinaryTree().serialize(root));
	}

	/**
	 * Serialize and Deserialize Binary Tree
	 *
	 * Example:
	 *
	 * You may serialize the following tree:
	 *
	 *     1
	 *    / \
	 *   2   3
	 *      / \
	 *     4   5
	 *
	 * as "[1,2,3,null,null,4,5]"
	 */
	public String serialize(TreeNode root) {
		if (root == null) {
			return "[]";
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		levelOrder(root, stringBuilder);
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	public TreeNode deserialize(String data) {
		List<Integer> valueList = createValueArray(data);
		if (valueList == null) {
			return null;
		}
		return createBinaryTree(valueList.toArray(new Integer[0]));
	}

	private TreeNode createBinaryTree(Integer[] values) {
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
	 * 层次遍历序列构造
	 */
	private List<Integer> createValueArray(String data) {
		List<Integer> list = new ArrayList<>();
		int length = data.length();
		if (length <= 2) {
			return list;
		}
		String[] valueString = data.substring(1, length - 1).split(",");
		for (String s : valueString) {
			if ("null".equals(s)) {
				list.add(null);
			} else {
				list.add(Integer.valueOf(s));
			}
		}
		return list;
	}

	/**
	 * 先序遍历
	 * @param root
	 * @param stringBuilder
	 */
	private void serializeHelper(TreeNode root, StringBuilder stringBuilder) {
		if (root == null) {
			stringBuilder.append("null,");
		} else {
			stringBuilder.append(root.val + ",");
			serializeHelper(root.left, stringBuilder);
			serializeHelper(root.right, stringBuilder);
		}
	}

	private void levelOrder(TreeNode root, StringBuilder stringBuilder) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		stringBuilder.append(root.val + ",");
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode top = queue.poll();
				if (top.left != null) {
					stringBuilder.append(top.left.val + ",");
					queue.offer(top.left);
				} else {
					stringBuilder.append("null,");
				}
				if (top.right != null) {
					stringBuilder.append(top.right.val + ",");
					queue.offer(top.right);
				} else {
					stringBuilder.append("null,");
				}
				size--;
			}
		}
	}
}