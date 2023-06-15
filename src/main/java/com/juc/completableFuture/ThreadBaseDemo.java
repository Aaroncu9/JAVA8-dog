package com.juc.completableFuture;

/**
 * @Author: Aaron
 * @Date: 2023/6/12 11:15
 */
public class ThreadBaseDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("当前线程是否守护线程-->"+ Thread.currentThread().isDaemon());
        }, "thread1");

        thread.start();
    }
}
