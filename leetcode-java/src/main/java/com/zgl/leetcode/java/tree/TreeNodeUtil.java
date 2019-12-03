package com.zgl.leetcode.java.tree;

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
}