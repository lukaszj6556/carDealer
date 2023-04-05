package com.retail.services;

import java.util.List;

import com.retail.shop.car.model.Car;

public interface ICarService {

    List<Car> GetAllCarsCars();

    Car GetCaryById(int id);

    void AddCar(Car car);

    void Remove(int id);

}