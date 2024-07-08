package com.heavymaverick.aop.aspects;

import com.heavymaverick.aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("com.heavymaverick.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddBookAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("methodSignature: " + methodSignature);
//        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
//        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
//        System.out.println("methodSignature.getName(): " + methodSignature.getName());
        if (methodSignature.getName().equals("addBook")) {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof Book) {
                    Book book = (Book) arg;
                    System.out.println("Информация о книге: " + book.getName() + ", автор: " + book.getAuthor()
                            + ", год издания: " + book.getYearOfPublication());
                } else if (arg instanceof String) {
                    System.out.println("Книгу в библиотеку добавляет " + arg);
                }
            }
        }

        System.out.println("beforeAddBookAdvice: логирование попытки получить книгу/журнал");
        System.out.println("-----------------------------------");
    }
//    @Pointcut("execution(* com.heavymaverick.aop.UniversityLibrary.get*())")
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* com.heavymaverick.aop.UniversityLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: Log#1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: Log#2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: Log#3");
//    }


}
