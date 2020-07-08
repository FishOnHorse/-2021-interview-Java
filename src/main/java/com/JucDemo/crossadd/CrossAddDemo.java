package com.JucDemo.crossadd;

public class CrossAddDemo {

    public static int addnum = 1;
    private static String oddLock = "abc";

    public static class AThread implements Runnable{

        @Override
        public void run() {
            while(addnum<=20){
                synchronized (oddLock) {
                    if (addnum % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + addnum);
                        addnum = addnum + 1;
                        oddLock.notify();
                    }
                    try {
                        oddLock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + "等待异常");
                    }
                }
            }
            synchronized (oddLock) {
                oddLock.notify();
            }
        }
    }

    public static class BThread implements Runnable{

        @Override
        public void run() {
            while(addnum<=20){
                synchronized (oddLock) {
                    if (addnum % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + addnum);
                            addnum = addnum + 1;
                            oddLock.notify();
                    }
                    try {
                        oddLock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + "等待异常");
                    }
                }
            }
            synchronized (oddLock) {
                oddLock.notify();
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new AThread(),"ThreadA").start();
        new Thread(new BThread(),"ThreadB").start();
        synchronized (oddLock) {
            oddLock.notifyAll();
        }
    }
}
