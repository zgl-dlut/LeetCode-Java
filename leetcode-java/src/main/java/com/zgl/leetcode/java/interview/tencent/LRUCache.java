package com.zgl.leetcode.java.interview.tencent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zgl
 * @date 2020/6/9 下午4:42
 */
public class LRUCache {

	private Deque<Node> linkedList = new ArrayDeque<>();

	private Map<Integer, Node> hashMap = new HashMap<>();

	private int capacity;

	private int size;

	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
	}

	public int get(int key) {
		if (hashMap.containsKey(key)) {
			Node obtain = hashMap.get(key);
			linkedList.remove(obtain);
			linkedList.addFirst(obtain);
			return obtain.value;
		} else {
			return -1;
		}
	}


	public void put(int key, int value) {
		Node current = new Node(key, value);
		if (hashMap.containsKey(key)) {
			linkedList.remove(hashMap.get(key));
		} else {
			if (size < capacity) {
				size++;
			} else {
				hashMap.remove(linkedList.getLast().key);
				linkedList.removeLast();
			}
		}
		hashMap.put(key, current);
		linkedList.addFirst(current);
	}

}
 class Node{
	int key;
	int value;

	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}