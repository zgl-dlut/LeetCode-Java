package com.zgl.leetcode.java.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zgl
 * @date 2019/1/15 上午11:12
 */
public class BinaryTree {

	public static void main(String[] args) {
		Integer[] nums = {0,1,2,3,4,5,6,null,8,null,null,7};
		TreeNode root = TreeNodeUtil.createBinaryTreeByArray(nums, 0);
		new BinaryTree().postOrder1(root);
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int result = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			++result;
			for (int i = 0, n = queue.size(); i < n; i++) {
				TreeNode top = queue.poll();
				if (top.left != null) {
					queue.offer(top.left);
				}
				if (top.right != null) {
					queue.offer(top.right);
				}
			}
		}
		return result;
	}

	/**
	 * 节点个数
	 */
	public int size(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + size(root.left) + size(root.right);
		}
	}

	/**
	 * 返回双亲节点
	 */
	public TreeNode parent(TreeNode root, TreeNode element) {
		if (root == null) {
			return null;
		}
		if (root.left == element || root.right == element) {
			return root;
		}
		TreeNode tag;
		if ((tag = parent(root.left, element)) != null) {
			return tag;
		} else {
			return parent(root.right, element);
		}
	}

	/**
	 * 删除根为subTree的子树
	 */
	public void destroy(TreeNode subTree) {
		if (subTree != null) {
			destroy(subTree.left);
			destroy(subTree.right);
			subTree = null;
		}
	}

	/**
	 * 二叉树高度
	 */
	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left = height(root.left);
			int right = height(root.right);
			return 1 + Math.max(left, right);
		}
	}

	/**
	 * 先序递归遍历
	 */
	public void preOrder(TreeNode root) {
		if (root != null) {
			visit(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	/**
	 * 访问某个节点
	 */
	public void visit(TreeNode element) {
		System.out.print(element.val);
		System.out.print("  ");
	}

	/**
	 * 中序递归遍历
	 */
	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			visit(root);
			inOrder(root.right);
		}
	}

	public void preOrder1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.empty()) {
			while (root != null) {
				visit(root);
				stack.push(root);
				root = root.left;
			}
			if (!stack.empty()) {
				TreeNode top = stack.pop();
				root = top.right;
			}
		}
	}

	/**
	 * 后序递归遍历
	 */
	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			visit(root);
		}
	}

	public void inOrder1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.empty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.empty()) {
				TreeNode top = stack.pop();
				visit(top);
				root = root.right;
			}
		}
	}

	public void postOrder1(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.empty()) {
			TreeNode top = stack1.pop();
			/**
			 * s2根 右 左
			 */
			stack2.push(top);
			/**
			 * s1左节点 右节点
			 */
			if (top.left != null) {
				stack1.push(top.left);
			}
			if (top.right != null) {
				stack1.push(top.right);
			}
		}
		while (!stack2.empty()) {
			/**
			 * 左 右 根
			 */
			TreeNode top = stack2.pop();
			visit(top);
		}
	}

	public void postOrder2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.empty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.empty()) {
				TreeNode top = stack.peek();
				/**
				 * 右节点为空，或者已经访问过了，弹栈、访问、标记
				 */
				if (top.right == null || top.right == pre) {
					visit(top);
					pre = top;
					root = null;
					stack.pop();
				} else {
					root = top.right;
				}
			}
		}
	}

	/**
	 * 层次遍历/广度优先遍历(BFS)
	 */
	public void levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode top = queue.poll();
			visit(top);
			if (root.left != null) {
				queue.offer(root.left);
			}
			if (root.right != null) {
				queue.offer(root.right);
			}
		}
	}

	/**
	 * 深度优先遍历(DFS)-就是前中后序遍历
	 */
	public void dfs(TreeNode root) {

	}

	public int minDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int result = 0;
		while (!queue.isEmpty()) {
			int n = queue.size();
			result++;
			TreeNode front;
			for (int i = n; i > 0; i--) {
				front = queue.poll();
				if (front.left == null && front.right == null) {
					return result;
				} else {
					if (front.left != null) {
						queue.offer(front.left);
					}
					if (front.right != null) {
						queue.offer(front.right);
					}
				}
			}
		}
		return result;
	}

	/**
	 * 111. Minimum Depth of Binary Tree
	 * Given a binary tree, find its minimum depth.
	 * <p>
	 * The minimum depth is the number of nodes along the shortest path
	 * from the root node down to the nearest leaf node.
	 * <p>
	 * Note: A leaf is a node with no children.
	 * <p>
	 * Example:
	 * <p>
	 * Given binary tree [3,9,20,null,null,15,7],
	 * <p>
	 * 3
	 * / \
	 * 9  20
	 * /  \
	 * 15   7
	 * return its minimum depth = 2.
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		/**
		 * 要注意如果有个节点只有一边孩子时，不能返回0，要返回另外一半边的depth。(正常求树的高度)
		 */
		if (root.left == null || root.right == null) {
			return Math.max(left, right) + 1;
		} else {
			return Math.min(left, right) + 1;
		}
	}

}
