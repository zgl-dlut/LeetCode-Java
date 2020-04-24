package com.zgl.leetcode.java.interview.bianlifeng;

import com.zgl.leetcode.java.tree.TreeNode;

/**
 * @author zgl
 * @date 2020/4/24 下午3:49
 */
public class LowestCommonAncestor {
	/**
	 * 236. Lowest Common Ancestor of a Binary Tree
	 * <p>
	 * 二叉树的最近公共父亲节点
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		//发现目标节点则通过返回值标记该子树发现了某个目标结点
		if (root == null || root == p || root == q) {
			return root;
		}
		//查看左子树中是否有目标结点，没有为null
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		//查看右子树中是否有目标结点，没有为null
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		//都不为空，说明左右子树都有目标结点，则公共祖先就是本身
		if (left != null && right != null) {
			return root;
		}
		//如果发现了目标节点，则继续向上标记为该目标节点
		return left == null ? right : left;
	}
}