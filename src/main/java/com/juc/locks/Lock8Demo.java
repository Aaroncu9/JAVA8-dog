package com.juc.locks;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Aaron
 * @Date: 2023/6/15 14:07
 * @Description: LOCK 8
 */
public class Lock8Demo {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone.sendEmail();
        }).start();

        new Thread(() ->{
            phone2.sendMessage();
        }).start();

        new Thread(phone::hello).start();
    }
}

class Phone {
    public static synchronized void sendEmail() {
        try{TimeUnit.SECONDS.sleep(3);}catch (Exception e) {e.printStackTrace();}
        System.out.println("---------------sendEmail");
    }

    public static synchronized void sendMessage() {
        System.out.println("----------------sendMessage");
    }

    public void hello() {
        System.out.println("-----------------hello");
    }
}
