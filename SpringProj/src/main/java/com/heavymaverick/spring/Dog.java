package com.heavymaverick.spring;

public class Dog implements Pet{
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    private void init(){
        System.out.println("Dog init");
    }
    private void destroy(){
        System.out.println("Dog destroy");
    }

    public Dog(){
        System.out.println("Dog bean is created");
    }
    @Override
    public void say(){
        System.out.println("textmessage");
    }
}
