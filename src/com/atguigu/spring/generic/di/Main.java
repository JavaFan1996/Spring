package com.atguigu.spring.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {


    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans-genenric-di.xml");

        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
