package com.retail.services;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.retail.shop.car.model.Car;
import com.retail.shop.car.repository.CarRepository;
import com.retail.shop.car.repository.ICarRepository;

public class CarServiceImpl implements CarService {
    private ICarRepository carRepository;

    public CarServiceImpl(ICarRepository carRepository) throws StreamReadException, DatabindException, IOException {
        this.carRepository = CarRepository.getInstance();
    }

    @Override
    public List<Car> getAllCarsCars() {
        return carRepository.GetAllCars();
    }

    @Override
    public Car getCaryById(int id) {
        return carRepository.GetCarById(id);
    }

    @Override
    public void addCar(Car car) {
        carRepository.AddCar(car);
    }

    @Override
    public void remove(int id) {
        carRepository.Remove(id);
    }
}
