package com.zgl.leetcode.java.array;

import java.util.*;

/**
 * @author zgl
 * @date 2019/5/30 下午1:24
 */
public class CourseSchedule {

	/**
	 * 207. Course Schedule
	 * There are a total of n courses you have to take, labeled from 0 to n-1.
	 *
	 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	 *
	 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
	 *
	 * Example 1:
	 *
	 * Input: 2, [[1,0]]
	 * Output: true
	 * Explanation: There are a total of 2 courses to take.
	 *              To take course 1 you should have finished course 0. So it is possible.
	 * Example 2:
	 *
	 * Input: 2, [[1,0],[0,1]]
	 * Output: false
	 * Explanation: There are a total of 2 courses to take.
	 *              To take course 1 you should have finished course 0, and to take course 0 you should
	 *              also have finished course 1. So it is impossible.
	 * Note:
	 *
	 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
	 * You may assume that there are no duplicate edges in the input prerequisites.
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//key为节点,value为与该节点相连边的节点
		Map<Integer, List<Integer>> graph = new HashMap<>();
		//存储每个节点的入度,采用拓扑排序,每次删除入度为0的节点
		int[] degree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int first = prerequisites[i][0];
			int second = prerequisites[i][1];
			if (!graph.containsKey(first)) {
				graph.put(first, new ArrayList<>());
			}
			graph.get(first).add(second);
			degree[second]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		for (int i = 0; i< numCourses; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int degreeVal = queue.poll();
			count++;
			if (!graph.containsKey(degreeVal)) {
				continue;
			}
			//所有相连边的节点入度减一
			for (Integer integer : graph.get(degreeVal)) {
				degree[integer]--;
				if (degree[integer] == 0) {
					queue.offer(integer);
				}
			}

		}
		return count == numCourses;
	}

	public static void main(String[] args) {
		int[][] prerequisites = {{1,0}};
		System.out.println(new CourseSchedule().canFinish(3, prerequisites));
	}
}