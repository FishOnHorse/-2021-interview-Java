package com.FactoryMethod;

public class JuiceFactory extends AbstractProductFactory{
    @Override
    public product FactoryMethod() {
        return new juice();
    }
}
