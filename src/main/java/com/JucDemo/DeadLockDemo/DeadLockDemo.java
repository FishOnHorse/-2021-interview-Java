package com.JucDemo.DeadLockDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class shareResource{
    Lock lockA = new ReentrantLock();
    Lock lockB = new ReentrantLock();
    public void procA(){
        try {
            lockA.lock();
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName()+"\t get lock A");
            lockB.lock();
            System.out.println(Thread.currentThread().getName()+"\t get lock B");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockB.unlock();
            lockA.unlock();
        }
    }

    public void procB(){
        try {
            lockB.lock();
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName()+"\t get lock B");
            lockA.lock();
            System.out.println(Thread.currentThread().getName()+"\t get lock A");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockA.unlock();
            lockB.unlock();
        }
    }
}


public class DeadLockDemo {
    public static void main(String[] args) {
        shareResource sr = new shareResource();
        ExecutorService threadPool = new ThreadPoolExecutor(2,3,1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2));
        threadPool.execute(()->{
            sr.procA();
        });
        threadPool.execute(()->{
            sr.procB();
        });
    }
}
