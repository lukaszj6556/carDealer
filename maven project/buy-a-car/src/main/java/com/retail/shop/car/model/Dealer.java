package com.retail.shop.car.model;

import java.util.List;

public class Dealer {
    private List<Car> cars;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String allCars = "";
        for (Car car : cars) {
            allCars += car.toString();
        }
        return "Dealer [Cars=" + allCars + ", Name=" + name + "]";
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}