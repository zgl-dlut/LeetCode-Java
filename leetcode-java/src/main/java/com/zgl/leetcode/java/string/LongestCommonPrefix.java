package com.zgl.leetcode.java.string;

/**
 * @author zgl
 * @date 2018/12/20 下午3:47
 */
public class LongestCommonPrefix {
	/**
	 * 14. Longest Common Prefix
	 * Write a function to find the longest common prefix string amongst an array of strings.
	 *
	 * If there is no common prefix, return an empty string "".
	 *
	 * Example 1:
	 *
	 * Input: ["flower","flow","flight"]
	 * Output: "fl"
	 * Example 2:
	 *
	 * Input: ["dog","racecar","car"]
	 * Output: ""
	 * Explanation: There is no common prefix among the input strings.
	 * Note:
	 *
	 * All given inputs are in lowercase letters a-z.
	 */
	public String longestCommonPrefix(String[] strs) {
		/*StringBuilder result=new StringBuilder();
		if (strs.length==0){
			return "";
		}
		int minLength=strs[0].length();
		for(int i=1;i<strs.length;i++){
			minLength=Math.min(minLength,strs[i].length());
		}
		boolean flag;
		for(int i=0;i<minLength;i++){
			char tag=strs[0].charAt(i);
			flag=true;
			for(int j=1;j<strs.length;j++){
				if(strs[j].charAt(i)!=tag){
					flag=false;
					break;
				}
			}
			if (!flag){
				break;
			}
			result.append(tag);
		}
		return result.toString();
	}*/
		if (strs.length==0){
			return "";
		}

		for(int i=0;i<strs[0].length();i++){
			char tag=strs[0].charAt(i);
			for(int j=1;j<strs.length;j++){
				if(i==strs[j].length()||strs[j].charAt(i)!=tag){
					return strs[0].substring(0,i);
				}
			}
		}
		return strs[0];
	}
	public static void main(String[] args) {
		LongestCommonPrefix mock=new LongestCommonPrefix();
		String[]strs={"aa","a"};
		System.out.println(mock.longestCommonPrefix(strs));
		String s="sadasd";
	}
}
