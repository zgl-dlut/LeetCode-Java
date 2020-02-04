package com.zgl.leetcode.java.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zgl
 * @date 2019/11/3 下午3:58
 *
 * Trie树，又称为字典树、单词查找树或者前缀树，是一种用于快速检索的多叉数结构。
 * 例如，英文字母的字典树是26叉数，数字的字典树是10叉树。
 * Trie树的基本性质有三点，归纳为：
 *
 * 根节点不包含字符，根节点外每一个节点都只包含一个字符。
 * 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
 * 每个节点的所有子节点包含的字符串不相同。
 *
 */
public class Trie {

	private TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		int length = word.length();
		char[] c = word.toCharArray();
		int index = 0;
		TrieNode p = root;
		for (; index < length; index++) {
			TrieNode next = p.next.get(c[index]);
			if (next != null) {
				p = next;
			} else {
				break;
			}
		}
		for (; index < length; index++) {
			TrieNode newNode = new TrieNode();
			p.next.put(c[index], newNode);
			p = newNode;
		}
		p.isLeaf = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		int length = word.length();
		char[] c = word.toCharArray();
		TrieNode p = root;
		for (int i = 0; i < length; i++) {
			TrieNode next = p.next.get(c[i]);
			if (next == null) {
				return false;
			} else {
				p = next;
			}
		}
		return p.isLeaf;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		int length = prefix.length();
		char[] c = prefix.toCharArray();
		TrieNode p = root;
		for (int i = 0; i < length; i++) {
			TrieNode next = p.next.get(c[i]);
			if (next == null) {
				return false;
			} else {
				p = next;
			}
		}
		return true;
	}

	/**
	 * 208. Implement Trie (Prefix Tree)
	 * Trie trie = new Trie();
	 *
	 * trie.insert("apple");
	 * trie.search("apple");   // returns true
	 * trie.search("app");     // returns false
	 * trie.startsWith("app"); // returns true
	 * trie.insert("app");
	 * trie.search("app");     // returns true
	 */

	class TrieNode {
		private boolean isLeaf;
		private Map<Character, TrieNode> next;
		public TrieNode() {
			next = new HashMap<>();
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("abd");
	}
}