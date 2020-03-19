package com.zgl.leetcode.java.interview.alibaba;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zgl
 * @date 2020/3/10 下午11:03
 */
public class PrintOddEden {

	/**
	 * 两个线程交替打印0~100的奇偶数：
	 * 偶线程：0
	 * 奇线程：1
	 * 偶线程：2
	 * 奇线程：3
	 */
	public static void main(String[] args) {
		SolutionTask solutionTask = new SolutionTask();
		new Thread(() -> {
			for (int i = 0; i < 50; i++) {
				solutionTask.printOdd();
			}
		}, "奇数").start();
		new Thread(() -> {
			for (int i = 0; i < 51; i++) {
				solutionTask.printEven();
			}
		}, "偶数").start();

		/*ShareData shareData = new ShareData();
		new Thread(() -> {
			for (int i = 0; i < 50; i++) {
				shareData.printOdd();
			}
		}, "奇数").start();
		new Thread(() -> {
			for (int i = 0; i < 51; i++) {
				shareData.printEven();
			}
		}, "偶数").start();*/
	}
}

class SolutionTask {
	private final Object LOCK = new Object();
	private int value = 0;

	public void printOdd() {
		synchronized (LOCK) {
			try {
				while (value % 2 == 0) {
					LOCK.wait();
				}
				System.out.println(Thread.currentThread().getName() + ":" + value);
				value++;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				LOCK.notify();
			}
		}
	}

	public void printEven() {
		synchronized (LOCK) {
			try {
				while (value % 2 != 0) {
					LOCK.wait();
				}
				System.out.println(Thread.currentThread().getName() + ":" + value);
				value++;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				LOCK.notify();
			}
		}
	}
}

class ShareData {
	private int value = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	public ShareData() {
	}

	public void printOdd() {
		lock.lock();
		try {
			while (value % 2 == 0) {
				condition1.await();
			}
			System.out.println(Thread.currentThread().getName() + "-" + value);
			value++;
			condition2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void printEven() {
		lock.lock();
		try {
			while (value % 2 != 0) {
				condition2.await();
			}
			System.out.println(Thread.currentThread().getName() + "-" + value);
			value++;
			condition1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}