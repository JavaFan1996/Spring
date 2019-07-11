package com.atguigu.spring.beans.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans-properties.xml");


        DataSource dataSource = (DataSource) context.getBean("dataSource");

        Connection connection = dataSource.getConnection();
        System.out.println(connection);


    }
}
