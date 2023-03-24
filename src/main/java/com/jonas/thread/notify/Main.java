package com.jonas.thread.notify;

public class Main {

    public static void main(String[] args) {
        try {
            // 同一把锁，如果是不同对象则不会生效
            Object lock = new Object();
            WaitThread threadA = new WaitThread(lock);
            threadA.setName("WaitThread");
            threadA.start();
            Thread.sleep(100);
            // 调用 notify 后，NotifyThread线程不会施放锁，因此需要等待NotifyThread线程执行完，
            // WaitThread线程才有机会获得锁继续执行
            NotifyThread threadB = new NotifyThread(lock);
            threadB.setName("NotifyThread");
            threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
