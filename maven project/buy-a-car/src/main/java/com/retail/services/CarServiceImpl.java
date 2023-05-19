package com.retail.services;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.retail.shop.car.model.Car;
import com.retail.shop.car.repository.CarRepositoryImpl;
import com.retail.shop.car.repository.CarRepository;

public class CarServiceImpl implements CarService {
    private CarRepository carRepository = new CarRepositoryImpl();

    // public CarServiceImpl(CarRepository carRepository) throws StreamReadException, DatabindException, IOException {
    //     this.carRepository = CarRepositoryImpl.getInstance();
    // }

    @Override
    public List<Car> getAllCarsCars() {
        return carRepository.getAllCars();
    }

    @Override
    public Car getCaryById(int id) {
        return carRepository.getCarById(id);
    }

    @Override
    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    @Override
    public void remove(int id) {
        carRepository.remove(id);
    }
}
