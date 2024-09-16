package org.example.car;

public class Car implements Drivable{
    String brand;
    String model;
    int year;
    boolean isRunning;

    public Car (String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.isRunning = false;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String brand() {
        return brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String model() {
        return model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }


    @Override
    public void start() {
        if(!isRunning) {
            isRunning = true;
            System.out.println("Машина едет");
        } else {
            System.out.println("Машина уже едет");
        }

    }

    @Override
    public void stop() {
        if (isRunning) {
            isRunning = false;
            System.out.println("Машина остановилась");
        } else {
            System.out.println("Машина уже стоит");
        }
    }

    @Override
    public void drive(int distance) {
            if (isRunning) {
                System.out.println("Проехала " + distance + " км.");
            } else {
                System.out.println("Машина стоит, езжайте.");
            }
    }
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
