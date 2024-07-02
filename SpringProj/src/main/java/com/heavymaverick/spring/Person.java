package com.heavymaverick.spring;

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

    }
    public Person(Pet pet) {
        this.pet = pet;
    }
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet " + pet.toString());
        this.pet = pet;
    }
    public void callYourPet(){
        System.out.println("Pet, hello");
        pet.say();
    }
}
