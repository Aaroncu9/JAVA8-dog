package com.leetcode;


/**
 *  author: Aaron
 */
public class Average {
    public static double average(int[] salary) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double sum = 0;
        for(int item : salary) {
            sum += item;
            min = Double.min(min, item);
            max = Double.max(max, item);
        }
        return (sum-min-max)/(salary.length-2);
    }

    public static void main(String[] args) {
        int[] salary = {4000,3000,1000,2000};
        System.out.println(average(salary));
    }
}
