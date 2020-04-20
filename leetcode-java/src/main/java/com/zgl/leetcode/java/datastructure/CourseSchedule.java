package com.zgl.leetcode.java.datastructure;

import java.util.*;

/**
 * @author zgl
 * @date 2019/5/30 下午1:24
 */
public class CourseSchedule {

	//0->1, 0->2, 1->3, 2->3
	public static void main(String[] args) {
		int[][] prerequisites = {};
		System.out.println(new CourseSchedule().canFinish(1, prerequisites));
		/*int[] res = new CourseSchedule().findOrder(4, prerequisites);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
			System.out.print(" ");
		}*/
	}

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
	//int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
	//0->1, 0->2, 1->3, 2->3
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] edgeDegrees = new int[numCourses];
		this.init(prerequisites, graph, edgeDegrees);
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (edgeDegrees[i] == 0) {
				queue.offer(i);
			}
		}
		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			int front = queue.poll();
			if (graph.containsKey(front)) {
				List<Integer> nodes = graph.get(front);
				for (int node : nodes) {
					edgeDegrees[node]--;
					if (edgeDegrees[node] == 0) {
						queue.offer(node);
					}
				}
			}
		}
		return count == numCourses;
	}
	private void init(int[][] prerequisites, Map<Integer, List<Integer>> graph, int[] edgeDegrees) {
		for (int i = 0; i < prerequisites.length; i++) {
			int from = prerequisites[i][1];
			int to = prerequisites[i][0];
			if (!graph.containsKey(from)) {
				graph.put(from, new ArrayList<>());
			}
			graph.get(from).add(to);
			edgeDegrees[to]++;
		}
	}

	/**
	 * 210. Course Schedule II
	 * Example 1:
	 *
	 * Input: 2, [[1,0]]
	 * Output: [0,1]
	 *
	 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
	 * Output: [0,1,2,3] or [0,2,1,3]
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] degree = new int[numCourses];
		this.init(prerequisites, graph, degree);
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
			}
		}
		int[] result = new int[numCourses];
		int tag = 0, count = 0;
		while (!queue.isEmpty()) {
			int value = queue.poll();
			result[tag++] = value;
			count++;

			if (graph.containsKey(value)) {
				for (Integer integer : graph.get(value)) {
					degree[integer]--;
					if (degree[integer] == 0) {
						queue.offer(integer);
					}
				}
			}
		}
		return count == numCourses ? result : new int[0];
	}
}