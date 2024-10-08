package com.heavymaverick.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotationConfig {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        context.close();
    }
}
