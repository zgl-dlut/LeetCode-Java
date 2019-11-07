package com.zgl.leetcode.java.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/11/7 下午1:57
 */
public class QueueReconstructionByHeight {
	public static void main(String[] args) {
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] result = new QueueReconstructionByHeight().reconstructQueue(people);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 406. Queue Reconstruction by Height
	 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
	 * where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
	 *
	 * Note:
	 * The number of people is less than 1,100.
	 *
	 *
	 * Example
	 *
	 * Input:
	 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	 *
	 * Output:
	 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	 */
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (int[] a, int[] b) -> {
			if (a[0] != b[0]) {
				return b[0] - a[0];
			} else {
				return a[1] - b[1];
			}
		});
		List<int[]> result = new LinkedList<>();
		for (int i = 0; i < people.length; i++) {
			result.add(people[i][1], people[i]);
		}
		return result.toArray(new int[people.length][2]);
	}
}