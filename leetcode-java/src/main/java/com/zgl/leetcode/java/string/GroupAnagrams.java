package com.zgl.leetcode.java.string;

import java.util.*;

/**
 * @author zgl
 * @date 2019/4/15 下午4:25
 */
public class GroupAnagrams {
	/**
	 * 49. Group Anagrams
	 * Given an array of strings, group anagrams together.
	 * <p>
	 * Example:
	 * <p>
	 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	 * Output:
	 * [
	 * ["ate","eat","tea"],
	 * ["nat","tan"],
	 * ["bat"]
	 * ]
	 * Note:
	 * <p>
	 * All inputs will be in lowercase.
	 * The order of your output does not matter.
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>(strs.length);
		String temp;
		char[] chars;
		List<String> item;
		for (int i = 0; i < strs.length; i++) {
			chars = strs[i].toCharArray();
			Arrays.sort(chars);
			temp = new String(chars);
			if (map.containsKey(temp)) {
				map.get(temp).add(strs[i]);
			} else {
				item = new ArrayList<>();
				item.add(strs[i]);
				map.put(temp, item);
			}
		}
		/*for (List<String> value : map.values()) {
			result.add(value);
		}*/
		result.addAll(map.values());
		return result;
	}

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = new GroupAnagrams().groupAnagrams(strs);
		System.out.println(res);
	}
}