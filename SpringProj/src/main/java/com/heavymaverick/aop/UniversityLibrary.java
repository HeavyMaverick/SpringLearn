package com.heavymaverick.aop;

import org.springframework.stereotype.Component;

@Component("unibean")
public class UniversityLibrary extends AbstractLibrary {
    public void getBook(){
        System.out.println("Мы берем книгу из UniversityLibrary ");
        System.out.println("-----------------------------------");
    }
    public String returnBook(){
        //int a = 10 / 0;
        System.out.println("Мы возвращаем книгу в UniversityLibrary");
        return "Война и мир";
    }
    public void getMagazine(){
        System.out.println("Мы берем журнал из UniversityLibrary");
        System.out.println("-----------------------------------");
    }
    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал в UniversityLibrary");
        System.out.println("-----------------------------------");
    }
    public void addBook(String person_name, Book book){
        System.out.println("Мы добавялем книгу в UniversityLibrary");
        System.out.println("-----------------------------------");
    }
    public void addMagazine(){
        System.out.println("Мы добавляем журнал в UniversityLibrary");
        System.out.println("-----------------------------------");
    }
}
