package com.FactoryMethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        AbstractProductFactory abf = new ColaFactory();
        product cola = abf.FactoryMethod();
    }
}
