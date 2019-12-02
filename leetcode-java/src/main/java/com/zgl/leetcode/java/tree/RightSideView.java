package com.zgl.leetcode.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zgl
 * @date 2019/12/2 下午4:27
 */
public class RightSideView {
	/**
	 * 199. Binary Tree Right Side View
	 * Given a binary tree, imagine yourself standing on the right side of it,
	 * return the values of the nodes you can see ordered from top to bottom.
	 *
	 * Example:
	 *
	 * Input: [1,2,3,null,5,null,4]
	 * Output: [1, 3, 4]
	 * Explanation:
	 *
	 *    1            <---
	 *  /   \
	 * 2     3         <---
	 *  \     \
	 *   5     4       <---
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int changeSize = size;
			List<Integer> tempList = new ArrayList<>();
			while (changeSize > 0) {
				TreeNode tempNode = queue.poll();
				tempList.add(tempNode.val);
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
				changeSize--;
			}
			result.add(tempList.get(size - 1));
		}
		return result;
	}
}