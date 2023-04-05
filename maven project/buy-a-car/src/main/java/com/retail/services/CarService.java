package com.retail.services;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.retail.shop.car.model.Car;
import com.retail.shop.car.repository.CarRepository;
import com.retail.shop.car.repository.ICarRepository;

public class CarService implements ICarService {
    private ICarRepository carRepository;

    public CarService(ICarRepository carRepository) throws StreamReadException, DatabindException, IOException {
        this.carRepository = CarRepository.getInstance();
    }

    @Override
    public List<Car> GetAllCarsCars() {
        return carRepository.GetAllCars();
    }

    @Override
    public Car GetCaryById(int id) {
        return carRepository.GetCarById(id);
    }

    @Override
    public void AddCar(Car car) {
        carRepository.AddCar(car);
    }

    @Override
    public void Remove(int id) {
        carRepository.Remove(id);
    }
}
