package com.heavymaverick.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("dogBean")
public class Dog implements Pet{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @PostConstruct
    private void init(){
        System.out.println("Dog init");
    }
    @PreDestroy
    private void destroy(){
        System.out.println("Dog destroy");
    }

    public Dog(){
        System.out.println("Dog bean is created");
    }
    @Override
    public void say(){
        System.out.println("DogDogDogDogDogDogDogDogDogDog");
    }
}
