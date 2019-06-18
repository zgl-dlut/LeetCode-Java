package com.zgl.leetcode.java.genetic;

/**
 * @author zgl
 * @date 2019/6/17 上午11:27
 */
public class Test {
	public static void main(String[] args) {
		Father father = new Son();
		Son son = (Son) father;
		System.out.println(son.eat());
	}
}