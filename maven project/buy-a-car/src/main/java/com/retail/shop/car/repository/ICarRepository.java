package com.retail.shop.car.repository;

import java.util.List;

import com.retail.shop.car.model.Car;

public interface ICarRepository {

    List<Car> GetAllCars();

    Car GetCarById(int id);

    void AddCar(Car car);

    void Remove(int id);

}