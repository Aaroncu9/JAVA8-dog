package com.juc.completableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: Aaron
 * @Date: 2023/6/13 13:51
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();
        System.out.println(futureTask.get());
    }

}


class MyThread2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("-------------come in call()  ");
        return "hello callable!";
    }
}
