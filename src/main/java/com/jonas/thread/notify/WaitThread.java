package com.jonas.thread.notify;

/**
 * 线程的wait/notify机制
 */
public class WaitThread extends Thread {
    // 每个对象实例都有一个监视器
    private Object lock;

    public WaitThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println(getName() + "开始等待:" + System.currentTimeMillis());
                lock.wait();
                System.out.println(getName() + "结束等待:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
