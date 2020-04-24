package com.zgl.leetcode.java.array;

import java.util.*;

/**
 * @author zgl
 * @date 2018/11/26 下午9:05
 */
public class Sort {

	/**
	 * 直接插入排序
	 */
	public int[] directInsertSort(int[] array) {
		int i, j, temp;
		for (i = 1; i < array.length; i++) {
			temp = array[i];
			j = i;
			while (j > 0 && temp < array[j - 1]) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
			for (int k : array) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		return array;
	}
	/**
	 * 折半插入排序
	 */
	public int[] binaryInsertSort(int[] array){
		int left, right, mid, i, j, temp;
		for (i = 1; i < array.length; i++) {
			left = 0;
			right = i - 1;
			while (left <= right) {
				mid = (left + right) / 2;
				if (array[mid] <= array[i]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			temp = array[i];
			for (j = i; j - 1 > right; j--) {
				array[j] = array[j - 1];
			}
			array[right + 1] = temp;
			for (int k : array) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		return array;
	}
	public static void main(String[] args) {
		Sort mock = new Sort();
		int[] numbers = {49, 38, 65, 97, 76, 13, 27, 49};
		//mock.quickSort(numbers, 0, 7);
		mock.heapSort(numbers);
		//System.out.println("传统冒泡排序");
		//mock.bubbleSort(numbers);
		//System.out.println("改进冒泡排序");
		//mock.bubbleSortAdvanced(numbers);
		/*int[] res = mock.mergeSort(numbers,0,7);
		for (int i : res) {
			System.out.print(i + " ");
		}*/
		//mock.heapSort(numbers);
		//mock.directInsertSort(numbers);
		//mock.binaryInsertSort(numbers);
		Map<Integer, Integer> orderMap = new HashMap<>();
		orderMap.put(49, 1);
		orderMap.put(38, 2);
		orderMap.put(65, 3);
		orderMap.put(97, 4);
		List<Integer> list = new ArrayList<>();
		list.add(49);
		list.add(38);
		list.add(65);
		list.add(97);
		/*Collections.sort(list, (Integer o1, Integer o2)-> o2-o1);
		list.sort((Integer o1, Integer o2)-> o2-o1);*/

		list.sort(Comparator.comparingInt(o1 -> orderMap.get(o1)));
		//list.stream().forEach(i -> System.out.println(i));
	}

	/**
	 * 冒泡排序
	 */
	public int[] bubbleSort(int[] numbers) {
		int length = numbers.length;
		int i, j;
		for (i = 0; i < length - 1; i++) {
			boolean flag = false;
			for (j = 0; j < length - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					swap(numbers, j, j + 1);
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
			for (int k : numbers) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		return numbers;
	}

	private void swap(int[] numbers, int i, int j){
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	/**
	 * 简单选择排序
	 */
	public int[] selectSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[min]) {
					min = j;
				}
			}
			swap(numbers, i, min);
		}
		return numbers;
	}
	/**
	 * 快速排序
	 */
	public int[] quickSort(int[] numbers, int left, int right) {
		if (left < right) {
			int partition = partition(numbers, left, right);
			quickSort(numbers, left, partition - 1);
			quickSort(numbers, partition + 1, right);
		}
		return numbers;
	}

	/**
	 * partition求解
	 */
	private int partition(int[] numbers, int left, int right) {
		int pivot = numbers[left];
		while (left < right) {
			while (numbers[right] >= pivot && left < right) {
				right--;
			}
			numbers[left] = numbers[right];
			while (numbers[left] <= pivot && left < right) {
				left++;
			}
			numbers[right] = numbers[left];
		}
		numbers[left] = pivot;
		for (int i : numbers) {
			System.out.print(i + " ");
		}
		System.out.println();
		return left;
	}

	/**
	 * 改进版冒泡排序
	 */
	public int[] bubbleSortAdvanced(int[] numbers) {
		int start = 0, end = numbers.length;
		while (start < end){
			//将最大值放到了末尾
			for(int i = start; i < end - 1; i++){
				if(numbers[i] > numbers[i + 1]){
					swap(numbers, i, i + 1);
				}
			}
			end--;
			//将最小值放到了开头
			for(int i = end; i > start; i--){
				if(numbers[i] < numbers[i - 1]){
					swap(numbers, i - 1, i);
				}
			}
			start++;
			for (int k : numbers) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		return numbers;
	}

	/**
	 * 归并排序分治
	 */
	private void mergePartition(int[] numbers, int left, int middle, int right, int[] temp) {
		int i = left;
		int tag = 0;
		int j = middle + 1;
		while (i <= middle && j <= right) {
			while (i <= middle && numbers[i] <= numbers[j]) {
				temp[tag++] = numbers[i++];
			}
			while (j <= right && numbers[i] > numbers[j]) {
				temp[tag++] = numbers[j++];
			}
		}
		while (i <= middle) {
			temp[tag++] = numbers[i++];
		}
		while (j <= right) {
			temp[tag++] = numbers[j++];
		}
		tag = 0;
		while (left <= right) {
			numbers[left++] = temp[tag++];
		}
		for (int num : numbers) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	/**
	 * 归并排序
	 */
	public int[] mergeSort(int[] numbers, int left, int right) {
		int[] temp = new int[numbers.length];
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(numbers, left, middle);
			mergeSort(numbers, middle + 1, right);
			mergeTwoSortedArray(numbers, left, middle, right, temp);
		}
		return numbers;
	}
	/**
	 * 将元素array[k]自下往上逐步调整树形结构
	 */
	private void adjustDownToUp(int[] array, int k, int length){
		int temp = array[k];
		/**
		 * i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
		 */
		for(int i = 2 * k + 1; i < length - 1; i = 2 * i + 1){
			if(i + 1 < length && array[i] < array[i + 1]){
				i++;
			}
			/**
			 * 根节点 >=左右子女中关键字较大者，调整结束
			 */
			if (temp >= array[i]){
				break;
			}else {
				/**
				 * 将左右子结点中较大值array[i]调整到双亲节点上
				 */
				array[k] = array[i];
				/**
				 * 修改k值，以便继续向下调整
				 */
				k = i;
			}
		}
		array[k] = temp;
	}

	/**
	 * 构建大根堆
	 */
	private int [] buildMaxHeap(int[] array){
		/**
		 * 从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
		 */
		for(int i = (array.length - 2) / 2; i >= 0; i--){
			adjustDownToUp(array, i, array.length);
		}
		return array;
	}

	/**
	 * 堆排序
	 */
	public int[] heapSort(int[] array){
		array = buildMaxHeap(array);
		for(int i = array.length - 1; i > 0; i--){
			swap(array, 0, i);
			adjustDownToUp(array, 0, i);
			for (int num : array) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		return array;
	}

	private void mergeTwoSortedArray(int[] nums, int left, int middle, int right, int[] temp) {
		int i = left, j = middle + 1, tag = 0;
		while (i <= middle && j <= right) {
			temp[tag++] = (nums[i] <= nums[j]) ? nums[i++] : nums[j++];
		}
		while (i <= middle) {
			temp[tag++] = nums[i++];
		}
		while (j <= right) {
			temp[tag++] = nums[j++];
		}
		tag = 0;
		while (left <= right) {
			nums[left++] = temp[tag++];
		}
	}
}
