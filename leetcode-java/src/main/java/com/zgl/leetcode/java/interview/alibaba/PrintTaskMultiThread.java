package com.zgl.leetcode.java.interview.alibaba;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zgl
 * @date 2020/3/11 下午5:22
 */
public class PrintTaskMultiThread {
	/**
	 * 多线程：
	 * 如下程序通过N个线程顺序循环打印从0至100，如给定N=3则输出：
	 * thread0: 0
	 * thread1: 1
	 * thread2: 2
	 * thread0: 3
	 * thread1: 4
	 * ..
	 * 注意线程号与输出顺序间的关系
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		if (size == 0) {
			return;
		}
		int count = sc.nextInt();
		if (count == 0) {
			return;
		}
		MyPrintTask printTask = new MyPrintTask(size, count);
		MyPrintTaskLock myPrintTaskLock = new MyPrintTaskLock(size, count);
		for (int i = 0; i < size; i++) {
			int threadNo = i;
			int loop = printTask.getLoopNumber(threadNo + 1);
			new Thread(() -> {
				for (int j = 0; j < loop; j++) {
					printTask.print(threadNo);
					//myPrintTaskLock.print(threadNo);
				}
			}, "thread" + i).start();
		}
	}
}

class MyPrintTask {
	private final Object LOCK = new Object();
	private int value = 0;
	//线程数量
	private int size;
	//0-count
	private int count;

	MyPrintTask(int size, int count) {
		this.size = size;
		this.count = count;
	}

	public int getLoopNumber(int i) {
		int result = (i <= (count + 1) % size) ? ((count + 1) / size) + 1 : (count + 1) / size;
		System.out.println(result);
		return result;
	}

	public void print(int threadNo) {
		synchronized (LOCK) {
			try {
				while (value % size != threadNo) {
					LOCK.wait();
				}
				System.out.println(Thread.currentThread().getName() + ":" + value);
				value++;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				LOCK.notifyAll();
			}
		}
	}
}

class MyPrintTaskLock {
	private int value = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private int size;
	private int count;

	MyPrintTaskLock(int size, int count) {
		this.size = size;
		this.count = count;
	}

	public int getLoopNumber(int i) {
		int result = (i <= (count + 1) % size) ? ((count + 1) / size) + 1 : (count + 1) / size;
		System.out.println(result);
		return result;
	}

	public void print(int threadNo) {
		lock.lock();
		try {
			while (value % size != threadNo) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + ":" + value);
			value++;
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
