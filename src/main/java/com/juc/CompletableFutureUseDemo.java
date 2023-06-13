package com.juc;

import java.util.concurrent.*;

/**
 * @Author: Aaron
 * @Date: 2023/6/13 15:27
 */
public class CompletableFutureUseDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t ------ come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---------1s 后出结果： " + result);
            if (result > 5) {
                int i = 10/0;
            }
            return result;
        }, threadPool).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("--------- 计算完成，更新系统： " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("异常情况： " + e.getCause() + "\t " + e.getMessage());
            return null;
        });

        System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务了");
        threadPool.shutdown();
//        future1();
    }

    private static void future1() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t ------ come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---------1s 后出结果： " + result);
            return result;
        });

        System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务了");

        System.out.println(completableFuture.get());
    }
}
