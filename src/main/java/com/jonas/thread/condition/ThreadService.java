package com.jonas.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadService {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始等待A:" + System.currentTimeMillis());
            conditionA.await();
            System.out.println(Thread.currentThread().getName() + "结束等待A:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalA() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始唤醒A:" + System.currentTimeMillis());
            conditionA.signal();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "结束唤醒A:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始等待B:" + System.currentTimeMillis());
            conditionB.await();
            System.out.println(Thread.currentThread().getName() + "结束等待B:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalB() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始唤醒B:" + System.currentTimeMillis());
            conditionB.signal();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "结束唤醒B:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
