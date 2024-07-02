package com.heavymaverick.spring;

public class Cat implements Pet{
    @Override
    public void say() {
        System.out.println("mew");
    }

    @Override
    public String toString() {
        return "CAT";
    }
}
