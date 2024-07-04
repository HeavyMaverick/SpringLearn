package com.heavymaverick.spring;

import org.springframework.stereotype.Component;

//@Component("catBean")
public class Cat implements Pet{

    private void init(){
        System.out.println("Cat init");
    }
    private void destroy(){
        System.out.println("Cat destroy");
    }
    public Cat(){
        System.out.println("Cat bean is created");
    }
    @Override
    public void say() {
        System.out.println("mew");
    }

    @Override
    public String toString() {
        return "CAT";
    }
}
