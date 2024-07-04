package com.heavymaverick.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog myDog = context.getBean("myPet", Dog.class);
        Dog myDog2 = context.getBean("myPet", Dog.class);
//        myDog.setName("Belka");
//        myDog2.setName("Strelka");

        context.close();
    }
}
