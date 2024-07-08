package com.heavymaverick.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityLibrary universityLibrary = (UniversityLibrary) context.getBean("unibean");
        Book book = (Book) context.getBean("bookBean");
//        universityLibrary.getBook();
        universityLibrary.addBook("adsadad", book);
//        universityLibrary.addMagazine();


        context.close();
    }
}
