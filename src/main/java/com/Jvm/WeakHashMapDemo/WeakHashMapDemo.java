package com.Jvm.WeakHashMapDemo;

import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void myWeakHash() throws InterruptedException {
        WeakHashMap<Integer,String> weakHashMap = new WeakHashMap<Integer, String>();
        Integer key = new Integer(1);
        weakHashMap.put(key,"weakhashmap");
        System.out.println(weakHashMap);
        System.out.println("=======================================");
//        key = null;
        System.gc();
//        Thread.sleep(1000);
        System.out.println(weakHashMap+""+weakHashMap.size());
    }


    public static void main(String[] args) throws InterruptedException {
        myWeakHash();
    }

}
