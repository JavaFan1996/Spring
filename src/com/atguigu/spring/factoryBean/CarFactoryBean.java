package com.atguigu.spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;
//自定义的factory要实现FactoryBean接口
public class CarFactoryBean implements FactoryBean {


    private String brand;


    public void setBrand(String brand){
        this.brand = brand;
    }

    //返回bean的对象
    @Override
    public Object getObject() throws Exception {
        return new Car(brand,500000);
    }

    /**
     *
     * @return bean的类型
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
