package com.zgl.leetcode.java.interview.alibaba;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zgl
 * @date 2020/3/15 下午10:26
 *
 * 题目:多线程之间调用问题,实现A->B->C线程启动,要求如下
 * AA打印5次 BB打印10次 CC打印15次
 * 来10轮
 */

public class PrintABC{

	private Lock lock = new ReentrantLock();
	private Condition printA = lock.newCondition();
	private Condition printB = lock.newCondition();
	private Condition printC = lock.newCondition();
	private int number;
	private int a;
	private int b;
	private int c;
	PrintABC(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.number = a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if (a == 0) {
			return;
		}
		int b = sc.nextInt();
		if (b == 0) {
			return;
		}
		int c = sc.nextInt();
		if (c == 0) {
			return;
		}
		PrintABC printABC = new PrintABC(a, b, c);

		new Thread(() -> {
			for (int i = 0; i < a; i++) {
				printABC.printA();
			}
		}, "threadA").start();

		new Thread(() -> {
			for (int i = 0; i < b; i++) {
				printABC.printB();
			}
		}, "threadB").start();

		new Thread(() -> {
			for (int i = 0; i < c; i++) {
				printABC.printC();
			}
		}, "threadC").start();

	}

	private void printA() {
		lock.lock();
		try {
			while (number != a) {
				printA.await();
			}
			for (int i = 0; i < a; i++) {
				System.out.println(Thread.currentThread().getName() + "===========A");
			}
			number = b;
			printB.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void printB() {
		lock.lock();
		try {
			while (number != b) {
				printB.await();
			}
			for (int i = 0; i < b; i++) {
				System.out.println(Thread.currentThread().getName() + "===========B");
			}
			number = c;
			printC.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void printC() {
		lock.lock();
		try {
			while (number != c) {
				printC.await();
			}
			for (int i = 0; i < c; i++) {
				System.out.println(Thread.currentThread().getName() + "===========C");
			}
			number = a;
			printA.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}