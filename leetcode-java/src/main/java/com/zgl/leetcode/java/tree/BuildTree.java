package com.zgl.leetcode.java.tree;

/**
 * @author zgl
 * @date 2019/1/21 下午1:39
 */
public class BuildTree {
	/**
	 * 105. Construct Binary Tree from Preorder and Inorder Traversal
	 * Given preorder and inorder traversal of a tree, construct the binary tree.
	 * <p>
	 * Note:
	 * You may assume that duplicates do not exist in the tree.
	 */
	public TreeNode buildTree1(int[] preorder, int[] inorder) {
		int preLength = preorder.length;
		int inLength = inorder.length;
		return builder1(preorder, 0, preLength - 1, inorder, 0, inLength - 1);
	}

	public TreeNode builder1(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		int rootVal = preorder[preStart];
		TreeNode root = new TreeNode(rootVal);
		if (preStart == preEnd) {
			return root;
		}
		int index = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == rootVal) {
				index = i;
				break;
			}
		}
		int leftLength = index - inStart;
		root.left = builder1(preorder, preStart + 1, preStart + leftLength, inorder, inStart, index - 1);
		root.right = builder1(preorder, preStart + leftLength + 1, preEnd, inorder, index + 1, inEnd);
		return root;
	}

	/**
	 * 106. Construct Binary Tree from Inorder and Postorder Traversal
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int inLength = inorder.length;
		int postLength = postorder.length;
		return builder2(inorder, 0, inLength - 1, postorder, 0, postLength - 1);
	}

	public TreeNode builder2(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}
		int rootVal = postorder[postEnd];
		TreeNode root = new TreeNode(rootVal);
		if (postStart == postEnd) {
			return root;
		}
		int index = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == rootVal) {
				index = i;
				break;
			}
		}
		int leftLength = index - inStart;
		root.left = builder2(inorder, inStart, index - 1, postorder, postStart, postStart + leftLength - 1);
		root.right = builder2(inorder, index + 1, inEnd, postorder, postStart + leftLength, postEnd - 1);
		return root;
	}

	/**
	 * 889. Construct Binary Tree from Preorder and Postorder Traversal
	 * Return any binary tree that matches the given preorder and postorder traversals.
	 * <p>
	 * Values in the traversals pre and post are distinct positive integers.
	 */
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		int preLength = pre.length;
		int postLength = post.length;
		return builder3(pre, 0, preLength - 1, post, 0, postLength - 1);
	}

	public TreeNode builder3(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
		if (preStart > preEnd || postStart > postEnd) {
			return null;
		}
		int rootValue = pre[preStart];
		TreeNode root = new TreeNode(rootValue);
		if (preStart == preEnd) {
			return root;
		}
		int index = 0;
		int firstLeftVal = pre[preStart + 1];
		for (int i = postStart; i <= postEnd; i++) {
			if (post[i] == firstLeftVal) {
				index = i;
				break;
			}
		}
		int leftLength = index - postStart + 1;
		root.left = builder3(pre, preStart + 1, preStart + leftLength, post, postStart, index);
		root.right = builder3(pre, preStart + leftLength + 1, preEnd, post, index + 1, postEnd - 1);
		return root;
	}
}
