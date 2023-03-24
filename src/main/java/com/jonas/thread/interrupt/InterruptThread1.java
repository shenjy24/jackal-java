package com.jonas.thread.interrupt;

public class InterruptThread1 extends Thread {

    private final long start = System.currentTimeMillis();

    @Override
    public void run() {
        while (System.currentTimeMillis() - start <= 2000) {
        }
    }

    public static void testInterrupted() {
        InterruptThread1 thread = new InterruptThread1();
        thread.start();
        thread.interrupt();
        // Thread.interrupted(): 静态方法，检测的是当前线程(此处为main线程)是否中断。该方法会清除中断标志
        System.out.println("是否停止1：" + thread.interrupted());
        System.out.println("是否停止2：" + thread.interrupted());
    }

    public static void testIsInterrupted() {
        InterruptThread1 thread = new InterruptThread1();
        thread.start();
        thread.interrupt();
        // 实例方法，该方法不会清除中断标志
        System.out.println("是否停止1：" + thread.isInterrupted());
        System.out.println("是否停止2：" + thread.isInterrupted());
    }

    public static void main(String[] args) {
        testInterrupted();
        testIsInterrupted();
    }
}
