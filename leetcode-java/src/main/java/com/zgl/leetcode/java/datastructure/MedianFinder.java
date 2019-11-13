package com.zgl.leetcode.java.datastructure;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author zgl
 * @date 2019/11/13 上午11:42
 */
public class MedianFinder {
	/**
	 * 295. Find Median from Data Stream
	 *
	 * Median is the middle value in an ordered integer list. If the size of the list is even,
	 * there is no middle value. So the median is the mean of the two middle value.
	 *
	 * For example,
	 * [2,3,4], the median is 3
	 *
	 * [2,3], the median is (2 + 3) / 2 = 2.5
	 *
	 * Design a data structure that supports the following two operations:
	 *
	 * void addNum(int num) - Add a integer number from the data stream to the data structure.
	 * double findMedian() - Return the median of all elements so far.
	 *
	 *
	 * Example:
	 *
	 * addNum(1)
	 * addNum(2)
	 * findMedian() -> 1.5
	 * addNum(3)
	 * findMedian() -> 2
	 */

	/** initialize your data structure here. */
	private PriorityQueue<Integer> leftMaxHeap;
	private PriorityQueue<Integer> rightMinHeap;
	private int size;

	public MedianFinder() {
		leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
		rightMinHeap = new PriorityQueue<>();
		size = 0;
	}

	//左边是最大堆,右边是最小堆,add的时候要满足最大堆头部小于最小堆的头部.
	//如果size是偶数,则最终需要添加一个元素到最大堆中,但是可能要加入的的数字比右侧大,所以先加入到最小堆中,然后最小堆中取出最小值加入到最大堆中.
	//size是奇数同理
	public void addNum(int num) {
		if (size % 2 == 0) {
			rightMinHeap.offer(num);
			leftMaxHeap.offer(rightMinHeap.poll());
		} else {
			leftMaxHeap.offer(num);
			rightMinHeap.offer(leftMaxHeap.poll());
		}
		size++;
	}

	public double findMedian() {
		if (size % 2 == 0) {
			return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
		} else {
			return leftMaxHeap.peek();
		}
	}
}