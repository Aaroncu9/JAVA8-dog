package com.juc.completableFuture;

import javax.lang.model.element.VariableElement;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Aaron
 * @Date: 2023/6/15 11:23
 * @Description: CompletableFutureCombine
 */
public class CompletableFutureCombineDemo2 {

    public static void main(String[] args) {
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t --------come in 1");
            return 10;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t --------come in 2");
            return 20;
        }), (x, y) -> {
            System.out.println(Thread.currentThread().getName() + "\t --------come in 3");
            return x + y;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t --------come in 4");
            return 30;
        }), (x, y) -> {
            System.out.println(Thread.currentThread().getName() + "\t --------come in 5");
            return x + y;
        });

        System.out.println(result.join());
    }
}
