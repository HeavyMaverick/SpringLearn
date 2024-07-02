package com.heavymaverick.spring;

public class Cat implements Pet{
    @Override
    public void say() {
        System.out.printf("mew");
    }
}
