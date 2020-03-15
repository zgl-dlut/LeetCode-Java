package com.zgl.leetcode.java.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2020/3/6 下午4:46
 */
public class Step {

	public static void main(String[] args) {
		Step mock = new Step();
		System.out.println(mock.step(4));
	}

	/**
	 * 一个上台阶的游戏
	 * 一个人在上台阶，一次可以走一步或者两步，n级台阶，请print出来所有可能上法的具体的执行步骤。
	 * n = 3
	 * 1 1 1
	 * 2 1
	 * 1 2
	 */
	public List<List<Integer>> step (int n){

		List<List<Integer>> result = new ArrayList<>();
		//problem1
		if (n <= 0) {
			return result;
		}
		helper(n, new ArrayList<>(), result);
		return result;
	}

	private void helper(int sum, List<Integer> answer, List<List<Integer>> result) {
		if (sum == 0) {
			result.add(new ArrayList<>(answer));
			return;
		}
		if (sum < 0) {
			return;
		}
		for (int i = 1; i <= 2; i++) {
			answer.add(i);
			helper(sum - i, answer, result);
			answer.remove(answer.size() - 1);
		}
	}
}