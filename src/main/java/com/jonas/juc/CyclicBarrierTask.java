package com.jonas.juc;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier的作用是让一组线程到达一个屏障时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。
 */
public class CyclicBarrierTask implements Runnable {

    private static final int THREAD_NUM = 4;
    //4个工作线程到达屏障后，会执行Task对应的任务
    private final CyclicBarrier barrier = new CyclicBarrier(THREAD_NUM, this);
    //用于存储每个线程的计算结果
    private final Map<String, Integer> threadResult = new ConcurrentHashMap<>();

    public void count() {
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(() -> {
                threadResult.put(Thread.currentThread().getName(), 1);
                try {
                    //表示已经完成业务，到达屏障
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void run() {
        //对工作线程的结果进行汇总
        int total = threadResult.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println(total);
    }

    public static void main(String[] args) {
        new CyclicBarrierTask().count();
    }
}
