package com.zgl.leetcode.java.tree;

/**
 * @author zgl
 * @date 2019/5/14 下午2:49
 */
public class LowestCommonAncestor {

	/**
	 * 236. Lowest Common Ancestor of a Binary Tree
	 *
	 * 二叉树的最近公共父亲节点
	 */
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

		//发现目标节点则通过返回值标记该子树发现了某个目标结点
		if (root == null || root == p || root == q) {
			return root;
		}
		//查看左子树中是否有目标结点，没有为null
		TreeNode left = lowestCommonAncestor1(root.left, p, q);
		//查看右子树中是否有目标结点，没有为null
		TreeNode right = lowestCommonAncestor1(root.right, p, q);
		//都不为空，说明左右子树都有目标结点，则公共祖先就是本身
		if (left != null && right != null) {
			return root;
		}
		//如果发现了目标节点，则继续向上标记为该目标节点
		return left == null ? right : left;
	}

	/**
	 * 235. Lowest Common Ancestor of a Binary Search Tree
	 */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val > Math.max(p.val, q.val)) {
			return lowestCommonAncestor2(root.left, p, q);
		}
		if (root.val < Math.min(p.val, q.val)) {
			return lowestCommonAncestor2(root.right, p, q);
		}
		return root;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		while (root != null) {
			if (root.val > Math.max(p.val, q.val)) {
				root = root.left;
			} else if (root.val < Math.min(p.val, q.val)) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}
}