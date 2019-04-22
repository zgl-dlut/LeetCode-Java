package com.zgl.leetcode.java.array;

import java.util.*;

/**
 * @author zgl
 * @date 2018/11/26 下午9:05
 */
public class Sort {
	/**
	 * 冒泡排序
	 *
	 * @param numbers
	 * @return
	 */
	public int[] bubbleSort(int[] numbers) {
		int length = numbers.length;
		int i, j, temp;
		for (i = 0; i < length - 1; i++) {
			for (j = 0; j < length - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
			for (int k : numbers) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		return numbers;
	}

	/**
	 * 改进版冒泡排序
	 *
	 * @param numbers
	 * @return
	 */
	public int[] bubbleSortAdvanced(int[] numbers) {
		return numbers;
	}

	/**
	 * 快速排序
	 *
	 * @param numbers
	 * @param left
	 * @param right
	 * @return
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
	 *
	 * @param numbers
	 * @return
	 */
	public int partition(int[] numbers, int left, int right) {
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
	 * 归并排序
	 *
	 * @param numbers
	 * @param left
	 * @param right
	 * @return
	 */
	public int[] mergeSort(int[] numbers, int left, int right) {
		int[] temp = new int[numbers.length];
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(numbers, left, middle);
			mergeSort(numbers, middle + 1, right);
			mergePartition(numbers, left, middle, right, temp);
		}
		return numbers;
	}

	/**
	 * 归并排序分治
	 */
	public void mergePartition(int[] numbers, int left, int middle, int right, int[] temp) {
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
			/*if(numbers[i]<=numbers[j]){
				temp[tag++]=numbers[i++];
			}else {
				temp[tag++]=numbers[j++];
			}*/
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

	public static void main(String[] args) {
		Sort mock = new Sort();
		int[] numbers = {49, 38, 65, 97, 76, 13, 27, 49};
		//int[] quickResult = mock.quickSort(numbers, 0, 7);
		//int[] buddleResult = mock.bubbleSort(numbers);
		//int []mergeResult=mock.mergeSort(numbers,0,7);
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
		list.stream().forEach(i -> System.out.println(i));
	}
}
