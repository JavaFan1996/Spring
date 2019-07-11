package com.atguigu.spring.beans.cyle;

public class Car {


    public Car() {

        System.out.println("Car's constructor");
    }


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }

    private String brand;

    public void setBrand(String brand) {
        System.out.println("Set Brand");
        this.brand = brand;
    }

    public void init() {


        System.out.println("init....");
    }


    public void destory() {

        System.out.println("destory");

    }
}
