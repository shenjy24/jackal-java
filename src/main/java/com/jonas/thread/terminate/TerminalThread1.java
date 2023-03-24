package com.jonas.thread.terminate;

/**
 * 使用中断停止线程
 */
public class TerminalThread1 extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                if (interrupted()) {
                    System.out.println("线程发生中断");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("进入MyThread类run方法的catch语句");
        }
    }

    public static void main(String[] args) {
        try {
            TerminalThread1 thread = new TerminalThread1();
            thread.start();
            thread.interrupt();
            thread.join();
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
