package com.ikun;

import java.util.function.Function;
import java.util.function.IntPredicate;

/**
 * @Author: Aaron
 * @Date: 2023/6/2 15:14
 */
public class LambdaDemo03 {

    public static void main(String[] args) {

        String result = typeConver(s -> s+="ikun");
        System.out.println(result);
    }

    public static <R> R typeConver(Function<String, R> function) {
        String str = "123";
        return function.apply(str);
    }
}
