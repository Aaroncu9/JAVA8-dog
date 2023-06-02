package com.ikun;

import java.util.function.IntBinaryOperator;

/**
 * @Author: A
 * @Date: 2023/6/2 15:14
 */
public class LambdaDemo01 {

    public static void main(String[] args) {

        int i = calculateNum((left, right) -> left + right -2);
        System.out.println(i);
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
}
