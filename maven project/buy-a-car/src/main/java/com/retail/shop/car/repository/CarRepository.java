package com.retail.shop.car.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.retail.shop.car.model.Car;
import com.retail.shop.car.model.Dealer;

public class CarRepository implements ICarRepository{
    private static ICarRepository instance;
    private Dealer data;

    public static ICarRepository getInstance() throws StreamReadException, DatabindException, IOException {
        if (instance == null) {
            instance = new CarRepository();
        }
        return instance;
    }

    private CarRepository() throws StreamReadException, DatabindException, IOException
    {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        data = mapper.readValue(new File("src/database.yaml"), Dealer.class);
    }

    @Override
    public List<Car> GetAllCars()
    {
        return data.getCars();
    }

    @Override
    public Car GetCarById(int id)
    {
        return data.getCars().stream().filter(car -> car.getId() == id).findAny().get();
    }

    @Override
    public void AddCar(Car car)
    {
        data.getCars().add(car);
    }

    @Override
    public void Remove(int id)
    {
        Car carToRemove = data.getCars().stream().filter(car -> car.getId() == id).findAny().get();
        data.getCars().remove(carToRemove);
    }
}