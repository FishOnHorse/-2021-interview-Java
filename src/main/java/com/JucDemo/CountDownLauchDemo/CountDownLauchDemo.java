package com.JucDemo.CountDownLauchDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLauchDemo {
    public static CountDownLatch cdl = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                cdl.countDown();
            }).start();
        }
        cdl.await();
        System.out.println("main");
    }
}
