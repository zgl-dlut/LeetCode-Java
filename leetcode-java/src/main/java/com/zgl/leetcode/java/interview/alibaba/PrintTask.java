package com.zgl.leetcode.java.interview.alibaba;

import java.util.Scanner;

/**
 * @author zgl
 * @date 2020/3/10 下午9:28
 */
public class PrintTask implements Runnable{

	private static Object object; // 静态对象用于上锁
	private static int count = 0; // 静态变量用于计数
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
	private String name;
	private int threadId;
	private int totalCount;


	public PrintTask(Object object,String name, int threadId, int totalCount) {
		PrintTask.object = object;
		this.name = name;
		this.threadId = threadId;
		this.totalCount = totalCount;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Object object = new Object();
		int N = sc.nextInt();
		if (N == 0) {
			return;
		}

		for (int i = 0; i < N; ++i) {
			new Thread(new PrintTask(object,"线程 " + i, i, N)).start();
		}
	}

	@Override
	public void run() {

		synchronized (object) {
			while (count < 100) {
				if (count % totalCount == threadId) {
					System.out.println(this.name + " 打印数字 " + count);
					++count;
					object.notifyAll();
				} else {
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
