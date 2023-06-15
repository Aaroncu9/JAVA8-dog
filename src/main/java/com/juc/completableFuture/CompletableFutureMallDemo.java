package com.juc.completableFuture;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author: Aaron
 * @Date: 2023/6/13 16:04
 * 案例说明：电商比价需求，模拟如下情况：
 * 1、需求：
 * 1.1 同一款产品，同时搜索出同款产品在各大电商平台的价格
 * 1.2 同一款产品，同时搜索出本产品在同一个电商平台的各个入驻卖家售价
 *
 * 2、输出：出来结果希望是同款产品在不同地方的价格清单列表，返回一个List<String>
 * 3、技术要求
 * 3.1 函数式编程
 * 3.2 链式编程
 * 3.3 Stream流式计算
 */
public class CompletableFutureMallDemo {

    static List<NetMall> netMallList = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("taobao")
    );

    /**
     *  一家一家的搜索
     * @param list
     * @param productName
     * @return list
     */
    public static List<String> getPrice(List<NetMall> list, String productName) {
        return list.stream().map(netMall ->
            String.format("%s in %s price is %.2f",productName, netMall.getNetMallName(), netMall.calcPrice(productName))
        ).collect(Collectors.toList());
    }

    /**
     *  分任务搜索
     * @param list
     * @param productName
     * @return list
     */
    public static List<String> completableFutureGetPrice(List<NetMall> list, String productName) {
        return list.stream().map(netMall ->
            CompletableFuture.supplyAsync(() -> {
               return  String.format("%s in %s price is %.2f",productName, netMall.getNetMallName(), netMall.calcPrice(productName));
            })
        ).collect(Collectors.toList()).stream().map(string ->
            string.join()
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        List<String> priceList = getPrice(netMallList, "mysql");
        for (String price : priceList) {
            System.out.println(price);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("-------------cost time : " + (endTime - startTime) + "  毫秒");

        System.out.println("---------------------------------------------------");

        long startTime2 = System.currentTimeMillis();
        List<String> priceList2 = completableFutureGetPrice(netMallList, "mysql");
        for (String price : priceList2) {
            System.out.println(price);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("-------------cost time : " + (endTime2 - startTime2) + "  毫秒");
    }
}

class NetMall {
    @Getter
    private String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public double calcPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ThreadLocalRandom.current().nextInt(100) + ThreadLocalRandom.current().nextDouble();
    }
}



