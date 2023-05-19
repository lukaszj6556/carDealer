package com.retail.shop.car.repository;

import java.util.List;

import com.retail.shop.car.model.Car;

public interface CarRepository {

    List<Car> getAllCars();

    Car getCarById(int id);

    void addCar(Car car);

    void remove(int id);
}