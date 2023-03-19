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

public class CarRepository{

    private Dealer data;

    public CarRepository() throws StreamReadException, DatabindException, IOException
    {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        mapper.findAndRegisterModules();

        data = mapper.readValue(new File("src/database.yaml"), Dealer.class);
    }

    public List<Car> GetAllCars()
    {
        return data.Cars;
    }

    public Car GetCarById(int id)
    {
        return data.Cars.stream().filter(car -> car.id == id).findAny().get();
    }

    public void AddCar(Car car)
    {
        data.Cars.add(car);
    }

    public void Remove(int id)
    {
        Car carToRemove = data.Cars.stream().filter(car -> car.id == id).findAny().get();
        data.Cars.remove(carToRemove);
    }
}