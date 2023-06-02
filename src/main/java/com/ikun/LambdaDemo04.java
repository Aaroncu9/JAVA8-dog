package com.ikun;

import java.util.function.Function;
import java.util.function.IntConsumer;

/**
 * @Author: A
 * @Date: 2023/6/2 15:14
 */
public class LambdaDemo04 {

    public static void main(String[] args) {

        foreachArr(System.out::println);
    }

    public static void foreachArr(IntConsumer consumer) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }
}
