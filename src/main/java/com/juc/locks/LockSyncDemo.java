package com.juc.locks;

/**
 * @Author: Aaron
 * @Date: 2023/6/15 15:22
 * @Description: LockSync
 */
public class LockSyncDemo {

    Object object = new Object();
    public void m1() {
        synchronized (object) {
            System.out.println("----------hello synchronized code block");
        }
    }

    public static void main(String[] args) {

    }
}
