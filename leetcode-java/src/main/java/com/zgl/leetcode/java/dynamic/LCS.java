package com.zgl.leetcode.java.dynamic;

/**
 * 最长公共子串
 * @author zgl
 * @date 2018/12/8 下午6:46
 */
public class LCS {
	public int lengthOfLCS(String s1,String s2){
		/**
		 * dp[i][j]表示s1第i个元素和s2第j个元素的最长公共子串
		 */
		int[][]dp=new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<=s1.length();i++){
			for(int j=1;j<=s2.length();j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
		for(int i=0;i<=s1.length();i++){
			for(int j=0;j<=s2.length();j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		LCS mock=new LCS();
		String s1="123456";
		String s2="a234asfaf";
		System.out.println(mock.lengthOfLCS(s1,s2));
	}
}
