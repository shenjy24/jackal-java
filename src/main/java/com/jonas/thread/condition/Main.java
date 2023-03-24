package com.jonas.thread.condition;

public class Main {
    public static void main(String[] args) {
        try {
            ThreadService service = new ThreadService();
            ThreadA threadA = new ThreadA(service);
            threadA.setName("ThreadA");
            threadA.start();
            ThreadB threadB = new ThreadB(service);
            threadB.setName("ThreadB");
            threadB.start();
            Thread.sleep(100);
            service.signalA();
            // ThreadB未被唤醒，等待中...
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
