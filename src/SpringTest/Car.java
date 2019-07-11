package SpringTest;

import sun.plugin2.main.client.PrintBandDescriptor;

public class Car {


    private String brand;
    private double MaxSpeed;
    private int price;


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", MaxSpeed=" + MaxSpeed +
                ", price=" + price +
                '}';
    }

    public Car(String brand, double maxSpeed, int price) {
        this.brand = brand;
        MaxSpeed = maxSpeed;
        this.price = price;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getMaxSpeed() {
        return MaxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        MaxSpeed = maxSpeed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
