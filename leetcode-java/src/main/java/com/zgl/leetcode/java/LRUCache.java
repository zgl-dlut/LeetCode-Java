package com.zgl.leetcode.java;

import java.util.*;

/**
 * @author zgl
 * @date 2019/5/17 下午2:34
 */
public class LRUCache{

	/**
	 * 146. LRU Cache
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
	/**
	 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
	 * <p>
	 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
	 * <p>
	 * Follow up:
	 * Could you do both operations in O(1) time complexity?
	 */

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

	private class Node{
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
	}

}