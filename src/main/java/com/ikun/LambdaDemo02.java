package com.ikun;

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/**
 * @Author: Aaron
 * @Date: 2023/6/2 15:14
 */
public class LambdaDemo02 {

    public static void main(String[] args) {

        printNum(value -> value%2 == 0);
    }

    public static void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if(predicate.test(i)) {
                System.out.println(i);
            }
        }
    }
}
