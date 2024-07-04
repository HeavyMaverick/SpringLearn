package com.heavymaverick.aop;

import org.springframework.stereotype.Component;

@Component("unibean")
public class UniversityLibrary extends AbstractLibrary {
    public void getBook(Book book){
        System.out.println("Мы берем книгу из UniversityLibrary " + book.getName());
    }
    public void returnBook(){
        System.out.println("Мы возвращаем книгу в UniversityLibrary");
    }
    public void getMagazine(int abc){
        System.out.println("Мы берем журнал из UniversityLibrary");
    }
}
