package com.atguigu.spring.beans.cyle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans-cyle.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);


        //关闭IOC
        ClassPathXmlApplicationContext ctx = (ClassPathXmlApplicationContext) context;
        ctx.close();
        

    }
}
