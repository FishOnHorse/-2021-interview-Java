package com.JucDemo.SpinLockDemo;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

    private AtomicReference<Object> spinlock = new AtomicReference<>();
    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"进来了");
        while(!spinlock.compareAndSet(null,thread)){

        }
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        while(!spinlock.compareAndSet(thread,null)){

        }
        System.out.println(thread.getName()+"出去了");
    }

    public static void main(String[] args) {
        final SpinLockDemo mylock = new SpinLockDemo();
        new Thread(()->{
            mylock.lock();
            try{
                Thread.currentThread().sleep(5000);
            }catch (Exception e){
                System.out.println("sleep");
            }
            mylock.unlock();
        },"thread1").start();

        try{
            Thread.currentThread().sleep(1000);
        }catch (Exception e){
            System.out.println("sleep");
        }
        mylock.lock();
        mylock.unlock();
    }
}
