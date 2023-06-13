package com.juc;

import java.util.concurrent.*;

/**
 * @Author: Aaron
 * @Date: 2023/6/13 14:13
 */
public class FutureThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        extracted2();
//          extracted();
    }

    private static void extracted2() throws InterruptedException, ExecutionException {
        // 线程池
        long startTime = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return "task1 over";
        });
        threadPool.submit(futureTask1);

        FutureTask<String> futureTask2 = new FutureTask<String>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return "task1 over";
        });
        threadPool.submit(futureTask2);

        FutureTask<String> futureTask3 = new FutureTask<String>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return "task1 over";
        });
        threadPool.submit(futureTask3);
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask3.get());

        long endTime = System.currentTimeMillis();
        System.out.println("-------cost time: " +  (endTime - startTime));
        threadPool.shutdown();
    }

    private static void extracted() throws InterruptedException {
        // 3个任务，目前只有一个线程main来处理，耗时
        long startTime = System.currentTimeMillis();

        TimeUnit.MILLISECONDS.sleep(500);

        TimeUnit.MILLISECONDS.sleep(500);

        TimeUnit.MILLISECONDS.sleep(500);

        long endTime = System.currentTimeMillis();
        System.out.println("-------cost time: " +  (endTime - startTime));

        System.out.println(Thread.currentThread().getName() + "\t  ----end");
    }
}
