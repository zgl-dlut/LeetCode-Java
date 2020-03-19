package com.zgl.leetcode.java.interview.alibaba;

import java.util.Scanner;

/**
 * @author zgl
 * @date 2020/3/10 下午9:28
 */
public class PrintTask implements Runnable {

	/**
	 * 静态对象用于上锁
	 */
	private static final Object LOCK = new Object();
	/**
	 * 静态变量用于计数
	 */
	private static int count = 0;
	private static int totalCount = 0;
	private int size;
	private String name;
	private int threadId;
	public PrintTask(String name, int threadId, int size) {
		this.name = name;
		this.threadId = threadId;
		this.size = size;
	}

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
		totalCount = count;
		for (int i = 0; i < size; ++i) {
			new Thread(new PrintTask("线程" + i, i, size)).start();
		}
	}

	@Override
	public void run() {
		while (true) {
			synchronized (LOCK) {
				try {
					//因为当线程wait之后，又被唤醒的时候，是从wait后面开始执行，而不是又从头开始执行的，所以如果用if的话，被唤醒之后就不会在判断if中的条件，而是继续往下执行了
					while (count % size != threadId) {
						if (count > totalCount) {
							break;
						}
						LOCK.wait();
					}
					//当前线程抢占,需要判断条件
					if (count > totalCount) {
						break;
					}
					System.out.println(name + ":" + count);
					count++;
					LOCK.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
