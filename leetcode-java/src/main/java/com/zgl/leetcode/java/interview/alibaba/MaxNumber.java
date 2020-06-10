package com.zgl.leetcode.java.interview.alibaba;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zgl
 * @date 2020/3/10 下午10:09
 */
public class MaxNumber {
	public static void main(String[] args) {
	 	int[] nums = {9,3,32,33,303};
		System.out.println(new MaxNumber().getMax(nums));
		System.out.println(new MaxNumber().maxNumber(nums));
		System.out.println("33_3".compareTo("33_4"));
	}

	/**
	 * ﻿ 输入一个非负的整形数组，然后输出使用输入数组里的元素组合成的最大数字
	 *  如：输入[45, 9 ,7]，输出字符串 “9745”
	 *  另外，输入数组可以有重复的数字
	 */
	 public String maxNumber(int[] nums) {
		//456 453 45,45
		//45645453
		int n = nums.length;
		StringBuilder result = new StringBuilder();
		String[] strArray = new String[n];
		Map<String, String> countMap = new HashMap<>();
		int maxLength = 0;
		for(int i = 0; i < n; i++){
			strArray[i] = String.valueOf(nums[i]);
			maxLength = Math.max(maxLength, strArray[i].length());
		}
		String[] newStrArray = new String[n];
		for (int i = 0; i < n; i++) {
			newStrArray[i] = strArray[i];
			String lastChar = strArray[i].substring(strArray[i].length() - 1, strArray[i].length());
			//填充长度至数组中元素的最大长度(填充最后一位)
			//比如2,21结果应该是221,而不是212,所以2填充成22而不是20或者其他
			for(int j = 0; j < maxLength - strArray[i].length(); j++) {
				newStrArray[i] += lastChar;
			}
			//有重复的元素也要put到map中,此时需要构造不同的key,顺序需要保证自然顺序
			if(countMap.containsKey(newStrArray[i])) {
				newStrArray[i] += "_" + i;
			}
			countMap.put(newStrArray[i], strArray[i]);
		}
		Arrays.sort(newStrArray);
		for(int i = n - 1; i >= 0; i--) {
			result.append(countMap.get(newStrArray[i]));
		}
		return result.toString();
	}

	//错误的
	public String getMax(int[] nums) {
		String[] numStr = new String[nums.length];
		for(int i = 0;i<nums.length;++i){
			numStr[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(numStr, Comparator.reverseOrder());
		StringBuilder stringBuilder = new StringBuilder();
		for (String num : numStr) {
			stringBuilder.append(num);
		}
		return stringBuilder.toString();
	}
}