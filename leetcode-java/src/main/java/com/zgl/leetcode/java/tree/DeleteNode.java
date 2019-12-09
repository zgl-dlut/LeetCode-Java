package com.zgl.leetcode.java.tree;

/**
 * @author zgl
 * @date 2019/12/8 下午8:51
 */
public class DeleteNode {
	public static void main(String[] args) {
		Integer[] nums = {5,3,6,2,4,null,7};
		TreeNode root = TreeNodeUtil.createBinaryTreeByArray(nums, 0);
		root = new DeleteNode().deleteNode(root, 5);
		TreeNodeUtil.printInOrder(root);
		TreeNodeUtil.printLevelOrder(root);
	}

	/**
	 * 450. Delete Node in a BST
	 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
	 *
	 * Basically, the deletion can be divided into two stages:
	 *
	 * Search for a node to remove.
	 * If the node is found, delete the node.
	 * Note: Time complexity should be O(height of tree).
	 *
	 * Example:
	 *
	 * root = [5,3,6,2,4,null,7]
	 * key = 3
	 *
	 *     5
	 *    / \
	 *   3   6
	 *  / \   \
	 * 2   4   7
	 *
	 * Given key to delete is 3. So we find the node with value 3 and delete it.
	 *
	 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
	 *
	 *     5
	 *    / \
	 *   4   6
	 *  /     \
	 * 2       7
	 *
	 * Another valid answer is [5,2,6,null,4,null,7].
	 *
	 *     5
	 *    / \
	 *   2   6
	 *    \   \
	 *     4   7
	 */
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			//左子树为空
			if (root.left == null) {
				return root.right;
			}
			//右子树为空
			if (root.right == null) {
				return root.left;
			}
			TreeNode leftMax = findLeftMax(root.left);
			root.val = leftMax.val;
			//左子树中删除key
			root.left = deleteNode(root.left, leftMax.val);
		}
		return root;
	}

	//左子树中最大的值
	private TreeNode findLeftMax(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	//右子树中最小的值
	private TreeNode findRightMin(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
}