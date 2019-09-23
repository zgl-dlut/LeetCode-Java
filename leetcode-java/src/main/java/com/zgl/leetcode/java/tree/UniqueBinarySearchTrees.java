package com.zgl.leetcode.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/5/7 下午3:29
 */
public class UniqueBinarySearchTrees {

	/**
	 * 96. Unique Binary Search Trees
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
	 *
	 * Example:
	 *
	 * Input: 3
	 * Output: 5
	 * Explanation:
	 * Given n = 3, there are a total of 5 unique BST's:
	 *
	 *    1         3     3      2      1
	 *     \       /     /      / \      \
	 *      3     2     1      1   3      2
	 *     /     /       \                 \
	 *    2     1         2                 3
	 *
	 */
	public int numTrees(int n) {
		if (n == 0 || n == 1){
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++){
			for (int j = 1; j <= i; j++){
				/**
				 * G(0)=1, G(1)=1.
				 * G(n) = F(1, n) + F(2, n) + ... + F(n, n).
				 * F(i, n) = G(i-1) * G(n-i)   1 <= i <= n
				 * So,
				 * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
				 */
				dp[i] = dp[i] + dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}

	/**
	 * 95. Unique Binary Search Trees II
	 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
	 *
	 * Example:
	 *
	 * Input: 3
	 * Output:
	 * [
	 *   [1,null,3,2],
	 *   [3,2,null,1],
	 *   [3,1,null,null,2],
	 *   [2,1,3],
	 *   [1,null,2,null,3]
	 * ]
	 * Explanation:
	 * The above output corresponds to the 5 unique BST's shown below:
	 *
	 *    1         3     3      2      1
	 *     \       /     /      / \      \
	 *      3     2     1      1   3      2
	 *     /     /       \                 \
	 *    2     1         2                 3
	 */
	public List<TreeNode> generateTrees(int n) {
		if (n < 1){
			return new ArrayList<>();
		}
		return generateTree(1, n);
	}
	private List<TreeNode> generateTree(int left, int right){
		List<TreeNode> result = new ArrayList<>();
		if (left > right){
			result.add(null);
			return result;
		}
		for (int i = left; i <= right; i++){
			/**
			 * 以i为根节点的树，其左子树由[1, i-1]构成， 其右子树由[i+1, n]构成。
			 */
			List<TreeNode> lefts = generateTree(left, i - 1);
			List<TreeNode> rights = generateTree(i + 1, right);
			for (int j = 0; j < lefts.size(); j++){
				for (int k = 0; k < rights.size(); k++){
					TreeNode root = new TreeNode(i);
					root.left = lefts.get(j);
					root.right = rights.get(k);
					result.add(root);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		new UniqueBinarySearchTrees().generateTrees(3);
	}
}