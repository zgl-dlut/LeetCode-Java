package com.zgl.leetcode.java.tree;

import java.util.*;

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



	public static String getItem(int [] arr){//重组arr，取出最大的数
		String [] strArr = new String[arr.length];
		Map<String,String> map = new HashMap<>();
		int maxLen = 0;
		for(int i = 0 ; i < strArr.length ; i++){
			strArr[i] = String.valueOf(arr[i]);  //将整型数组转换为字符串数组
			if(strArr[i].length() > maxLen){
				maxLen = strArr[i].length();  //找到最长字符串的长度
			}
		}
		String[] strArrb = new String[arr.length];
		for(int i = 0 ;i < strArrb.length ; i++){
			strArrb[i] = strArr[i];
			int strLen = strArr[i].length();
			String s = strArr[i].substring(strLen-1,strLen);//找到该元素的最后一个字符
			for(int j = 0 ; j < maxLen - strLen ; j++){
				strArrb[i] += s ;//在原字符串下加上maxLen-strLen个字符s
			}
			if(map.containsKey(strArrb[i])){
				strArrb[i] +="_" + i ;//若map中已有该key值则将该key加上后缀"_i"
			}
			map.put(strArrb[i], strArr[i]);
		}
		Arrays.sort(strArrb);
		String res = "";
		for(int i = strArrb.length-1 ; i >= 0 ; i--){
			res += map.get(strArrb[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1,10,28,8};
		System.out.println(new LowestCommonAncestor().getMax(nums));
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

	public TreeNode commonParent(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = commonParent(root.left, p, q);
		TreeNode right = commonParent(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : null;
	}

	public String getMax(int[] nums) {
		String[] strNum = new String[nums.length];
		Map<String, String> map = new HashMap<>();
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			strNum[i] = String.valueOf(nums[i]);
			if (strNum[i].length() > maxLength) {
				maxLength = strNum[i].length();
			}
		}
		String [] newStrNum  = new String[nums.length];
		for (int i = 0; i <nums.length ; i++ ) {
			newStrNum[i] = strNum[i];
			int subLength = newStrNum[i].length();
			String lastStr = newStrNum[i].substring(subLength - 1, subLength);
			for (int ii = 0; ii < maxLength - subLength; ii++) {
				newStrNum[i] += lastStr;
			}
			map.put(newStrNum[i], strNum[i]);
		}
		Arrays.sort(newStrNum);
		String result = "";
		for (int i =  nums.length - 1; i >= 0; i--) {
			result += map.get(newStrNum[i]);
		}
		return result;

	}

	public class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}