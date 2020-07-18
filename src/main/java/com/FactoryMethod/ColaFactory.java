package com.FactoryMethod;

public class ColaFactory extends AbstractProductFactory{
    @Override
    public product FactoryMethod(){
        return new cola();
    }
}
