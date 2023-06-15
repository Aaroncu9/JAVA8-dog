package com.juc.completableFuture;

import java.util.concurrent.*;

/**
 * @Author: Aaron
 * @Date: 2023/6/15 10:16
 * @Description: completableFuture 结合 线程池
 */
public class CompletableFutureWithThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1号任务: \t" + Thread.currentThread().getName());
            return "abc";
        },threadPool).thenRun(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2号任务: \t" + Thread.currentThread().getName());
        }).thenRunAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3号任务: \t" + Thread.currentThread().getName());
        }).thenRun(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4号任务: \t" + Thread.currentThread().getName());
        }).thenRun(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("5号任务: \t" + Thread.currentThread().getName());
        });

        System.out.println(completableFuture.get(2, TimeUnit.SECONDS));

        threadPool.shutdown();

    }
}
