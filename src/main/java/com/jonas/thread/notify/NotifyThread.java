package com.jonas.thread.notify;

public class NotifyThread extends Thread {

    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println(getName() + "开始等待:" + System.currentTimeMillis());
                lock.notify();
                sleep(5000);
                System.out.println(getName() + "结束等待:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
