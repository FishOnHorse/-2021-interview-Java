package com.Jvm.HelloGC;

public class HelloGC {


    public static void main(String[] args) throws InterruptedException {
        long total_memory = Runtime.getRuntime().totalMemory();
        long max_memory = Runtime.getRuntime().maxMemory();
        System.out.println("total_memory:\t"+total_memory);
        System.out.println("max_memory:\t"+max_memory);
//        Thread.sleep(Integer.MAX_VALUE);
    }
}
