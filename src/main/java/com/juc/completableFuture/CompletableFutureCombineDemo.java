package com.juc.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Aaron
 * @Date: 2023/6/15 11:18
 * @Description: CompletableFuture 计算合并
 */
public class CompletableFutureCombineDemo {

    public static void main(String[] args) {

        CompletableFuture<Integer> temp1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 25;
        });


        CompletableFuture<Integer> temp2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 69;
        });

        CompletableFuture<Integer> result = temp1.thenCombine(temp2, Integer::sum);

        System.out.println(result.join());
    }
}
