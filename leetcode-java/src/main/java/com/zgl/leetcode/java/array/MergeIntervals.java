package com.zgl.leetcode.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zgl
 * @date 2019/4/20 下午3:44
 */
public class MergeIntervals {
	public static void main(String[] args) {
		int[][] nums = {{1, 3}, {2, 6},{6,8}};
		int[][] res = new MergeIntervals().merge1(nums);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.println(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	private List<List<Integer>> arrayToList(int[][] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> row;
		for (int i = 0; i < nums.length; i++) {
			row = new ArrayList<>();
			for (int j = 0; j < nums[i].length; j++) {
				row.add(nums[i][j]);
			}
			result.add(row);
		}
		return result;
	}

	private int[][] listToArray(List<List<Integer>> nums) {
		int length = nums.get(0).size();
		int width = nums.size();
		int[][] result = new int[width][length];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				result[i][j] = nums.get(i).get(j);
			}
		}
		return result;
	}

	/**
	 * 56. Merge Intervals
	 * Given a collection of intervals, merge all overlapping intervals.
	 * <p>
	 * Example 1:
	 * <p>
	 * Input: [[1,3],[2,6],[8,10],[15,18]]
	 * Output: [[1,6],[8,10],[15,18]]
	 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
	 * Example 2:
	 * <p>
	 * Input: [[1,4],[4,5]]
	 * Output: [[1,5]]
	 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
	 */
	public int[][] merge1(int[][] intervals) {
		if (intervals.length == 0){
			return intervals;
		}
		List<List<Integer>> nums = arrayToList(intervals);
		List<List<Integer>> result = new ArrayList<>();
		nums.sort(Comparator.comparingInt(list -> list.get(0)));
		List<Integer> temp = nums.get(0);
		if (nums.size() == 1) {
			result.add(temp);
			return listToArray(nums);
		}
		for (int i = 1; i < nums.size(); i++) {
			if (temp.get(1) >= nums.get(i).get(0)) {
				temp.set(1, Math.max(temp.get(1), nums.get(i).get(1)));
			} else {
				result.add(temp);
				temp = nums.get(i);
			}
		}
		result.add(temp);
		return listToArray(result);
	}

	public int[][] merge(int[][] intervals) {
		int length = intervals.length;
		if (length == 0) {
			return intervals;
		}
		List<int[]> result = new ArrayList<>();
		int[] first = new int[length];
		int[] second = new int[length];
		for (int i = 0; i < length; i++) {
			first[i] = intervals[i][0];
			second[i] = intervals[i][1];
		}
		Arrays.sort(first);
		Arrays.sort(second);
		for (int i = 0, j = 0; i < length; i++) {
			if (i == length - 1 || first[i + 1] <= second[i]) {
				result.add(new int[]{first[j], second[i]});
				j = i + 1;
			}
		}
		return result.toArray(new int[result.size()][]);
	}
}