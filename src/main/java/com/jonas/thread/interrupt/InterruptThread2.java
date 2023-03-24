package com.jonas.thread.interrupt;

/**
 * 中断睡眠线程。会抛出 InterruptedException 异常，会清除掉中断标记
 */
public class InterruptThread2 extends Thread {

    private final long start = System.currentTimeMillis();

    @Override
    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            // 被中断会清除掉中断标记
            e.printStackTrace();
        }
    }

    public static void testIsInterrupted() {
        try {
            InterruptThread2 thread = new InterruptThread2();
            thread.start();
            thread.interrupt();
            Thread.sleep(100);
            // 实例方法，该方法不会清除中断标志
            System.out.println("是否停止1：" + thread.isInterrupted());
            System.out.println("是否停止2：" + thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testIsInterrupted();
    }
}
