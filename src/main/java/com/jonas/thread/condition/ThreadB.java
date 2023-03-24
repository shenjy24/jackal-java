package com.jonas.thread.condition;

public class ThreadB extends Thread {
    private ThreadService service;

    public ThreadB(ThreadService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
