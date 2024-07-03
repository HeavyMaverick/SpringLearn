package com.heavymaverick.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    private String surname;
    private int age;
    private Pet pet;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(){
        System.out.println("Person bean created");
    }
//    public Person(Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }
    @Autowired
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet " + pet.toString());
        this.pet = pet;
    }
    public void callYourPet(){
        System.out.println("Pet, hello");
        pet.say();
    }
}
