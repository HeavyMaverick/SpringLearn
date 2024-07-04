package com.heavymaverick.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.heavymaverick.aop")
@EnableAspectJAutoProxy
public class MyConfig {

}
