package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/9/23 下午8:08
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {1,3,4,5,9,12,14};
		BinarySearch mock = new BinarySearch();
		System.out.println(mock.binarySearch(nums, 5));
	}

	/**
	 * 普通二分法查找
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] numbers, int target) {
		int n = numbers.length;
		if (n == 0) {
			return -1;
		}
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (numbers[mid] == target) {
				return mid;
			} else if (numbers[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public int binarySearchRecursion(int[] numbers, int target) {
		int n = numbers.length;
		if (n == 0) {
			return -1;
		}
		return helper(numbers, 0, n - 1, target);
	}

	private int helper(int[] nums, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] < target) {
			return helper(nums, left + 1, right, target);
		} else {
			return helper(nums, left, right - 1, target);
		}
	}

	/**
	 * 查找第一个值等于给定的元素
	 */
	public int binaryFirstEqualSearch1(int[] numbers, int target) {
		int n = numbers.length;
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (numbers[mid] < target) {
				left = mid + 1;
			} else if (numbers[mid] > target) {
				right = mid - 1;
			} else {
				if (mid == 0 || numbers[mid - 1] != target) {
					return mid;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	public int binaryFirstEqualSearch(int[] numbers, int target) {
		int n = numbers.length;
		int left = 0;
		int right = n;
		while (left < right) {
			int mid = (left + right) / 2;
			if (numbers[mid] == target) {
				right = mid;
			} else if (numbers[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return numbers[left] == target ? left : -1;
	}

	/**
	 * 查找最后一个值等于给定值的元素
	 */
	public int binaryLastEqualSearch(int[] nums, int target) {
		int n = nums.length;
		if (n == 0) {
			return -1;
		}
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				if (right == n - 1 || nums[mid + 1] != target) {
					return mid;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}

	public int binaryLastEqualSearch1(int[] numbers, int target) {
		int n = numbers.length;
		int left = 0;
		int right = n;
		while (left < right) {
			int mid = (left + right) / 2;
			if (numbers[mid] == target) {
				left = mid + 1;
			} else if (numbers[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return numbers[left - 1] == target ? left - 1 : -1;
	}
	/**
	 * 查找第一个大于等于给定值得元素
	 * @param nums
	 * @param target
	 * @return
	 */
	public int binaryFirstGreaterSearch(int[] nums, int target) {
		int n = nums.length;
		if (n == 0) {
			return -1;
		}
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				if (mid == 0 || nums[mid -  1] < target) {
					return mid;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	/**
	 * 查找最后一个小于等于给定值的元素
	 * @param nums
	 * @param target
	 * @return
	 */
	public int binaryLastSmallerSearch(int[] nums, int target) {
		int n = nums.length;
		if (n == 0) {
			return -1;
		}
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				if (mid == n - 1 || nums[mid + 1] > target) {
					return mid;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
}