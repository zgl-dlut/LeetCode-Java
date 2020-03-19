package com.zgl.leetcode.java.interview.alibaba;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zgl
 * 题目:一个初始值为0的变量,两个线程对其交替操作,一个加1,一个减1,来n轮
 * @date 2020/3/15 下午4:59
 */
public class InteractivePlusMinus {

	private Lock lock = new ReentrantLock();
	private Condition plusCondition = lock.newCondition();
	private Condition minusCondition = lock.newCondition();
	private int count = 0;

	public static void main(String[] args) {
		InteractivePlusMinus interactivePlusMinus = new InteractivePlusMinus();
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				interactivePlusMinus.plus();
			}
		}, "偶数thread").start();
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				interactivePlusMinus.minus();
			}
		}, "奇数thread").start();
	}

	private void plus() {
		lock.lock();
		try {
			while (count != 0) {
				plusCondition.await();
			}
			System.out.println(Thread.currentThread().getName() + ":" + count);
			count++;
			minusCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void minus() {
		lock.lock();
		try {
			while (count != 1) {
				minusCondition.await();
			}
			System.out.println(Thread.currentThread().getName() + ":" + count);
			count--;
			plusCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
