package com.zgl.leetcode.java.integer;

/**
 * @author zgl
 * @date 2018/12/19 下午1:53
 */
public class IntegerReverse {
	/**
	 * 7. Reverse Integer
	 * Given a 32-bit signed integer, reverse digits of an integer.
	 *
	 * Example 1:
	 *
	 * Input: 123
	 * Output: 321
	 * Example 2:
	 *
	 * Input: -123
	 * Output: -321
	 * Example 3:
	 *
	 * Input: 120
	 * Output: 21
	 * Note:
	 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		int result=0;
		while(x!=0){
			if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10){
				return 0;
			}else {
				result=result*10+x%10;
			}
			x=x/10;
		}
		return result;
	}

	public static void main(String[] args) {
		IntegerReverse mock=new IntegerReverse();
		System.out.println(mock.reverse(1534236469));
	}
}
