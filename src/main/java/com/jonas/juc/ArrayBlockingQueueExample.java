package com.jonas.juc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue是一个基于数组实现的有界阻塞队列。
 * ArrayBlockingQueue一旦创建，容量就无法变更。队列满时，生产者线程会被阻塞；队列空时，消费者线程会被阻塞。
 */
public class ArrayBlockingQueueExample {

    private ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(10);

    private void produce() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("arrayBlockingQueue.size()=" + blockingQueue.size());
            blockingQueue.put(i);
            Thread.sleep(100);
        }
    }

    private void consumer() throws InterruptedException {
        while (true) {
            System.out.println(blockingQueue.take());
        }
    }

    public static void main(String[] args) {
        ArrayBlockingQueueExample app = new ArrayBlockingQueueExample();
        new Thread(() -> {
            try {
                app.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                app.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
