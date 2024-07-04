package com.heavymaverick.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(public void getBook(com.heavymaverick.aop.Book))")
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: Попытка получить книгу");
    }

    @Before("execution(public void returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: Попытка вернуть книгу");
    }
}
