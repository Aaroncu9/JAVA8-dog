package com.juc.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Aaron
 * @Date: 2023/6/15 10:33
 * @Description: CompletableFuture 计算速度比较
 */
public class CompletableFutureFastDemo {

    public static void main(String[] args) {

        CompletableFuture<String> runA = CompletableFuture.supplyAsync(() -> {
            System.out.println("A IS COME IN");
            try {
                TimeUnit.SECONDS.sleep(23);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "A";
        });

        CompletableFuture<String> runB = CompletableFuture.supplyAsync(() -> {
            System.out.println("B IS COME IN");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "B";
        });

        CompletableFuture<String> result = runA.applyToEitherAsync(runB, f -> {
            return f + " is winner";
        });

        System.out.println(result.join());

    }
}
