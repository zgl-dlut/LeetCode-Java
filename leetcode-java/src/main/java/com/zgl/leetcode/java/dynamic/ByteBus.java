package com.zgl.leetcode.java.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zgl
 * @date 2019/10/15 下午1:59
 */
public class ByteBus {
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {2,3,4,5,7};
		System.out.println(new ByteBus().helper(gas, cost));
		int[] nums = {5,5,5,10,20};
		System.out.println(new ByteBus().findSurplus(nums));
	}

	public int helper(int[] gas, int[] cost) {
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			int sum = gas[i], count = 0, j = i;
			while (sum >= cost[j] && count < n) {
				sum -= cost[j];
				j = (j + 1) % n;
				sum += cost[j];
				count++;
			}
			if (count == n) {
				return i;
			}
		}
		return -1;
	}

	public boolean findSurplus(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			int count = map.getOrDefault(i, 0);
			map.put(i, count + 1);
		}
		return false;
	}
}