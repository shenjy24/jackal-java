package com.jonas.thread.terminate;

/**
 * 使用 volatile 标识位停止线程
 */
public class TerminalThread2 extends Thread {

    private volatile boolean stop = false;

    @Override
    public void run() {
        while (true) {
            if (stop) {
                System.out.println("线程停止");
                return;
            }
        }
    }

    public static void main(String[] args) {
        try {
            TerminalThread2 thread = new TerminalThread2();
            thread.start();
            Thread.sleep(1000);
            thread.stop = true;
            thread.join();
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
