package com.zgl.leetcode.java.array;

/**
 * LeetCode 70
 * @author zgl
 * @date 2018/11/26 下午8:41
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * 递归and非递归
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		if(n==1){
			return 1;
		}else if (n==2){
			return 2;
		}else {
			return climbStairs(n-1)+climbStairs(n-2);
		}
	}

	public int climbStairs1(int n) {
		int[]stairs=new int[n];
		if(n==1){
			return 1;
		}else if (n==2){
			return 2;
		}else {
			stairs[0]=1;
			stairs[1]=2;
			for(int i=2;i<n;i++){
				stairs[i]=stairs[i-1]+stairs[i-2];
			}
			return stairs[n-1];
		}
	}
	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs1(3));
	}
}
