package com.retail.shop.car.repository;

import java.util.List;

import com.retail.dbConnection.Connection;
import com.retail.dbConnection.MapperFactory;
import com.retail.shop.car.model.Car;

public class CarRepositoryImpl implements CarRepository{
    private MapperFactory mapperFactory = new MapperFactory();
    private Connection connection = new Connection(mapperFactory);

    @Override
    public List<Car> getAllCars()
    {
        return connection.getAllCars();
    }

    @Override
    public Car getCarById(int id)
    {
        return connection.getCarById(id);
    }

    @Override
    public void addCar(Car car)
    {
        connection.addCar(car);
    }

    @Override
    public void remove(int id)
    {
        connection.removeCar(id);
    }
}