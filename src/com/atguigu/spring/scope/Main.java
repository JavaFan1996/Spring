package com.atguigu.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans-scope.xml");

        Car car = (Car) context.getBean("car");
        Car car1 = (Car) context.getBean("car");
        System.out.println(car == car1);  // true 则是同一个car 默认是单例的 每次获取都是同一个


    }
}
