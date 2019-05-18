package com.zgl.leetcode.java.datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/5/18 下午5:30
 */
public class MinStack {

	/**
	 * 155. Min Stack
	 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	 *
	 * push(x) -- Push element x onto stack.
	 * pop() -- Removes the element on top of the stack.
	 * top() -- Get the top element.
	 * getMin() -- Retrieve the minimum element in the stack.
	 * Example:
	 * MinStack minStack = new MinStack();
	 * minStack.push(-2);
	 * minStack.push(0);
	 * minStack.push(-3);
	 * minStack.getMin();   --> Returns -3.
	 * minStack.pop();
	 * minStack.top();      --> Returns 0.
	 * minStack.getMin();   --> Returns -2.
	 */

	private LinkedList<Integer> stack = new LinkedList<>();

	private int min = Integer.MAX_VALUE;


	public MinStack() {

	}

	public void push(int x) {
		stack.offerFirst(x);
		min = Math.min(min, x);
	}

	public void pop() {
		int top = stack.getFirst();
		stack.pollFirst();
		if (top == min){
			int newMin = Integer.MAX_VALUE;
			for (int i = 0; i < stack.size(); i++){
				newMin = Math.min(newMin, stack.get(i));
			}
			min = newMin;
		}
	}

	public int top() {
		return stack.getFirst();
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin();
		minStack.pop();
		minStack.top();
		minStack.getMin();

	}
	//[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483648,-2147483648,null,2147483647]
	//[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
}