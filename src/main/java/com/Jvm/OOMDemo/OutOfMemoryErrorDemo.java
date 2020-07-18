package com.Jvm.OOMDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class OutOfMemoryErrorDemo {

    static class OOMTest{

    }
    public static void main(String[] args) {
        /**
         * java heap space
         * vm: -Xms10m -Xmx10m
         */
//        byte[] bytes = new byte[20*1024*1024];

        /**
         * GC limited exceed
         * vm: -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
         */
//        int i=0;
//        List<String> list = new ArrayList<String>();
//        try {
//            while(true){
//                list.add(String.valueOf(++i).intern());
//            }
//        } catch (Throwable e) {
//            System.out.println("========================"+i+"===========================");
//            throw e;
//        }

        /**
         *unable to create new native thread
         *
         */

        /**
         * metaspace
         * vm -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
         */

//        PriorityQueue<Integer>
        Scanner in = new Scanner(System.in);

    }
}
