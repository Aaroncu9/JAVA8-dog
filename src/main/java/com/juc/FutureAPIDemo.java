package com.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Aaron
 * @Date: 2023/6/13 14:31
 */
public class FutureAPIDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            System.out.println(Thread.currentThread().getName()+ "\t ----come in");
            TimeUnit.SECONDS.sleep(5);
            return "task1 over";
        });
        Thread t1 = new Thread(futureTask1, "t1");
        t1.start();

        System.out.println(Thread.currentThread().getName()+"\t ------ 忙其它任务了");

        // 傻办法2333
        while (true) {
            if (futureTask1.isDone()) {
                System.out.println(futureTask1.get());
                break;
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("正在处理中");
            }
        }
    }
}
