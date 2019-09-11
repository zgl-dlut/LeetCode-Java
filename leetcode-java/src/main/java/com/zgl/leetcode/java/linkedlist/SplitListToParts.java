package com.zgl.leetcode.java.linkedlist;

import org.apache.commons.codec.binary.StringUtils;

/**
 * @author zgl
 * @date 2019/9/10 下午9:23
 */
public class SplitListToParts {
	public static void main(String[] args) {
		new SplitListToParts().splitListToParts(ListNodeUtil.getHead(), 5);
	}

	/**
	 * 725. Split Linked List in Parts
	 * Input:
	 * root = [1, 2, 3], k = 5
	 * Output: [[1],[2],[3],[],[]]
	 * Explanation:
	 * The input and each element of the output are ListNodes, not arrays.
	 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
	 * The first element output[0] has output[0].val = 1, output[0].next = null.
	 * The last element output[4] is null, but it's string representation as a ListNode is [].
	 */
	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] result = new ListNode[k];
		int length = getLength(root);
		int[] group = getGroup(length, k);
		ListNode cur = root, newHead = root;
		for (int i = 0; i < k; i++) {
			int tag = 1;
			ListNode temp = cur;
			if (group[i] != 0) {
				while (tag < group[i]) {
					tag++;
					cur = cur.next;
				}
				newHead = cur.next;
				cur.next = null;
				result[i] = temp;
				cur = newHead;
			} else {
				result[i] = null;
			}
		}
		return result;
	}

	private int getLength(ListNode root) {
		int length = 0;
		while (root != null) {
			length++;
			root = root.next;
		}
		return length;
	}

	private int[] getGroup(int length, int k) {
		int[] res = new int[k];
		int sub = length % k;
		int partSize = length / k;
		for (int i = 0; i < k; i++) {
			res[i] = partSize;
			if (sub != 0) {
				res[i]++;
				sub--;
			}
		}
		return res;
	}
}