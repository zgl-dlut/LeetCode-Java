package com.zgl.leetcode.java.dynamic;

import com.zgl.leetcode.java.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zgl
 * @date 2019/5/24 上午11:00
 */
public class HouseRobber {

	/**
	 * 198. House Robber
	 * You are a professional robber planning to rob houses along a street.
	 * Each house has a certain amount of money stashed, the only constraint stopping
	 * you from robbing each of them is that adjacent houses have security system
	 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
	 *
	 * Given a list of non-negative integers representing the amount of money of each house,
	 * determine the maximum amount of money you can rob tonight without alerting the police.
	 *
	 * Example 1:
	 *
	 * Input: [1,2,3,1]
	 * Output: 4
	 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
	 *              Total amount you can rob = 1 + 3 = 4.
	 * Example 2:
	 *
	 * Input: [2,7,9,3,1]
	 * Output: 12
	 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
	 *              Total amount you can rob = 2 + 9 + 1 = 12.
	 */
	public int rob1(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}
		if (length == 1) {
			return nums[0];
		}
		/**
		 * dp[i] = max(dp[i-1], dp[i-2] + nums[i])
		 */
		int[] dp = new int[length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		int result = dp[1];
		for (int i = 2; i < length; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
			result = Math.max(dp[i], result);
		}
		return result;
	}

	/**
	 * 213. House Robber II
	 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
	 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
	 * Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
	 *
	 * Given a list of non-negative integers representing the amount of money of each house,
	 * determine the maximum amount of money you can rob tonight without alerting the police.
	 *
	 * Example 1:
	 *
	 * Input: [2,3,2]
	 * Output: 3
	 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
	 *              because they are adjacent houses.
	 * Example 2:
	 *
	 * Input: [1,2,3,1]
	 * Output: 4
	 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
	 *              Total amount you can rob = 1 + 3 = 4.
	 */
	public int rob(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}
		if (length == 1) {
			return nums[0];
		}
		if (length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(subRob(nums, 0), subRob(nums, 1));
	}

	private int subRob(int[] nums, int start) {
		int[] dp = new int[nums.length - 1];
		dp[0] = nums[start];
		dp[1] = Math.max(nums[start], nums[start + 1]);
		int result = dp[1];
		for (int i = 2; i < nums.length - 1; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i + start] + dp[i - 2]);
			result = Math.max(dp[i], result);
		}
		return result;
	}

	private Map<TreeNode, Integer> map = new HashMap<>();

	/**
	 * 337. House Robber III
	 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
	 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree".
	 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
	 *
	 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
	 *
	 * Example 1:
	 *
	 * Input: [3,2,3,null,3,null,1]
	 *
	 *      3
	 *     / \
	 *    2   3
	 *     \   \
	 *      3   1
	 *
	 * Output: 7
	 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
	 * Example 2:
	 *
	 * Input: [3,4,5,1,3,null,1]
	 *
	 *      3
	 *     / \
	 *    4   5
	 *   / \   \
	 *  1   3   1
	 *
	 * Output: 9
	 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
	 *
	 */
	public int myRob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int result = 0;
		if (root.left != null) {
			result += myRob(root.left.left) + myRob(root.left.right);
		}
		if (root.right != null) {
			result += myRob(root.right.left) + myRob(root.right.right);
		}
		//两种情况， 当前节点偷与不偷
		return Math.max(root.val + result, myRob(root.left) + myRob(root.right));
	}

	public int rob2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		/*int result = 0;
		if (map.containsKey(root)) {
			return map.get(root);
		}
		if (root.left != null) {
			result += rob(root.left.left) + rob(root.left.right);
		}
		if (root.right != null) {
			result += rob(root.right.left) + rob(root.right.right);
		}
		int newResult = Math.max(root.val + result, rob(root.left) + rob(root.right));
		map.put(root, newResult);
		return newResult;
*/
		return subRob(root, map);
	}
	private int subRob(TreeNode root, Map<TreeNode, Integer> map) {
		int result = 0;
		if (map.containsKey(root)) {
			return map.get(root);
		}
		if (root.left != null) {
			result += subRob(root.left.left, map) + subRob(root.left.right, map);
		}
		if (root.right != null) {
			result += subRob(root.right.left, map) + subRob(root.right.right, map);
		}
		result = Math.max(root.val + result, subRob(root.left, map) + subRob(root.right, map));
		map.put(root, result);
		return result;
	}

	public int rob(TreeNode root) {
		int[] result = subRob(root);
		return Math.max(result[0], result[1]);
	}

	private int[] subRob(TreeNode root) {
		//result[0]表示不偷,result[1]表示偷
		int[] result = new int[2];
		if (root == null) {
			return result;
		}
		int[] left = subRob(root.left);
		int[] right = subRob(root.right);
		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		result[1] = left[0] + right[0] + root.val;
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {2,3,2,1,3};
		System.out.println(new HouseRobber().rob(nums));
	}
}