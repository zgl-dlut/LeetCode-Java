package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2018/12/18 上午9:44
 */
public class MedianTwoSortedArrays {
	/**
	 * 4. Median of Two Sorted Arrays
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 *
	 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	 *
	 * You may assume nums1 and nums2 cannot be both empty.
	 *
	 * Example 1:
	 *
	 * nums1 = [1, 3]
	 * nums2 = [2]
	 *
	 * The median is 2.0
	 * Example 2:
	 *
	 * nums1 = [1, 2]
	 * nums2 = [3, 4]
	 *
	 * The median is (2 + 3)/2 = 2.5
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m=nums1.length;
		int n=nums2.length;
		int total=m+n;
		int[] temp=new int[m+n];
		int i=0,j=0,k=0;
		while(i<m&&j<n){
			if(nums1[i]<nums2[j]){
				temp[k]=nums1[i];
				i++;
			}else {
				temp[k]=nums2[j];
				j++;
			}
			k++;
		}
		while(i<m){
			temp[k++]=nums1[i++];
		}
		while (j<n){
			temp[k++]=nums2[j++];
		}
		if(total%2==0) {
			return (temp[(total - 1) / 2] + temp[total / 2]) / 2.0;
		}else {
			return temp[total / 2];
		}
	}

	public static void main(String[] args) {
		MedianTwoSortedArrays mock=new MedianTwoSortedArrays();
		int[]nums1={1,3};
		int[]nums2={};
		System.out.println(mock.findMedianSortedArrays(nums1,nums2));
	}
}
