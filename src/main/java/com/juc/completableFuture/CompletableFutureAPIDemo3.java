package com.juc.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: Aaron
 * @Date: 2023/6/15 10:04
 * @Description: completableFutureAPI
 */
public class CompletableFutureAPIDemo3 {

    public static void main(String[] args) {
        System.out.println(CompletableFuture.supplyAsync(() -> {return 2;}).thenRun(()-> System.out.println("111")).join());
        System.out.println(CompletableFuture.supplyAsync(() -> {return 2;}).thenApply((t)-> {return t +1;}).join());
        System.out.println(CompletableFuture.supplyAsync(() -> {return 2;}).thenAccept((t)-> System.out.println(t+1)).join());
    }
}
