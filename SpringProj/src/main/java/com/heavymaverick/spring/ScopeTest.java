package com.heavymaverick.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog myDog = (Dog) context.getBean("dogBean");
        Dog yourDog = (Dog) context.getBean("dogBean");
        System.out.println("Один и тотже? " + (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);

        context.close();
    }
}
