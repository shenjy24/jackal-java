package com.jonas.thread.condition;

public class ThreadA extends Thread {
    private ThreadService service;

    public ThreadA(ThreadService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}
