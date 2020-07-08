package com.Jvm.SoftReferenceDemo;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceDemo {

    /**
     * 内存够用的情况
     */
    public static void SoftRef_Memory_Enough(){
        Object o1 = new Object();
//        SoftReference<Object> softReference = new SoftReference<Object>(o1);
        WeakReference<Object> softReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }


    public static void SoftRef_Memory_NotEnough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        try{
           byte[] newByte = new byte[30*1024*1024];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }

    }

    public static void main(String[] args) {
        SoftRef_Memory_Enough();
//        SoftRef_Memory_NotEnough();
    }
}
