package com.atguigu.spring.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法：直接调用某一个类的静态方法就可以返回bean的实例
 */
public class StaticCarFactory {

    private static Map<String, Car> cars = new HashMap<>();

    static {
        cars.put("audi", new Car("Aidi", 500000));
        cars.put("ford", new Car("ford", 500));


    }


    public static Car getCar(String name) {

        return cars.get(name);
    }
}
