package com.zgl.leetcode.java.interview.alibaba;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * @author zgl
 * @date 2020/3/15 下午11:45
 */
public class PrintTaskWithSemaphore {

	private Thread[] threads;
	private Semaphore[] semaphores;
	private int count;
	private int totalCount;
	private int size;
	private PrintTaskWithSemaphore(int n, int totalCount) {
		threads = new Thread[n];
		semaphores = new Semaphore[n];
		this.totalCount = totalCount;
		count = 0;
		this.size = n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		if (size == 0) {
			return;
		}
		int totalCount = sc.nextInt();
		if (totalCount == 0) {
			return;
		}
		PrintTaskWithSemaphore semaphore = new PrintTaskWithSemaphore(size, totalCount);
		semaphore.printTaskWithSemaphore();
	}

	private void init() {
		for (int i = 0; i < size; i++) {
			semaphores[i] = new Semaphore(1);
			if (i != size - 1) {
				try {
					semaphores[i].acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void printTaskWithSemaphore() {
		init();
		for (int i = 0; i < size; i++) {
			Semaphore last = (i == 0) ? semaphores[size - 1] : semaphores[i - 1];
			Semaphore current = semaphores[i];
			threads[i] = new Thread(() -> {
				while (true) {
					try {
						//获取令牌,减一
						last.acquire();
						if (count > totalCount) {
							release();
							break;
						}
						System.out.println(Thread.currentThread().getName() + ":" + count);
						count++;
						//释放令牌,加一
						current.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, "thread" + i);
			threads[i].start();
		}
	}

	private void release() {
		for (Semaphore semaphore : semaphores) {
			if (semaphore.availablePermits() == 0) {
				semaphore.release();
			}
		}
	}
}