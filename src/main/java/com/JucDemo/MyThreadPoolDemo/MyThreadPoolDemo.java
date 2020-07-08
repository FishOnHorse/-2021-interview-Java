package com.JucDemo.MyThreadPoolDemo;

import java.util.List;
import java.util.concurrent.*;

class ThreadA implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t 线程执行");
        return 1;
    }
}


public class MyThreadPoolDemo {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        ThreadA t1 = new ThreadA();
        List<Future<Integer>> resultlist = new CopyOnWriteArrayList<Future<Integer>>();
        for (int i = 0; i <10 ; i++) {
            try {
                Future<Integer> f = threadPool.submit(t1);
                resultlist.add(f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int result = 0;
        for (Future<Integer> f:resultlist) {
            try {
                result+=f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("result:"+result);
        return;
    }

}
