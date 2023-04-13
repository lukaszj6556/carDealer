package com.retail.services;

import java.util.List;

import com.retail.shop.car.model.Car;

public interface CarService {

    List<Car> getAllCarsCars();

    Car getCaryById(int id);

    void addCar(Car car);

    void remove(int id);

}